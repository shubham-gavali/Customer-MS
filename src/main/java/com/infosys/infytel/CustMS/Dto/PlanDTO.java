package com.infosys.infytel.CustMS.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO {

	
	Integer planId;
	
	String planName;

	Integer nationalRate;

	Integer localRate;


	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", localRate=" + localRate + "]";
	}


}
