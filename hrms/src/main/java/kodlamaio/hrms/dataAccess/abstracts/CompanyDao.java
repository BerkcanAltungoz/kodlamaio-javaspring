package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {
    public List<Company> findAll();
    public Company findById(int userID);
    public Company findByEmail(String email);
    public boolean existsByEmail(String email);
}
