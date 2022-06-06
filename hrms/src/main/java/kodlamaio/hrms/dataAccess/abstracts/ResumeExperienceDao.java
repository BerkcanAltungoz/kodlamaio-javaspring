package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ResumeExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeExperienceDao extends JpaRepository<ResumeExperience,Integer> {
    public ResumeExperience getById(int id);
    public List<ResumeExperience> getByResumeId(int resumeId);
}
