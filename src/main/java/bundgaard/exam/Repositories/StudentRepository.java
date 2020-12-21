package bundgaard.exam.Repositories;

import bundgaard.exam.Models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
