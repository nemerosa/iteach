package net.nemerosa.iteach.ui;

import net.nemerosa.iteach.common.Ack;
import net.nemerosa.iteach.common.CommentEntity;
import net.nemerosa.iteach.service.CommentService;
import net.nemerosa.iteach.service.model.Comment;
import net.nemerosa.iteach.ui.model.UIComment;
import net.nemerosa.iteach.ui.model.UICommentCollection;
import net.nemerosa.iteach.ui.model.UICommentForm;
import net.nemerosa.iteach.ui.support.UICommentFormatter;
import net.nemerosa.iteach.ui.support.UIFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comment")
public class UICommentAPIController implements UICommentAPI {

    private final CommentService commentService;
    private final UIFormatter formatter;
    private final UICommentFormatter commentFormatter;

    @Autowired
    public UICommentAPIController(CommentService commentService, UIFormatter formatter, UICommentFormatter commentFormatter) {
        this.commentService = commentService;
        this.formatter = formatter;
        this.commentFormatter = commentFormatter;
    }

    @Override
    @RequestMapping(value = "/{entity}/list/{entityId}", method = RequestMethod.GET)
    public UICommentCollection getComments(Locale locale, @PathVariable CommentEntity entity, @PathVariable int entityId) {
        return new UICommentCollection(
                entity,
                entityId,
                commentService.getComments(entity, entityId)
                        .stream()
                        .map(c -> toUIComment(locale, c))
                        .collect(Collectors.toList())
        );
    }

    @Override
    @RequestMapping(value = "/{entity}/{entityId}", method = RequestMethod.POST)
    public UIComment postComment(Locale locale, @PathVariable CommentEntity entity, @PathVariable int entityId, @RequestBody @Valid UICommentForm form) {
        int id = commentService.postComment(entity, entityId, form.getContent());
        return getComment(locale, entity, id);
    }

    @Override
    @RequestMapping(value = "/{entity}/{commentId}", method = RequestMethod.GET)
    public UIComment getComment(Locale locale, @PathVariable CommentEntity entity, @PathVariable int commentId) {
        return toUIComment(locale, commentService.getComment(entity, commentId));
    }

    @Override
    @RequestMapping(value = "/{entity}/{commentId}", method = RequestMethod.DELETE)
    public Ack deleteComment(Locale locale, @PathVariable CommentEntity entity, @PathVariable int commentId) {
        return commentService.deleteComment(entity, commentId);
    }

    @Override
    @RequestMapping(value = "/{entity}/{commentId}", method = RequestMethod.PUT)
    public UIComment updateComment(Locale locale, @PathVariable CommentEntity entity, @PathVariable int commentId, @RequestBody @Valid UICommentForm form) {
        // Update
        commentService.updateComment(entity, commentId, form.getContent());
        // OK
        return getComment(locale, entity, commentId);
    }

    private UIComment toUIComment(Locale locale, Comment c) {
        return new UIComment(
                c.getId(),
                c.getEntity(),
                c.getId(),
                c.getCreation(),
                c.getUpdate(),
                c.getRawContent(),
                commentFormatter.format(c.getRawContent()),
                formatter.formatDateTime(c.getCreation(), locale),
                formatter.formatDateTime(c.getUpdate(), locale)
        );
    }
}
