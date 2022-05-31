package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }


    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(cityDao.findAll());
    }

    @Override
    public DataResult<City> getByName(String name) {
        return new SuccessDataResult<>(cityDao.getByName(name));
    }

    @Override
    public Result existsByName(String name) {
        return new Result(cityDao.existsByName(name));
    }

    @Override
    public Result add(City city) {
        if(existsByName(city.getName()).isSuccess()){
            return new ErrorResult("City Already Exists");
        }
        else{
            cityDao.save(city);
            return new SuccessResult("New City Added");
        }
    }

    @Override
    public Result delete(City city) {
        cityDao.delete(city);
        return new SuccessResult("City Deleted");
    }
}
