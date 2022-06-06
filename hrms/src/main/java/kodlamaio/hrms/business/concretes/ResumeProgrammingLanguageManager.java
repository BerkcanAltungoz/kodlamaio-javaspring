package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeProgrammingLanguageManager implements ResumeProgrammingLanguageService {
    private final ResumeProgrammingLanguageDao resumeProgrammingLanguageDao;

    @Autowired
    public ResumeProgrammingLanguageManager(ResumeProgrammingLanguageDao resumeProgrammingLanguageDao) {
        this.resumeProgrammingLanguageDao = resumeProgrammingLanguageDao;
    }

    @Override
    public DataResult<List<ResumeProgrammingLanguage>> getAll() {
        return new SuccessDataResult<>(resumeProgrammingLanguageDao.findAll());
    }

    @Override
    public Result add(ResumeProgrammingLanguage resumeProgrammingLanguage) {
        resumeProgrammingLanguageDao.save(resumeProgrammingLanguage);
        return new SuccessResult("Resume Language Added");
    }

    @Override
    public Result delete(ResumeProgrammingLanguage resumeProgrammingLanguage) {
        resumeProgrammingLanguageDao.delete(resumeProgrammingLanguage);
        return new SuccessResult("Resume Language Deleted");
    }

    @Override
    public DataResult<ResumeProgrammingLanguage> getById(int id) {
        return new SuccessDataResult<>(resumeProgrammingLanguageDao.getById(id));
    }

    @Override
    public DataResult<List<ResumeProgrammingLanguage>> getByResumeId(int resumeId) {
        return new SuccessDataResult<>(resumeProgrammingLanguageDao.getByResumeId(resumeId));
    }
}
