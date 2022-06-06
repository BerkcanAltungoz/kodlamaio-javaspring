package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

import java.util.List;

public interface ResumeService {
    public DataResult<List<Resume>> getAll();
    public Result add(Resume resume);
    public Result delete(Resume resume);

    public DataResult<Resume> getById(int id);
    public DataResult<Resume> getByEmployeeId(int employeeId);
    public Result existsByEmployeeId(int employeeId);
}
