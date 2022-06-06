package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSchoolDao;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.concretes.ResumeSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeSchoolManager implements ResumeSchoolService {
    private final ResumeSchoolDao resumeSchoolDao;

    @Autowired
    public ResumeSchoolManager(ResumeSchoolDao resumeSchoolDao) {
        this.resumeSchoolDao = resumeSchoolDao;
    }

    @Override
    public DataResult<List<ResumeSchool>> getAll() {
        return new SuccessDataResult<>(resumeSchoolDao.findAll());
    }

    @Override
    public DataResult<List<ResumeSchool>> getAllSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"graduationDate");
        return new SuccessDataResult<>(resumeSchoolDao.findAll(sort));
    }

    @Override
    public Result add(ResumeSchool resumeSchool) {
        resumeSchoolDao.save(resumeSchool);
        return new SuccessResult("Resume School Added");
    }

    @Override
    public Result delete(ResumeSchool resumeSchool) {
        resumeSchoolDao.delete(resumeSchool);
        return new SuccessResult("Resume School Deleted");
    }

    @Override
    public DataResult<ResumeSchool> getById(int id) {
        return new SuccessDataResult<>(resumeSchoolDao.getById(id));
    }

    @Override
    public DataResult<List<ResumeSchool>> getByResumeId(int resumeId) {
        return new SuccessDataResult<>(resumeSchoolDao.getByResumeId(resumeId));
    }
}
