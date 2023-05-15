package com.infosys.infytel.CustMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.infytel.CustMS.Dto.CustomerDTO;
import com.infosys.infytel.CustMS.Dto.LoginDto;
import com.infosys.infytel.CustMS.Dto.PlanDTO;
import com.infosys.infytel.CustMS.service.CustServiceI;

@RestController
public class CustomerController {

	@Autowired
	CustServiceI service;
	
	@PostMapping(value = "/customer", consumes ="application/json")
	public void createCustomer(@RequestBody CustomerDTO dto) {
		
		this.service.createCustomer(dto);
	}
	
	@GetMapping(value = "/customer/{phoneNo}",produces = "application/json")
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {
		
		CustomerDTO custdto = this.service.getCustomerProfile(phoneNo);
		PlanDTO planDto= new RestTemplate().getForObject("http://localhost:9494/plan/"+custdto.getCurrentPlan().getPlanId(), PlanDTO.class);
		@SuppressWarnings("unchecked")
		List<Long> friends=new RestTemplate().getForObject("http://localhost:9393/customers/"+phoneNo+"/friends",List.class);
		custdto.setCurrentPlan(planDto);
		custdto.setFriendAndFamily(friends);
		System.out.println(custdto);
		return custdto;
	}
	
	@PostMapping(value = "/login", consumes = "application/json")
	public boolean login(@RequestBody LoginDto loginDto) {
		
		boolean status = this.service.login(loginDto);
	
		return status;
	}
	
	
}
