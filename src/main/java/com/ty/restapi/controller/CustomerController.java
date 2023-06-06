package com.ty.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.client.HttpStatusCodeException;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.response.ResponseStructure;
import com.ty.restapi.service.CustomerService;

@RestController
public class CustomerController
{
	@Autowired
     private CustomerService customerservice;
	
 @PostMapping(path="/persist")
 public ResponseEntity<?> insertCustomer (@RequestBody Customer customer)
 { 
	ResponseStructure<?> responseStructure =customerservice.insertCustomer(customer);
			 
		 return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
			 
 }
 @GetMapping(path="/fetch")
 public ResponseEntity<?>  findAllCustomer()
 {
	 ResponseStructure<?> responseStructure=customerservice.findAllCustomer();
	 return new ResponseEntity<> (responseStructure,responseStructure.getHttpstatus());
 }
 
 @GetMapping(path="fetch/{custId}")
 public ResponseEntity<?> findCustemerById(@PathVariable int custId)
 {
	ResponseStructure<?>  responseStructure=customerservice.findCustById(custId);
	return new ResponseEntity<> (responseStructure,responseStructure.getHttpstatus());
 }
 
 @DeleteMapping(path="/delete/{custId}")
 public ResponseEntity<?> deletecustomer(@PathVariable int custId)
 {
	 ResponseStructure<?> responseStructure=customerservice.deletecustomer(custId);
	 return new ResponseEntity<>(responseStructure,responseStructure.getHttpstatus());
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
// @GetMapping(path="/fetch")
// public ResponseEntity<?> getCustomer(@RequestParam int custId)
// {
//	 if(custId>=1)
//	 {
//		 return new ResponseEntity<>("valid Customer id",HttpStatus.OK);
//				 
//	 }
//	 return new ResponseEntity<>("invalid Customer ID",HttpStatus.NOT_FOUND);
// }
// @DeleteMapping(path="/delete/{custId}")
// public ResponseEntity<?> deleteCustomer(@PathVariable int custId)
// {
//	 return new ResponseEntity<>("Customer data deleted",HttpStatus.OK);
// }
}
