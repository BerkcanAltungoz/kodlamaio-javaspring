package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private final ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(resumeDao.findAll());
    }

    @Override
    public Result add(Resume resume) {
        resumeDao.save(resume);
        return new SuccessResult("Resume Added");
    }

    @Override
    public Result delete(Resume resume) {
        resumeDao.delete(resume);
        return new SuccessResult("Resume Deleted");
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<>(resumeDao.getById(id));
    }

    @Override
    public DataResult<Resume> getByEmployeeId(int employeeId) {
        return new SuccessDataResult<>(resumeDao.getByEmployeeId(employeeId));
    }

    @Override
    public Result existsByEmployeeId(int employeeId) {
       return resumeDao.existsByEmployeeId(employeeId) ? new SuccessResult() : new ErrorResult();
    }
}
