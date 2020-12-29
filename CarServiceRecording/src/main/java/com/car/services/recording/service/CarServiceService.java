package com.car.services.recording.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.services.recording.entity.Car;
import com.car.services.recording.entity.Customer;
import com.car.services.recording.entity.Services;
import com.car.services.recording.model.Details;
import com.car.services.recording.repo.CarServiceRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CarServiceService {

	@Autowired
	CarServiceRepo carService;

	public List<Customer> getAllCustomerData() {
		return carService.allCustomerData();
	}

	public JSONObject getAllCar4aCustomerData(int phone) {

		List<Car> cars = carService.allCarServicesDataForaSpecificCustomer(phone);
		String jsonDataString = "{\"CustomerPhone\":" + phone + "}";
		JSONObject mainObject = new JSONObject(jsonDataString);
		JSONObject jsonObject =null;
		if(cars.size()>0)
		 jsonObject = mainObject.accumulate("Data", cars);
		else {
			jsonObject = mainObject.accumulate("Data", "no data Found");
		}
		
		// customer name show also

		return jsonObject;
	}
	
	public JSONObject getAllServices4aCar(String carNo) {

		List<Services> servis = carService.allServicesDataForaSpecificCar(carNo);
		String jsonDataString = "{\"CarNo\":" + carNo + "}";
		JSONObject mainObject = new JSONObject(jsonDataString);
		JSONObject jsonObject = mainObject.accumulate("Data", servis);

		return jsonObject;
	}
	
	
	public int saveRecord(Details details)
	{
		Car car = new Car();
		car.setCar_name(details.getCarName());
		car.setCar_no(details.getCarNo());
		
		int carId= carService.persistCar(car);
		log.info("=== car id: "+carId);
		
		
		Customer customer = new Customer();
		customer.setPhone(details.getCustomerPhone());
		customer.setCustomer_name(details.getCustomerName());
		
		int custId =  carService.persistCustomer(customer);
		log.info("=== Customer id: "+custId);
		
		
		Services services =  new Services();
		services.setCar_id(carId);
		services.setCustomer_id(custId);
		
		int serviceId  = carService.RecordServiceForSpecificCar(services);
		log.info("=== service id: "+serviceId);
		
		
		return serviceId;
	}


}
