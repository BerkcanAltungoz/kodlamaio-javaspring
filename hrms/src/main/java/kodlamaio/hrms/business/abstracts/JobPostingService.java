package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;


import java.util.List;

public interface JobPostingService {
    public DataResult<List<JobPosting>> getAll();
    public DataResult<JobPosting> getByID(int id);
    public Result add(JobPosting jobPosting);
    public Result delete(JobPosting jobPosting);

    public Result setStatusFalseById(int id);
    public DataResult<List<JobPosting>> getAllByStatusIsTrue();
    public DataResult<List<JobPosting>> getAllByStatusIsTrueAndCompanyId(int companyID);
    public DataResult<List<JobPosting>> getAllByStatusIsTrueOrderByDateCreatedAsc();
    public DataResult<JobPosting> getByCompanyId(int companyID);
    public DataResult<JobPosting> getByCompanyName(String companyName);

}
