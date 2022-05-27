package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public List<Job> getAll() {
        return jobDao.findAll();
    }

    @Override
    public Result add(Job job) {
        jobDao.save(job);
        return new SuccessResult("Job Added");
    }
}
