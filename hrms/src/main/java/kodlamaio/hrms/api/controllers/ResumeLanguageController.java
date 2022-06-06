package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/resumeLanguage")
public class ResumeLanguageController {
    private final ResumeLanguageService resumeLanguageService;

    @Autowired
    public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
        this.resumeLanguageService = resumeLanguageService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        Result result = resumeLanguageService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ResumeLanguage resumeLanguage){
        Result result = resumeLanguageService.add(resumeLanguage);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@Valid @RequestBody ResumeLanguage resumeLanguage){
        Result result = resumeLanguageService.delete(resumeLanguage);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byId")
    public ResponseEntity<?> getById(int id){
        Result result = resumeLanguageService.getById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/get/byResumeId")
    public ResponseEntity<?> getByResumeId(int resumeId){
        Result result = resumeLanguageService.getByResumeId(resumeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

}
