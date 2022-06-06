package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private final ProgrammingLanguageDao programmingLanguageDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public DataResult<List<ProgrammingLanguage>> getAll() {
        return new SuccessDataResult<>(programmingLanguageDao.findAll());
    }

    @Override
    public Result add(ProgrammingLanguage programmingLanguage) {
        if(existsByName(programmingLanguage.getName()).isSuccess()){
            return new ErrorResult("Language Already Exists");
        }
        else{
            programmingLanguageDao.save(programmingLanguage);
            return new SuccessResult("Language Added");
        }
    }

    @Override
    public Result delete(ProgrammingLanguage programmingLanguage) {
        programmingLanguageDao.delete(programmingLanguage);
        return new SuccessResult("Language Deleted");
    }

    @Override
    public Result existsByName(String name) {
        return programmingLanguageDao.existsByName(name) ? new SuccessResult() : new ErrorResult();
    }

}
