package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeExperience;

import javax.xml.crypto.Data;
import java.util.List;

public interface ResumeExperienceService {
    public DataResult<List<ResumeExperience>> getAll();
    public DataResult<List<ResumeExperience>> getAllSortedByDate();
    public Result add(ResumeExperience resumeExperience);
    public Result delete(ResumeExperience resumeExperience);

    public DataResult<ResumeExperience> getById(int id);
    public DataResult<List<ResumeExperience>> getByResumeId(int resumeId);
}
