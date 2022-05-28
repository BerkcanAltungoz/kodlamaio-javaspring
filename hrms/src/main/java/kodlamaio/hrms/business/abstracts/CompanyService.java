package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

import java.util.List;

public interface CompanyService {

    public DataResult<List<Company>> getAll();
    public DataResult<Company> getByID(int userID);
    public DataResult<Company> getByEmail(String email);
    public Result isEmailExists(String email);
    public Result add(Company company);
    public Result delete(Company company);
}
