package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    public DataResult<List<ProgrammingLanguage>> getAll();
    public Result add(ProgrammingLanguage programmingLanguage);
    public Result delete(ProgrammingLanguage programmingLanguage);

    public Result existsByName(String name);
}
