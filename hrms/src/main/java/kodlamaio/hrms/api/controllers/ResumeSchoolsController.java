package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeSchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.concretes.ResumeSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resumeSchools")
public class ResumeSchoolsController {
    private final ResumeSchoolService resumeSchoolService;

    @Autowired
    public ResumeSchoolsController(ResumeSchoolService resumeSchoolService) {
        this.resumeSchoolService = resumeSchoolService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        Result result = resumeSchoolService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/allSortedByDate")
    public ResponseEntity<?> getAllSortedByDate(){
        Result result = resumeSchoolService.getAllSortedByDate();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ResumeSchool resumeSchool){
        Result result = resumeSchoolService.add(resumeSchool);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@Valid @RequestBody ResumeSchool resumeSchool){
        Result result = resumeSchoolService.delete(resumeSchool);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byId")
    public ResponseEntity<?> getById(@RequestParam int id){
        Result result = resumeSchoolService.getById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byResumeId")
    public ResponseEntity<?> getByResumeId(@RequestParam int resumeId){
        Result result = resumeSchoolService.getByResumeId(resumeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
}
