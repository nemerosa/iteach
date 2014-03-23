package net.nemerosa.iteach;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TopController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView home() {
        return new RedirectView("/index.html", true, false, false);
    }

}
