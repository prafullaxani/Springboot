package com.ty.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.exception.FindCustomerByIdNotFound;
import com.ty.restapi.repository.CustomerDao;
import com.ty.restapi.response.ResponseStructure;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerdao;

	public ResponseStructure<?> insertCustomer(Customer customer) {

              Customer cust=customerdao.insertCustomer(customer);
              
              ResponseStructure<Customer> responsestructure=new ResponseStructure<>();
              responsestructure.setData(cust);
              responsestructure.setHttpstatus(HttpStatus.CREATED);
              
		return responsestructure;
	}

	public ResponseStructure<?> findAllCustomer()
	{
		List<Customer> customerlist=customerdao.findAllCustomer();
		ResponseStructure<List<Customer>> responsestructure=new ResponseStructure<>();
		responsestructure.setData(customerlist);
		responsestructure.setHttpstatus(HttpStatus.OK);
		return  responsestructure;
	}

	



	public ResponseStructure<?> findCustById(int custId) {
		Optional<Customer> findCustById=customerdao.findCustById(custId);
		
		if(findCustById.isPresent())
		{
			ResponseStructure<Customer> responsestructure=new ResponseStructure<>();
			Customer customer=findCustById.get();
			responsestructure.setData(customer);
			responsestructure.setHttpstatus(HttpStatus.OK);
			return responsestructure;
		}
		throw new FindCustomerByIdNotFound("invalid customer id");
	}

    public ResponseStructure<?> deletecustomer(int custId)
    {
    	Customer customer=customerdao.deletecustomer(custId);
    	ResponseStructure<Customer> responseStructure=new ResponseStructure<> ();
    	responseStructure.setData(customer);
    	responseStructure.setHttpstatus(HttpStatus.OK);
    	return responseStructure;
    	
    }

}
