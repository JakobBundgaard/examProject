package bundgaard.exam.Controllers;


import bundgaard.exam.Models.Student;
import bundgaard.exam.Models.Supervisor;
import bundgaard.exam.Service.StudentService;
import bundgaard.exam.Service.SupervisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class HomeController {

    private StudentService studentService;
    private SupervisorService supervisorService;


    public HomeController(StudentService studentService, SupervisorService supervisorService) {
        this.studentService = studentService;
        this.supervisorService = supervisorService;

    }

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("supervisors", supervisorService.findAll());
        return "index";
    }

    @RequestMapping(value = "/home/addStudent", method = RequestMethod.POST)
    public String addStudent(Student student, @RequestParam("supervisorName") String supervisorName) {
        Optional<Supervisor> supervisor = supervisorService.findById(Long.parseLong(supervisorName));
        Optional<Student> student1 = studentService.findById(student.getId());
        studentService.save(student);
        return "redirect:/home";
    }


}
