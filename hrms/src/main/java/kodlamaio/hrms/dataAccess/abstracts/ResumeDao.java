package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao extends JpaRepository<Resume, Integer> {
    public Resume getById(int id);
    public Resume getByEmployeeId(int employeeId);
    public boolean existsByEmployeeId(int employeeId);
}
