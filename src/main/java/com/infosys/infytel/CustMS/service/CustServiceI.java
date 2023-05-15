package com.infosys.infytel.CustMS.service;



import java.util.List;

import com.infosys.infytel.CustMS.Dto.CustomerDTO;
import com.infosys.infytel.CustMS.Dto.LoginDto;

public interface CustServiceI {

	public void createCustomer(CustomerDTO custDTO);
	
	public boolean login(LoginDto loginDTO);
	
	public CustomerDTO getCustomerProfile(Long phoneNo);

	//public List<CallDetailsDTO> getCustomerCallDetails( long phoneNo);
	
	//public void saveFriend(Long phoneNo, FriendFamilyDTO friendDTO);
	
	
	
}
