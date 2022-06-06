package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resumeProgrammingLanguage")
public class ResumeProgrammingLanguageController {
    private ResumeProgrammingLanguageService resumeProgrammingLanguageService;

    @Autowired
    public ResumeProgrammingLanguageController(ResumeProgrammingLanguageService resumeProgrammingLanguageService) {
        this.resumeProgrammingLanguageService = resumeProgrammingLanguageService;
    }

    public ResponseEntity<?> getAll(){
        Result result = resumeProgrammingLanguageService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
    public ResponseEntity<?> add(@Valid @RequestBody ResumeProgrammingLanguage resumeProgrammingLanguage){
        Result result = resumeProgrammingLanguageService.add(resumeProgrammingLanguage);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
    public ResponseEntity<?> delete(@Valid @RequestBody ResumeProgrammingLanguage resumeProgrammingLanguage){
        Result result = resumeProgrammingLanguageService.delete(resumeProgrammingLanguage);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    public ResponseEntity<?> getById(@RequestParam int id){
        Result result = resumeProgrammingLanguageService.getById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
    public ResponseEntity<?> getByResumeId(@RequestParam int resumeId){
        Result result = resumeProgrammingLanguageService.getByResumeId(resumeId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
}
