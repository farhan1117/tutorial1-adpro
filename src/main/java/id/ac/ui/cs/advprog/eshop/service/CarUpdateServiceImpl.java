package id.ac.ui.cs.advprog.eshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarInterfaceRepository;

@Service
public class CarUpdateServiceImpl implements CarUpdateService{
    @Autowired
    private CarInterfaceRepository carRepository;
    @Override
    public void update(String carId, Car car){
        carRepository.update(carId, car);
    }
}
