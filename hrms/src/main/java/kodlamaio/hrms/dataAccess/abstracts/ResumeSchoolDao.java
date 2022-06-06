package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ResumeSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeSchoolDao extends JpaRepository<ResumeSchool,Integer> {
    public ResumeSchool getById(int id);
    public List<ResumeSchool> getByResumeId(int resumeId);
}
