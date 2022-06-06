package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguage;

import java.util.List;

public interface ResumeProgrammingLanguageService {
    public DataResult<List<ResumeProgrammingLanguage>> getAll();
    public Result add(ResumeProgrammingLanguage resumeProgrammingLanguage);
    public Result delete(ResumeProgrammingLanguage resumeProgrammingLanguage);

    public DataResult<ResumeProgrammingLanguage> getById(int id);
    public DataResult<List<ResumeProgrammingLanguage>> getByResumeId(int resumeId);
}
