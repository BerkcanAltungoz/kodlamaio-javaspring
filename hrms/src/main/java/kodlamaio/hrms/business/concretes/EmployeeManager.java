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
        return new SuccessDataResult<>(employeeDao.findAll());
    }

    @Override
    public DataResult<Employee> getByID(int userID) {
        return new SuccessDataResult<>(employeeDao.getById(userID));
    }

    @Override
    public DataResult<Employee> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<>(employeeDao.getByIdentityNumber(identityNumber));
    }

    @Override
    public DataResult<Employee> getByEmail(String email) {
        return new SuccessDataResult<>(employeeDao.getByEmail(email));
    }

    @Override
    public Result existsByEmail(String email) {
        return employeeDao.existsByEmail(email) ? new SuccessResult() : new ErrorResult();
    }

    @Override
    public Result existsByIdentityNumber(String identityNumber) {
        return employeeDao.existsByIdentityNumber(identityNumber) ? new SuccessResult() : new ErrorResult();
    }

    @Override
    public Result add(Employee employee) {
       if(!personVerificationService.verify(employee.getIdentityNumber(), employee.getName(), employee.getLastname(), employee.getDateofbirth().getYear()).isSuccess()){
            return new ErrorResult("Mernis Verification Failed");
        }
       else if(!emailVerificationService.verify(employee.getEmail()).isSuccess()){
           return new ErrorResult("Invalid Email Format");
       }
       else if(existsByEmail(employee.getEmail()).isSuccess()){
           return new ErrorResult("Email Already Exists");
       }
       else if(existsByIdentityNumber(employee.getIdentityNumber()).isSuccess()){
           return new ErrorResult("Identity Number Already Exists");
       }
       else{
           employeeDao.save(employee);
           return new SuccessResult("Employee Registration Successful");
       }
    }

    @Override
    public Result delete(Employee employee) {
        employeeDao.delete(employee);
        return new SuccessResult("Employee Deletion Successful");
    }
}
