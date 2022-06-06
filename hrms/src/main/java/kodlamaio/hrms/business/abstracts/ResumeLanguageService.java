package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;

import javax.xml.crypto.Data;
import java.util.List;

public interface ResumeLanguageService {
    public DataResult<List<ResumeLanguage>> getAll();
    public Result add(ResumeLanguage resumeLanguage);
    public Result delete(ResumeLanguage resumeLanguage);

    public DataResult<ResumeLanguage> getById(int id);
    public DataResult<List<ResumeLanguage>> getByResumeId(int resumeId);

}
