package id.ac.ui.cs.advprog.eshop.service;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Car;

public interface CarFindService {
    List<Car> findAll();
    Car findById(String id);
}
