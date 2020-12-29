package com.car.services.recording.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.services.recording.entity.Customer;
import com.car.services.recording.model.Details;
import com.car.services.recording.service.CarServiceService;

@RestController
public class CarServiceController {

	@GetMapping("/customers")
	public ResponseEntity<?> allCustomer() {
//1. 
		List<Customer> allCustomer = service.getAllCustomerData();

		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(allCustomer);
	}

	@GetMapping("/allCar4Customer")
	public ResponseEntity<?> allCarServices4aCustomer(@RequestParam int custPhone) {
		// 2.

		JSONObject data = service.getAllCar4aCustomerData(custPhone);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(data.toString());
	}

	@GetMapping("/allService4Car")
	public ResponseEntity<?> allServices4aCar(@RequestParam String carNo) {
		// 3.
		JSONObject data = service.getAllServices4aCar(carNo);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).body(data.toString());
	}

	@PostMapping("/recordCarService")
	public ResponseEntity<?> RecordService4aCar(@RequestBody Details details) {
		// 4.
		int id = service.saveRecord(details);
		return ResponseEntity.status(HttpStatus.CREATED).cacheControl(CacheControl.noCache())
				.body("Data store sucessfully :: service id: " + id);
	}

	@Autowired
	CarServiceService service;

}
