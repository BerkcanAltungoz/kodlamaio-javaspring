package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping(value = "/get/all")
    public DataResult<List<Position>> getAll(){
        return positionService.getAll();
    }

    @GetMapping(value = "/get/byTitle")
    public DataResult<Position> getByTitle(@RequestParam String title){
        return positionService.getByTitle(title);
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody Position position){
        return positionService.add(position);
    }

    @PostMapping(value = "/delete")
    public Result delete(@RequestParam Position position){
        return positionService.delete(position);
    }
}
