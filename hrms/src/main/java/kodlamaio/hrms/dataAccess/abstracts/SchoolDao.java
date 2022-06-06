package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao extends JpaRepository<School,Integer> {
    public boolean existsByName(String name);
}
