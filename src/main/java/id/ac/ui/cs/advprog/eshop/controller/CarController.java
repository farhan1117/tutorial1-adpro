package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarCreateService;
import id.ac.ui.cs.advprog.eshop.service.CarFindService;
import id.ac.ui.cs.advprog.eshop.service.CarUpdateService;
import id.ac.ui.cs.advprog.eshop.service.CarDeleteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/car")
class CarController extends ProductController{
    @Autowired
    CarCreateService carCreateService;
    @Autowired
    CarFindService carFindService;
    @Autowired
    CarUpdateService carUpdateService;
    @Autowired
    CarDeleteService carDeleteService;

    @GetMapping("/createCar")
    public String createCarPage(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("createCar")
    public String createCarPost(@ModelAttribute Car car, Model model){
        carCreateService.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model){
        List<Car> allCars = carFindService.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model){
        Car car = carFindService.findById(carId);
        model.addAttribute("car",car);
        return "editCar";
    }

    @PostMapping("/editCar")
    public  String  editCarPost(@ModelAttribute Car car, Model model){
        System.out.println(car.getCarId());
        carUpdateService.update(car.getCarId(), car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public  String deleteCar(@RequestParam("carId") String carId){
        carDeleteService.deleteCarById(carId);
        return "redirect:listCar";
    }

}
