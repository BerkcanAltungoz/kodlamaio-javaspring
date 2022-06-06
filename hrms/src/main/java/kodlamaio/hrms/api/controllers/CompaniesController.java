package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {
    private final CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<?> getAll(){
        Result result = companyService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping(value = "/get/byID")
    public ResponseEntity<?> getByID(@RequestParam int userID){
        Result result = companyService.getByID(userID);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping(value = "/get/byEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email){
        Result result = companyService.getByEmail(email);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Company company){
        Result result = companyService.add(company);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Company company){
        Result result = companyService.delete(company);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
}
