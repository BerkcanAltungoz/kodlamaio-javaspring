package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public List<Job> getAll(){
        return jobService.getAll();
    }
    @PostMapping
    public Result add(@RequestBody Job job){
        return jobService.add(job);
    }
}
