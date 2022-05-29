package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    public Employee getById(int userID);
    public Employee getByIdentityNumber(String identityNumber);
    public Employee getByEmail(String email);
    public boolean existsByEmail(String email);
    public boolean existsByIdentityNumber(String identityNumber);
}
