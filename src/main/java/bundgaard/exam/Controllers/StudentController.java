package bundgaard.exam.Controllers;

import bundgaard.exam.Models.Student;
import bundgaard.exam.Service.SpringDatajpa.StudentJPA;
import bundgaard.exam.Service.SpringDatajpa.SupervisorJPA;
import bundgaard.exam.Service.StudentService;
import bundgaard.exam.Service.SupervisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentJPA studentJPA;
    private SupervisorJPA supervisorJPA;

    public StudentController(StudentJPA studentJPA, SupervisorJPA supervisorJPA) {
        this.studentJPA = studentJPA;
        this.supervisorJPA = supervisorJPA;
    }

    @PostMapping("api/studentservice")
    public ResponseEntity<StudentService> getSearchResults(){
        studentJPA.studentList = studentJPA.findAll();
        System.out.println("api/studentservice kaldt med: ");
        return ResponseEntity.ok(studentJPA);
    }

    @PostMapping("api/createstudent")
    public ResponseEntity<StudentJPA> createStudent(@RequestBody Student student){
        System.out.println("api/createstudent kaldt med ");
        studentJPA.save(student);
        return ResponseEntity.ok(studentJPA);
    }
}