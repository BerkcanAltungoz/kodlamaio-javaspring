package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<?> getAll(){
        Result result = employeeService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping(value = "/get/byID")
    public ResponseEntity<?> getByID(@RequestParam int userID){
        Result result = employeeService.getByID(userID);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping(value = "/get/byIdentityNumber")
    public ResponseEntity<?> getByIdentityNumber(@RequestParam String identityNumber){
        Result result = employeeService.getByIdentityNumber(identityNumber);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping(value = "/get/byEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email){
        Result result = employeeService.getByEmail(email);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody Employee employee){
        Result result = employeeService.add(employee);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@Valid @RequestBody Employee employee){
        Result result = employeeService.delete(employee);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().body(result);
        }
    }

}
