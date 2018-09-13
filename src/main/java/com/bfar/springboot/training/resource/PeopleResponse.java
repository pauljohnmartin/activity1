package com.bfar.springboot.training.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleResponse implements Serializable{
	
	private static final long serialVersionUID = 8990L;
	private String firstName;
	private String lastName;
	private String birthDate;
}
