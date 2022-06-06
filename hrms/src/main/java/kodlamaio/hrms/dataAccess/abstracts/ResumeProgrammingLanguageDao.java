package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeProgrammingLanguageDao extends JpaRepository<ResumeProgrammingLanguage,Integer> {
    public ResumeProgrammingLanguage getById(int id);
    public List<ResumeProgrammingLanguage> getByResumeId(int resumeId);
}
