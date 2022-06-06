package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/schoolDepartments")
public class SchoolDepartmentsController {
    private final SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentsController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        Result result = schoolDepartmentService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SchoolDepartment schoolDepartment){
        Result result = schoolDepartmentService.add(schoolDepartment);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@Valid @RequestBody SchoolDepartment schoolDepartment){
        Result result = schoolDepartmentService.delete(schoolDepartment);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }
}
