package id.ac.ui.cs.advprog.eshop.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SimpleTimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarInterfaceRepository;

@Service
public class CarFindServiceImpl implements CarFindService{
    @Autowired
    private CarInterfaceRepository carRepository;
    @Override
    public List<Car> findAll(){
        Iterator<Car> carIterator = carRepository.findAll();
        List<Car> allCar = new ArrayList<>();
        carIterator.forEachRemaining(allCar::add);
        return allCar;
    }
    @Override
    public Car findById(String id){
        return carRepository.findById(id);
    }
}
