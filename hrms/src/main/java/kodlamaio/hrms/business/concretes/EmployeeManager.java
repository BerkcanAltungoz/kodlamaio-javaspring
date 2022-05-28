package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.utilities.verification.EmailVerificationService;
import kodlamaio.hrms.core.utilities.verification.PersonVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmailVerificationService emailVerificationService;
    private PersonVerificationService personVerificationService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, EmailVerificationService emailVerificationService, PersonVerificationService personVerificationService) {
        this.employeeDao = employeeDao;
        this.emailVerificationService = emailVerificationService;
        this.personVerificationService = personVerificationService;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
    }

    @Override
    public DataResult<Employee> getByID(int employeeID) {
        return new SuccessDataResult<Employee>(employeeDao.findByUserID(employeeID));
    }

    @Override
    public DataResult<Employee> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<Employee>(employeeDao.findByIdentityNumber(identityNumber));
    }

    @Override
    public DataResult<Employee> getByEmail(String email) {
        return new SuccessDataResult<Employee>(employeeDao.findByEmail(email));
    }

    @Override
    public Result isEmailExists(String email) {
        return employeeDao.existsByEmail(email) ? new SuccessResult() : new ErrorResult();
    }

    @Override
    public Result isIdentityNumberExists(String identityNumber) {
        return employeeDao.existsByIdentityNumber(identityNumber) ? new SuccessResult() : new ErrorResult();
    }
    @Override
    public Result add(Employee employee) {
        return null;
    }

    @Override
    public Result update(Employee employee) {
        return null;
    }

    @Override
    public Result delete(Employee employee) {
        return null;
    }
}
