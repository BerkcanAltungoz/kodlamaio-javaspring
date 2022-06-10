package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingsController {
    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        Result result = jobPostingService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
    @GetMapping("/get/byID")
    public ResponseEntity<?> getById(@RequestParam int id){
        Result result = jobPostingService.getByID(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobPosting jobPosting){
        Result result = jobPostingService.add(jobPosting);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@Valid @RequestBody JobPosting jobPosting){
        Result result = jobPostingService.delete(jobPosting);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/setStatusFalseById")
    public ResponseEntity<?> setStatusFalseById(@RequestParam int id){
        Result result = jobPostingService.setStatusFalseById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/allByStatusIsTrue")
    public ResponseEntity<?> getAllByStatusIsTrue(){
        Result result = jobPostingService.getAllByStatusIsTrue();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/allByStatusIsTrueAndCompanyId")
    public ResponseEntity<?> getAllByStatusIsTrueAndCompanyId(@RequestParam int companyID){
        Result result = jobPostingService.getAllByStatusIsTrueAndCompanyId(companyID);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/allByStatusIsTrueOrderByDateCreatedAsc")
    public ResponseEntity<?> getAllByStatusIsTrueOrderByDateCreatedAsc(){
        Result result = jobPostingService.getAllByStatusIsTrueOrderByDateCreatedAsc();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byCompanyId")
    public ResponseEntity<?> getByCompanyId(@RequestParam int companyID){
        Result result = jobPostingService.getByCompanyId(companyID);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/ByCompanyName")
    public ResponseEntity<?> getByCompanyName(@RequestParam String companyName){
        Result result = jobPostingService.getByCompanyName(companyName);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
}
