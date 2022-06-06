package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.concretes.ResumeSchool;

import java.util.List;

public interface ResumeSchoolService {
    public DataResult<List<ResumeSchool>> getAll();
    public DataResult<List<ResumeSchool>> getAllSortedByDate();
    public Result add(ResumeSchool resumeSchool);
    public Result delete(ResumeSchool resumeSchool);

    public DataResult<ResumeSchool> getById(int id);
    public DataResult<List<ResumeSchool>> getByResumeId(int resumeId);
}
