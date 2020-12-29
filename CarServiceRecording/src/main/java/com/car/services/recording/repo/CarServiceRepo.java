package com.car.services.recording.repo;

import java.util.List;

import com.car.services.recording.entity.Car;
import com.car.services.recording.entity.Customer;
import com.car.services.recording.entity.Services;

public interface CarServiceRepo {

	public List<Customer> allCustomerData();
	
	public List<Car> allCarServicesDataForaSpecificCustomer(int phone);
	
	public List<Services> allServicesDataForaSpecificCar(String carName) ;
	
	public int RecordServiceForSpecificCar(Services services);
	
	public int persistCar(Car car);
	
	public int persistCustomer(Customer customer);
	
}
