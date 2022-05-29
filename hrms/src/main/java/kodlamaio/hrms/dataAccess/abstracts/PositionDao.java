package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionDao extends JpaRepository<Position, Integer> {
    public Position getByTitle(String title);
    public boolean existsByTitle(String title);
}
