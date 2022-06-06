package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage,Integer> {
    public ResumeLanguage getById(int id);
    public List<ResumeLanguage> getByResumeId(int resumeId);


}
