package id.ac.ui.cs.advprog.eshop.service;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.repository.CarInterfaceRepository;

@Service
public class CarDeleteServiceImpl implements CarDeleteService{
    @Autowired
    private CarInterfaceRepository carRepository;
    @Override
    public  void deleteCarById(String carId){
        carRepository.delete(carId);
    }
}
