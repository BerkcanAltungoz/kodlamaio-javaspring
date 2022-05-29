package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {
    public Company getById(int userID);
    public Company getByEmail(String email);
    public boolean existsByEmail(String email);
}
