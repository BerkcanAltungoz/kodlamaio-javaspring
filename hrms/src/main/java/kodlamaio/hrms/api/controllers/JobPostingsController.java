package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingsController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/get/all")
    public DataResult<List<JobPosting>> getAll(){
        return jobPostingService.getAll();
    }
    @GetMapping("/get/byID")
    public DataResult<JobPosting> getById(int id){
        return jobPostingService.getByID(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return jobPostingService.add(jobPosting);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobPosting jobPosting){
        return jobPostingService.delete(jobPosting);
    }

    @PostMapping("/setStatusFalseById")
    public Result setStatusFalseById(@RequestParam int id){
        return jobPostingService.setStatusFalseById(id);
    }

    @GetMapping("/get/allByStatusIsTrue")
    public DataResult<List<JobPosting>> getAllByStatusIsTrue(){
        return jobPostingService.getAllByStatusIsTrue();
    }

    @GetMapping("/get/allByStatusIsTrueAndCompanyId")
    public DataResult<List<JobPosting>> getAllByStatusIsTrueAndCompanyId(int companyID){
        return jobPostingService.getAllByStatusIsTrueAndCompanyId(companyID);
    }

    @GetMapping("/get/allByStatusIsTrueOrderByDateCreatedAsc")
    public DataResult<List<JobPosting>> getAllByStatusIsTrueOrderByDateCreatedAsc(){
        return jobPostingService.getAllByStatusIsTrueOrderByDateCreatedAsc();
    }

    @GetMapping("/get/byCompanyId")
    public DataResult<JobPosting> getByCompanyId(int companyID){
        return jobPostingService.getByCompanyId(companyID);
    }

    @GetMapping("/get/ByCompanyName")
    public DataResult<JobPosting> getByCompanyName(String companyName){
        return jobPostingService.getByCompanyName(companyName);
    }
}
