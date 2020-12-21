package bundgaard.exam.Service.SpringDatajpa;

import bundgaard.exam.Models.Student;
import bundgaard.exam.Models.Supervisor;
import bundgaard.exam.Repositories.SupervisorRepository;
import bundgaard.exam.Service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SupervisorJPA implements SupervisorService {


    private final SupervisorRepository supervisorRepository;


    public SupervisorJPA(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public Set<Supervisor> findAll() {
        Set<Supervisor> supervisors =new HashSet<>();
        supervisorRepository.findAll().forEach(supervisors::add);
        return supervisors;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return supervisorRepository.save(object);
    }

    @Override
    public void delete(Supervisor object) {
        supervisorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        supervisorRepository.deleteById(aLong);
    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return supervisorRepository.findById(aLong);
    }

    @Override
    public List<Supervisor> getSupervisors() {
        List<Supervisor> list = new ArrayList<>();
        supervisorRepository.findAll();
        return list;
    }

}
