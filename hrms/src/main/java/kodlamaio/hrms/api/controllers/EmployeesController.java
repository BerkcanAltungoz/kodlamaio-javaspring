package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/get/all")
    public DataResult<List<Employee>> getAll(){
        return employeeService.getAll();
    }

    @GetMapping(value = "/get/byID")
    public DataResult<Employee> getByID(@RequestParam int userID){
        return employeeService.getByID(userID);
    }

    @GetMapping(value = "/get/byIdentityNumber")
    public DataResult<Employee> getByIdentityNumber(@RequestParam String identityNumber){
        return employeeService.getByIdentityNumber(identityNumber);
    }

    @GetMapping(value = "/get/byEmail")
    public DataResult<Employee> getByEmail(@RequestParam String email){
        return employeeService.getByEmail(email);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PostMapping(value = "/delete")
    public Result delete(@RequestBody Employee employee){
        return employeeService.delete(employee);
    }

}
