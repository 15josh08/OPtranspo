package com.lostandfound.OPtranspo.Controllers;

import java.time.LocalDate;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lostandfound.OPtranspo.Service.DriverService;
@SuppressWarnings("unused")
@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	DriverService driverService;
	@GetMapping("/home")
	public String driverHome() {
		return "Welcome driver!";
	}

	@PostMapping("/additem")
	public ResponseEntity<String> addItem(@RequestParam String name, @RequestParam LocalDate date,
			 @RequestParam int busNumber, @RequestParam String busRoute,
			@RequestParam boolean status,@RequestParam int driverId) {
		driverService.addItem(name,date,busNumber,busRoute,status,driverId);
		return ResponseEntity.ok("Item added susccessfully");
	}

}
