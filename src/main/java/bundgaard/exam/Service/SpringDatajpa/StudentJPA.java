package bundgaard.exam.Service.SpringDatajpa;


import bundgaard.exam.Models.Student;
import bundgaard.exam.Repositories.StudentRepository;
import bundgaard.exam.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentJPA implements StudentService {

    public Set<Student> studentList;
    private final StudentRepository studentRepository;

    public StudentJPA(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Set<Student> findAll() {
        Set<Student> students =new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return studentRepository.findById(aLong);
    }


}

