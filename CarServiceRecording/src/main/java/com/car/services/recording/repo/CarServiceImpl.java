package com.car.services.recording.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.car.services.recording.entity.Car;
import com.car.services.recording.entity.Customer;
import com.car.services.recording.entity.Services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CarServiceImpl implements CarServiceRepo {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Customer> allCustomerData() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> customr = cq.from(Customer.class);

		cq.select(customr);
		TypedQuery<Customer> tq = entityManager.createQuery(cq);
		List<Customer> customerData = tq.getResultList();

		return customerData;
	}

	@Override
	public List<Car> allCarServicesDataForaSpecificCustomer(int phn) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);
		Root<Customer> cust = cq.from(Customer.class);
		Root<Services> servis = cq.from(Services.class);
		Root<Car> car = cq.from(Car.class);

		cq.select(car).where(cb.equal(cust.get("id"), servis.get("customer_id")),
				cb.equal(car.get("id"), servis.get("car_id")), cb.equal(cust.get("phone"), phn));
		TypedQuery<Car> tq = entityManager.createQuery(cq);
		List<Car> listData = tq.getResultList();

		return listData;
	}

	@Override
	public List<Services> allServicesDataForaSpecificCar(String carNo) {
		//

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Services> cq = cb.createQuery(Services.class);
		Root<Services> servis = cq.from(Services.class);
		Root<Car> car = cq.from(Car.class);

		cq.select(servis).where(cb.equal(car.get("id"), servis.get("car_id")), cb.equal(car.get("car_no"), carNo));
		TypedQuery<Services> tq = entityManager.createQuery(cq);
		List<Services> listData = tq.getResultList();

		return listData;

	}

	@Transactional
	@Override
	public int RecordServiceForSpecificCar(Services services) {
		this.entityManager.persist(services);
		entityManager.flush();
		return services.getId();
	
	}

	@Transactional
	@Override
	public int persistCar(Car car) {
		try {

			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Car> cq = cb.createQuery(Car.class);
			Root<Car> cars = cq.from(Car.class);

			cq.select(cars).where(cb.equal(cars.get("car_no"), car.getCar_no()));
			TypedQuery<Car> tq = entityManager.createQuery(cq);
			List<Car> listData = tq.getResultList();
			log.info("car record already exist.");
			return listData.get(0).getId();
		} catch (Exception e) {
			
			this.entityManager.persist(car);
			entityManager.flush();
			return car.getId();
		}

	}

	@Transactional
	@Override
	public int persistCustomer(Customer customer) {
		try {

			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
			Root<Customer> cust = cq.from(Customer.class);

			cq.select(cust).where(cb.equal(cust.get("phone"), customer.getPhone()));
			TypedQuery<Customer> tq = entityManager.createQuery(cq);
			List<Customer> listData = tq.getResultList();
			log.info("customer record already exist.");
			return listData.get(0).getId();
		} catch (Exception e) {
			this.entityManager.persist(customer);
			entityManager.flush();
			return customer.getId();
		}
	}
}
