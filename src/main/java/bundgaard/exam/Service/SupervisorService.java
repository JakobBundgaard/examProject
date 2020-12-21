package bundgaard.exam.Service;

import bundgaard.exam.Models.Supervisor;

import java.util.List;

public interface SupervisorService extends CrudService<Supervisor, Long> {
    public List<Supervisor> getSupervisors();
}
