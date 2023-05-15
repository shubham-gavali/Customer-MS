package com.infosys.infytel.CustMS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infytel.CustMS.Dto.CustomerDTO;
import com.infosys.infytel.CustMS.Dto.LoginDto;
import com.infosys.infytel.CustMS.Entity.Customer;
import com.infosys.infytel.CustMS.repository.CustRepo;

@Service
public class CustServiceImpl implements CustServiceI{

	@Autowired
	CustRepo custrepo;
	
	@Override
	public void createCustomer(CustomerDTO custDTO) {
		Customer customer = custDTO.CustomerDtoToCustomer(custDTO);
		
		Customer savedCust = this.custrepo.save(customer);
		
	}

	@Override
	public boolean login(LoginDto loginDTO) {
		boolean flag=false;
		Optional<Customer> cust = this.custrepo.findById(loginDTO.getPhoneNo());
		
		System.out.println("====="+ cust.get());
		if(cust.isPresent()&& cust!=null&& cust.get().getPassword().equals(loginDTO.getPassword())) {
			 flag=true;
			 System.out.println("Logged in Successfully");
		}
		return flag;
	}

	@Override
	public CustomerDTO getCustomerProfile(Long phoneNo) {
		CustomerDTO dto=null;
		Optional<Customer> OptCust = this.custrepo.findById(phoneNo);
		System.out.println(OptCust.get());
		if(OptCust.isPresent())
			dto=CustomerDTO.CustomerToDto(OptCust.get());
		return dto;
		
	}

}
