package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;

import java.util.List;

public interface SchoolDepartmentService {
    public DataResult<List<SchoolDepartment>> getAll();
    public Result add(SchoolDepartment schoolDepartment);
    public Result delete(SchoolDepartment schoolDepartment);

    public Result existsByName(String name);
}
