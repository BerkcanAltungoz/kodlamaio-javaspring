package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    public List<Job> getAll();
    public Result add(Job job);
}
