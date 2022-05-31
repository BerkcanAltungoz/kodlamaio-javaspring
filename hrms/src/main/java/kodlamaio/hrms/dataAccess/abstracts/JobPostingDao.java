package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
    @Query("UPDATE JobPosting SET status = FALSE WHERE id = :id")
    public void setStatusFalseById(int id);

    public List<JobPosting> getAllByStatusIsTrue();
    public List<JobPosting> getAllByStatusIsTrueAndCompanyId(int companyID);
    public List<JobPosting> getAllByStatusIsTrueOrderByDateCreatedAsc();
    public JobPosting getByCompanyId(int companyID);
    public JobPosting getByCompanyName(String companyName);





}
