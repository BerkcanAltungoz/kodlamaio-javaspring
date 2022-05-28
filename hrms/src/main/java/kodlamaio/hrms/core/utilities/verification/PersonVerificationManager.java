package kodlamaio.hrms.core.utilities.verification;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class PersonVerificationManager implements PersonVerificationService{
    @Override
    public Result verify(String identityNumber, String name, String lastname, int yearofbirth) {
        // TODO Implement Mernis Service
        return new SuccessResult();
    }
}
