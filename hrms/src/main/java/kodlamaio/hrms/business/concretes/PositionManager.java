package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {
    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<>(positionDao.findAll());
    }

    @Override
    public DataResult<Position> getByTitle(String title) {
        return new SuccessDataResult<>(positionDao.findByTitle(title));
    }

    @Override
    public Result isTitleExists(String title) {
        return positionDao.existsByTitle(title) ? new SuccessResult() : new ErrorResult();
    }

    @Override
    public Result add(Position position) {
        if(isTitleExists(position.getTitle()).isSuccess()){
            return new ErrorResult("Position Title Already Exists");
        }
        else{
            positionDao.save(position);
            return new SuccessResult("New Position Added");
        }
    }

    @Override
    public Result delete(Position position) {
        positionDao.delete(position);
        return new SuccessResult("Position Deletion Successful");
    }
}
