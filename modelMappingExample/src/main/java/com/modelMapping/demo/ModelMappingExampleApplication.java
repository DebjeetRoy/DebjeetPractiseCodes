package com.modelMapping.demo;

import org.modelmapper.ModelMapper;

import com.modelMapping.demo.dto.EmployeeDto;
import com.modelMapping.demo.dto.PersonDto;

//@SpringBootApplication
public class ModelMappingExampleApplication {

	public static void main(String[] args) {
		final ModelMapper modelMapper = new ModelMapper();

		// If field names are same in both DTOs(Working)
//		System.out.println("All field names are kept same");
//		final EmployeeDto empDto = new EmployeeDto("EMP101", "Dev", "Varanasi");
//
//		final PersonDto personDto = modelMapper.map(empDto, PersonDto.class);
//
//		System.out.println("Id :- " + personDto.getId());
//		System.out.println("Name :- " + personDto.getName());
//		System.out.println("Address :- " + personDto.getAddress());

		System.out.println("All field names are kept different");

		// Configure Custom mappings
		modelMapper.typeMap(EmployeeDto.class, PersonDto.class)
				.addMappings(mapper -> mapper.map(EmployeeDto::getEmpId, PersonDto::setPersonId))
				.addMappings(mapper -> mapper.map(EmployeeDto::getEmpName, PersonDto::setPersonName))
				.addMappings(mapper -> mapper.map(EmployeeDto::getEmpAddress, PersonDto::setPersonAddress));

		final EmployeeDto empDto = new EmployeeDto("EMP101", "Dev", "Varanasi");
		final PersonDto personDto = modelMapper.map(empDto, PersonDto.class);
		System.out.println("Person Id :- " + personDto.getPersonId());
		System.out.println("Person Name :- " + personDto.getPersonName());
		System.out.println("Person Address :- " + personDto.getPersonAddress());
	}
}
