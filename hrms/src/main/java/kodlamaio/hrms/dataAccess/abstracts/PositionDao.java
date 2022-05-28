package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface PositionDao extends JpaRepository<Position, Integer> {
    public List<Position> findAll();
    public Position findByTitle(String title);
    public boolean existsByTitle(String title);
}
