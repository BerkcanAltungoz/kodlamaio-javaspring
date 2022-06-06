package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeExperienceDao;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeExperienceManager implements ResumeExperienceService {
    private final ResumeExperienceDao resumeExperienceDao;

    @Autowired
    public ResumeExperienceManager(ResumeExperienceDao resumeExperienceDao) {
        this.resumeExperienceDao = resumeExperienceDao;
    }


    @Override
    public DataResult<List<ResumeExperience>> getAll() {
        return new SuccessDataResult<>(resumeExperienceDao.findAll());
    }

    @Override
    public DataResult<List<ResumeExperience>> getAllSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
        return new SuccessDataResult<>(resumeExperienceDao.findAll(sort));
    }

    @Override
    public Result add(ResumeExperience resumeExperience) {
        resumeExperienceDao.save(resumeExperience);
        return new SuccessResult("Resume Experience Added");
    }

    @Override
    public Result delete(ResumeExperience resumeExperience) {
        resumeExperienceDao.delete(resumeExperience);
        return new SuccessResult("Resume Experience Deleted");
    }

    @Override
    public DataResult<ResumeExperience> getById(int id) {
        return new SuccessDataResult<>(resumeExperienceDao.getById(id));
    }

    @Override
    public DataResult<List<ResumeExperience>> getByResumeId(int resumeId) {
        return new SuccessDataResult<>(resumeExperienceDao.getByResumeId(resumeId));
    }
}
