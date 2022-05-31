package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    public DataResult<List<City>> getAll();
    public Result add(City city);
    public Result delete(City city);

    public DataResult<City> getByName(String name);
    public Result existsByName(String name);

}
