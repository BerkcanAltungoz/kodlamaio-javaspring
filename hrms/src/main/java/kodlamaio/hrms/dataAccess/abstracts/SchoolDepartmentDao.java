package kodlamaio.hrms.dataAccess.abstracts;

import io.swagger.models.auth.In;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer> {
    public boolean existsByName(String name);
}
