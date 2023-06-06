package com.ty.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.exception.CustomerIdNotFoundException;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerrepository;
	//SimpleJpaRepository object
	//-->CRUD operationmethod impl
	
	public Customer insertCustomer(Customer customer) {
		return customerrepository.save(customer);
		
	}

	 public List<Customer> findAllCustomer()
	 {
		 return customerrepository.findAll();
	 }

	public Optional<Customer> findCustById(int custId) {
	Optional<Customer>	findById=customerrepository.findById(custId);
		return findById;
	}
	
	
	public Customer deletecustomer(int custId)
	{
	Optional<Customer>	delete=customerrepository.findById(custId);
	if(delete.isPresent())
	{
		customerrepository.deleteById(custId);
		return delete.get();
	}
	throw new  CustomerIdNotFoundException("customer Id not available");
	}

	
}
