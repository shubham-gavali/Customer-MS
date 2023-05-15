package com.infosys.infytel.CustMS.Dto;



import java.util.List;

import com.infosys.infytel.CustMS.Entity.Customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	Long phoneNo;
	String name;
	int age;
	char gender;
	List<Long> friendAndFamily;
	String password;
	String address;
	PlanDTO currentPlan;
	
	
	public static CustomerDTO CustomerToDto(Customer cust) {
		CustomerDTO dto=new CustomerDTO();
		dto.setName(cust.getName());
		dto.setAddress(cust.getAddress());
		dto.setAge(cust.getAge());
		dto.setPassword(cust.getPassword());
		dto.setGender(cust.getGender());
		dto.setPhoneNo(cust.getPhoneNo());

		PlanDTO planDTO = new PlanDTO();
		
		planDTO.setPlanId(cust.getPlanId());
		dto.setCurrentPlan(planDTO);

		return dto;
		
	}
	
	public Customer CustomerDtoToCustomer(CustomerDTO custdto) {
		Customer cust=new Customer();
		cust.setName(custdto.getName());
		cust.setAddress(custdto.getAddress());
		cust.setAge(custdto.getAge());
		cust.setPassword(custdto.getPassword());
		cust.setGender(custdto.getGender());
		cust.setPhoneNo(custdto.getPhoneNo());
		cust.setPlanId(custdto.getCurrentPlan().planId);
		return cust;
		
	}
}
