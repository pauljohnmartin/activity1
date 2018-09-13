package com.bfar.springboot.training.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

@Component
@Path("/calculator")
public class CalculatorResource {	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calcu(CalculatorRequest calcuRequest) {
	
		CalculatorResponse calcuResponse = new CalculatorResponse();
		
		return compute(calcuRequest, calcuResponse);	

	}
	
	public Response compute(CalculatorRequest request, CalculatorResponse response) {		
		
		try {
			
			if (!request.getOperator().isEmpty() || !request.getOperator().equals(null)  || request.getNumber1() != 0  || request.getNumber2() != 0) {	
				
				if ( Double.valueOf(request.getNumber1()) instanceof Double || Double.valueOf(request.getNumber1()) instanceof Double) {	
					if (request.getOperator().equals("+")) {
						response.setAction("Addition");
						response.setResult(addition(request));			
						return Response.ok().entity(response).build();
					}else if (request.getOperator().equals("-")) {
						response.setAction("Subtraction");
						response.setResult(subtraction(request));
						return Response.ok().entity(response).build();
					}else if (request.getOperator().equals("*")) {
						response.setAction("Multiplication");
						response.setResult(multiplication(request));
						return Response.ok().entity(response).build();
					}else if (request.getOperator().equals("/")) {
						response.setAction("Division");
						response.setResult(division(request));
						return Response.ok().entity(response).build();
					}else {
						return Response.status(Response.Status.BAD_REQUEST)
								.entity( "'" + request.getOperator() + "' is invalid operator.")
				                	.type( MediaType.TEXT_PLAIN).build();
					}
				}else {
					return Response.status(Response.Status.BAD_REQUEST)
				            .entity( "Only numbers allowed.")
				                .type( MediaType.TEXT_PLAIN).build();					
					}
			} else {
				return Response.status(Response.Status.BAD_REQUEST)
				        .entity( "Required inputs.")
				            .type( MediaType.TEXT_PLAIN).build();
			}
		} catch (Exception e) {
				return Response.status(Response.Status.BAD_REQUEST)
			            .entity( "Required inputs.")
			            .type( MediaType.TEXT_PLAIN).build();
		}
	}
	
	double addition(CalculatorRequest request) {
		return request.getNumber1() + request.getNumber2();
	}
	
	double subtraction(CalculatorRequest request) {
		return request.getNumber1() - request.getNumber2();
	}
	
	double division(CalculatorRequest request) {
		return request.getNumber1() / request.getNumber2();
	}
	
	double multiplication(CalculatorRequest request) {
		return request.getNumber1() * request.getNumber2();
	}
	
	

}
