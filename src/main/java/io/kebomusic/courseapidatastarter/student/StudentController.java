package io.kebomusic.courseapidatastarter.student;

import io.kebomusic.courseapidatastarter.course.Course;
import io.kebomusic.courseapidatastarter.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    private Map<String, String> getCourseMap() {
        Map<String, String> courseMap = new HashMap<String, String>();

        //Create a map of courseIDs and course names
        for (Course course : courseService.getAllCourses()) {
            courseMap.put(course.getId(), course.getName());
        }

        return courseMap;
    }

    @GetMapping("/getaddstudent")
    public String getAddStudentView(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("courseMap", getCourseMap());

        return "AddStudent";
    }

    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute Student student, Model model) {
        if (StringUtils.isEmpty(student.getId())) {
            student.setId(null);
        }

        student.getCourses().add(student.getCourseID());
        studentService.addStudent(student);
        String message = "**The student " + student.getFirstName() + " " + student.getLastName() + " has been added!**";
        model.addAttribute("message", message);
        model.addAttribute("student", student);
        return "AddStudent";
    }

    @GetMapping("/liststudents")
    public String listAllStudents(Model model) {
        model.addAttribute("students", studentService.retrieveAllStudents());
        return "ListStudents";
    }

    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable String id, Model model) {
        studentService.deleteStudent(id);
        String message = "**The student has been deleted!**";
        model.addAttribute("students", studentService.retrieveAllStudents());
        model.addAttribute("message", message);
        return "ListStudents";
    }

    @GetMapping("/editstudent/{id}")
    public String getStudent(@PathVariable String id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("courseMap", getCourseMap());

        return "AddStudent";

    }
}
