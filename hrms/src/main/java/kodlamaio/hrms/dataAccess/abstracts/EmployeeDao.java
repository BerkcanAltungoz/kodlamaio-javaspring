package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    public List<Employee> findAll();
    public Employee findByUserID(int employeeID);
    public Employee findByIdentityNumber(String identityNumber);
    public Employee findByEmail(String email);
    public boolean existsByEmail(String email);
    public boolean existsByIdentityNumber(String identityNumber);
}
