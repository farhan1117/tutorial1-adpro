package id.ac.ui.cs.advprog.eshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarInterfaceRepository;

@Service
public class CarCreateServiceImpl implements CarCreateService{
    @Autowired
    private CarInterfaceRepository carRepository;
    @Override
    public Car create(Car car){
        return car;
    }
}
