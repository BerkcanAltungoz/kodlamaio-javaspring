package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {
    private CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/get/all")
    public DataResult<List<Company>> getAll(){
        return companyService.getAll();
    }

    @GetMapping(value = "/get/byID")
    public DataResult<Company> getByID(@RequestParam int userID){
       return companyService.getByID(userID);
    }

    @GetMapping(value = "/get/byEmail")
    public DataResult<Company> getByEmail(@RequestParam String email){
        return companyService.getByEmail(email);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody Company company){
        return companyService.add(company);
    }

    @PostMapping(value = "/delete")
    public Result delete(@RequestBody Company company){
        return companyService.delete(company);
    }
}
