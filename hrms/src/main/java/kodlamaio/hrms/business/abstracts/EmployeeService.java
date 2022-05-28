package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    public DataResult<List<Employee>> getAll();
    public DataResult<Employee> getByID(int userID);
    public DataResult<Employee> getByIdentityNumber(String identityNumber);
    public DataResult<Employee> getByEmail(String email);
    public Result isEmailExists(String email);
    public Result isIdentityNumberExists(String identityNumber);
    public Result add(Employee employee);
    public Result delete(Employee employee);
}
