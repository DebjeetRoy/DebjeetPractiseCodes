package com.modelMapping.demo.dto;

import lombok.Data;

@Data
public class PersonDto {
	private String personId;
	private String personName;
	private String personAddress;

	public PersonDto() {

	}

	public PersonDto(String personId, String personName, String personAddress) {
		this.personId = personId;
		this.personName = personName;
		this.personAddress = personAddress;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	@Override
	public String toString() {
		return "PersonDto [personId=" + personId + ", personName=" + personName + ", personAddress=" + personAddress
				+ "]";
	}

}
