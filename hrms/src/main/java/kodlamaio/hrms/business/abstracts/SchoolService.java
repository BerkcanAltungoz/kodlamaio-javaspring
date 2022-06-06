package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    public DataResult<List<School>> getAll();
    public Result add(School school);
    public Result delete(School school);

    public Result existsByName(String name);
}
