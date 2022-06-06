package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(languageDao.findAll());
    }

    @Override
    public Result add(Language language) {
        if(existsByName(language.getName()).isSuccess()){
            return new ErrorResult("Language Already Exists");
        }
        else{
            languageDao.save(language);
            return new SuccessResult("Language Added");
        }
    }

    @Override
    public Result delete(Language language) {
        languageDao.delete(language);
        return new SuccessResult("Language Deleted");
    }

    @Override
    public Result existsByName(String name) {
        return languageDao.existsByName(name) ? new SuccessResult() : new ErrorResult();
    }
}
