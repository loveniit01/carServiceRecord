package com.car.services.recording.repo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.car.services.recording.entity.Customer;
import com.car.services.recording.entity.Services;
import com.car.services.recording.model.Details;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarServiceRepoTest {

	@Autowired
	   WebApplicationContext webApplicationContext;
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarServiceRepo serviceRepo;
    
    @Autowired
	private MockMvc mockMvc;
	
    
//    @Test
    public void whenFindCustomer_thenReturnListCustomer() {

        // when
        
  List<Customer> customers=      serviceRepo.allCustomerData();

        // then
  assertTrue(customers.size()>0);
          
    }
    
    
    
    protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	
}
