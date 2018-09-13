package com.bfar.springboot.training.resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CalculatorRequest implements Serializable{
	
	private static final long serialVersionUID = 45454L;
	private String operator;
	private double number1;
	private double number2;
}
