package com.bfar.springboot.training.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorResponse implements Serializable{
	
	private static final long serialVersionUID = 2323L;
	private String action;
	private double result;
}
