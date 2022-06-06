package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {
    private final SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<>(schoolDepartmentDao.findAll());
    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        if(existsByName(schoolDepartment.getName()).isSuccess()){
            return new ErrorResult("School Department Already Exists");
        }
        else{
            schoolDepartmentDao.save(schoolDepartment);
            return new SuccessResult("School Department Added");
        }
    }

    @Override
    public Result delete(SchoolDepartment schoolDepartment) {
        schoolDepartmentDao.delete(schoolDepartment);
        return new SuccessResult("School Department Deleted");
    }

    @Override
    public Result existsByName(String name) {
        return schoolDepartmentDao.existsByName(name) ? new SuccessResult() : new ErrorResult();
    }
}
