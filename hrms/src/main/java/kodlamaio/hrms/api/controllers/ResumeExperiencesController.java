package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resumeExperiences")
public class ResumeExperiencesController {
    private final ResumeExperienceService resumeExperienceService;

    @Autowired
    public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
        this.resumeExperienceService = resumeExperienceService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        Result result = resumeExperienceService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/allSortedByDate")
    public ResponseEntity<?> getAllSortedByDate(){
        Result result = resumeExperienceService.getAllSortedByDate();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ResumeExperience resumeExperience){
        Result result = resumeExperienceService.add(resumeExperience);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(ResumeExperience resumeExperience){
        Result result = resumeExperienceService.delete(resumeExperience);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byId")
    public ResponseEntity<?> getById(int id){
        Result result = resumeExperienceService.getById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byResumeId")
    public ResponseEntity<?> getByResumeId(int resumeId){
        Result result = resumeExperienceService.getByResumeId(resumeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
}
