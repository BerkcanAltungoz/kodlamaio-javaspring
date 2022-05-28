package kodlamaio.hrms.core.utilities.verification;

import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.stereotype.Service;


public interface PersonVerificationService {
    public Result verify(String identityNumber, String name, String lastname, int yearofbirth);
}
