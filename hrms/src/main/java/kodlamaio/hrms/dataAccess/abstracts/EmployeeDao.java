package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    public List<Employee> findAll();
    public Employee findById(int userID);
    public Employee findByIdentityNumber(String identityNumber);
    public Employee findByEmail(String email);
    public boolean existsByEmail(String email);
    public boolean existsByIdentityNumber(String identityNumber);
}
