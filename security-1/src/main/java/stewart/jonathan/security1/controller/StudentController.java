package stewart.jonathan.security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stewart.jonathan.security1.model.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Tom Hardy"),
            new Student(2, "Henry Cavill"),
            new Student(3, "Alba Baptista")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }
//
//
//    @GetMapping("/")
//    public String home() {
//        return "Hello World";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "Hello user";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "Hello Admin";
//    }
}
