package crud.com.crudexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
        @Autowired
        StudentRepo studentRepo;



        public StudentEntity PostStudent(StudentDto studentDto){
            StudentEntity studentEntity=new StudentEntity();
            studentEntity.setStudentName(studentDto.getStudentName());
            studentEntity.setAddress(studentDto.getAddress());
            studentEntity.setEmailAddress(studentDto.getEmailAddress());
            studentRepo.save(studentEntity);
            return studentEntity;
        }

        public List<StudentEntity> GetStudent(){
             return studentRepo.findAll();
        }

        public StudentEntity GetStudents(int id){
            StudentEntity studentEntity=studentRepo.findById(id).get();
            return studentEntity;
        }

        public void DeleteStudent(int id){
            StudentEntity studentEntity=studentRepo.findById(id).get();
            studentRepo.delete(studentEntity);
        }

    public StudentEntity UpdateStudent(StudentDto studentDto, int id) {
    StudentEntity studentEntity=studentRepo.findById(id).get();
    studentEntity.setStudentName(studentDto.getStudentName());
    studentEntity.setEmailAddress(studentDto.getEmailAddress());
    studentEntity.setAddress(studentDto.getAddress());
    return studentEntity;
    }
}
