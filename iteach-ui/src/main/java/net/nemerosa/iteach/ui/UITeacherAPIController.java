package net.nemerosa.iteach.ui;

import net.nemerosa.iteach.service.TeacherService;
import net.nemerosa.iteach.service.model.School;
import net.nemerosa.iteach.service.model.SchoolForm;
import net.nemerosa.iteach.ui.model.UISchool;
import net.nemerosa.iteach.ui.model.UISchoolCollection;
import net.nemerosa.iteach.ui.model.UISchoolForm;
import net.nemerosa.iteach.ui.model.UISchoolSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Controller for the teacher UI.
 */
@RestController
@RequestMapping("/api/teacher")
public class UITeacherAPIController implements UITeacherAPI {

    private final TeacherService teacherService;

    @Autowired
    public UITeacherAPIController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    @RequestMapping(value = "/school", method = RequestMethod.GET)
    public UISchoolCollection getSchools(Locale locale) {
        List<School> schools = teacherService.getSchools();
        return new UISchoolCollection(
                schools.parallelStream().map(school -> new UISchoolSummary(
                        school.getId(),
                        school.getName(),
                        school.getColour()
                )).collect(Collectors.toList())
        );
    }

    // FIXME Form validation
    @Override
    @RequestMapping(value = "/school", method = RequestMethod.POST)
    public UISchool createSchool(Locale locale, @RequestBody UISchoolForm form) {
        int schoolId = teacherService.createSchool(
                new SchoolForm(
                        form.getName(),
                        form.getColour(),
                        form.getContact(),
                        form.toHourlyRate(),
                        form.getPostalAddress(),
                        form.getPhone(),
                        form.getMobilePhone(),
                        form.getEmail(),
                        form.getWebSite()
                )
        );
        return getSchool(locale, schoolId);
    }

    @Override
    @RequestMapping(value = "/school/{schoolId}", method = RequestMethod.POST)
    public UISchool getSchool(Locale locale, @PathVariable int schoolId) {
        School o = teacherService.getSchool(schoolId);
        return new UISchool(
                o.getId(),
                o.getName(),
                o.getColour(),
                o.getContact(),
                o.getHourlyRate(),
                o.getPostalAddress(),
                o.getPhone(),
                o.getMobilePhone(),
                o.getEmail(),
                o.getWebSite()
        );
    }
}
