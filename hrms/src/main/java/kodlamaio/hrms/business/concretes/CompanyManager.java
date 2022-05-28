package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.utilities.verification.EmailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;
    private EmailVerificationService emailVerificationService;

    @Autowired
    public CompanyManager(CompanyDao companyDao, EmailVerificationService emailVerificationService) {
        this.companyDao = companyDao;
        this.emailVerificationService = emailVerificationService;
    }


    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<>(companyDao.findAll());
    }

    @Override
    public DataResult<Company> getByID(int userID) {
        return new SuccessDataResult<>(companyDao.findById(userID));
    }

    @Override
    public DataResult<Company> getByEmail(String email) {
        return new SuccessDataResult<>(companyDao.findByEmail(email));
    }

    @Override
    public Result isEmailExists(String email) {
        return companyDao.existsByEmail(email) ? new SuccessResult() : new ErrorResult();
    }

    @Override
    public Result add(Company company) {
        if(!emailVerificationService.verify(company.getEmail()).isSuccess()){
            return new ErrorResult("Invalid Email Format");
        }
        else if(isEmailExists(company.getEmail()).isSuccess()){
            return new ErrorResult("Email Already Exists");
        }
        else{
            companyDao.save(company);
            return new SuccessResult("Company Registration Successful");
        }
    }

    @Override
    public Result delete(Company company) {
        companyDao.delete(company);
        return new SuccessResult("Company Deletion Successful");
    }
}
