package crud.com.crudexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/Student")
    public StudentEntity postStudent(@RequestBody StudentDto studentDto){
        return studentService.PostStudent(studentDto);
    }

    @GetMapping("/AllStudents")
    public List<StudentEntity> getAllStudents(){
        return studentService.GetStudent();
    }

    @GetMapping("/Student/{id}")
    public StudentEntity getStudent(@PathVariable int id){
        return studentService.GetStudents(id);
    }

    @DeleteMapping("/student/{id}")
    public void  deleteStudent(@PathVariable int id){
    studentService
            .DeleteStudent(id);
    }

    @PutMapping("/student/{id}")
        public  StudentEntity UpdateStudent(@RequestBody StudentDto studentDto,@PathVariable int id){
        return studentService.UpdateStudent(studentDto,id);
    }


}
