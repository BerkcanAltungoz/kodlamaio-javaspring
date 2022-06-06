package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        if(existsByName(school.getName()).isSuccess()){
            return new ErrorResult("School Already Exists");
        }
        else{
            schoolDao.save(school);
            return new SuccessResult("School Added");
        }
    }

    @Override
    public Result delete(School school) {
        schoolDao.delete(school);
        return new SuccessResult("School Deleted");
    }

    @Override
    public Result existsByName(String name) {
        return schoolDao.existsByName(name) ? new SuccessResult() : new ErrorResult();
    }
}
