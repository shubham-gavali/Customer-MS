package com.infosys.infytel.CustMS.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDto {

	long phoneNo;
	String password;
}
