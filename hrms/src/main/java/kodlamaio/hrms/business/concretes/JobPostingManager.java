package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {
    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }


    @Override
    public DataResult<List<JobPosting>> getAll() {
        return new SuccessDataResult<>(jobPostingDao.findAll());
    }

    @Override
    public DataResult<JobPosting> getByID(int id) {
        return new SuccessDataResult<>(jobPostingDao.findById(id).get());
    }

    @Override
    public Result add(JobPosting jobPosting) {
        jobPostingDao.save(jobPosting);
        return new SuccessResult("New Job Posting Added");
    }

    @Override
    public Result delete(JobPosting jobPosting) {
        jobPostingDao.delete(jobPosting);
        return new SuccessResult("Job Posting Deleted");
    }

    @Override
    public Result setStatusFalseById(int id) {
        jobPostingDao.setStatusFalseById(id);
        return new SuccessResult("Job Posting Closed");
    }
    @Override
    public DataResult<List<JobPosting>> getAllByStatusIsTrue() {
        return new SuccessDataResult<>(jobPostingDao.getAllByStatusIsTrue());
    }

    @Override
    public DataResult<List<JobPosting>> getAllByStatusIsTrueAndCompanyId(int companyID) {
        return new SuccessDataResult<>(jobPostingDao.getAllByStatusIsTrueAndCompanyId(companyID));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByStatusIsTrueOrderByDateCreatedAsc() {
        return new SuccessDataResult<>(jobPostingDao.getAllByStatusIsTrueOrderByDateCreatedAsc());
    }

    @Override
    public DataResult<JobPosting> getByCompanyId(int companyID) {
        return new SuccessDataResult<>(jobPostingDao.getByCompanyId(companyID));
    }

    @Override
    public DataResult<JobPosting> getByCompanyName(String companyName) {
        return new SuccessDataResult<>(jobPostingDao.getByCompanyName(companyName));
    }


}
