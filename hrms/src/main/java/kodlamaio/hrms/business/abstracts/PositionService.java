package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {

    public DataResult<List<Position>> getAll();
    public DataResult<Position> getByTitle(String title);
    public Result isTitleExists(String title);
    public Result add(Position position);
    public Result delete(Position position);
}
