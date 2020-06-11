package com.self.parkinglot.controller;


import com.self.parkinglot.domain.EnterIn;
import com.self.parkinglot.domain.EnterOut;
import com.self.parkinglot.dao.ParkingRepo;
import com.self.parkinglot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    ParkingRepo repo;


    @RequestMapping("/parking/{carNumber}")
    public List<EnterOut> getCost(@PathVariable("carNumber") int carNumber) {
        ParkingService service = new ParkingService();
        return service.calculateCost(carNumber);
    }


    @PostMapping("/parking")
    @ResponseBody
    public EnterIn saveParking(EnterIn eIn) {
        repo.save(eIn);
        return eIn;
    }
}
