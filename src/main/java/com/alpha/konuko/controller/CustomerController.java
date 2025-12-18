package com.alpha.konuko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.CustomerDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Customer;
import com.alpha.konuko.entity.Product;
import com.alpha.konuko.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody CustomerDTO cdto)
	{
		return cs.registerCustomer(cdto);
	}
	@PostMapping("/addaddress")
	public ResponseEntity<ResponseStructure<Address>> addaddress(@RequestParam long mobileno,@RequestBody Address address)
	{
		return cs.addaddress(mobileno,address);
	}
	
	@DeleteMapping("/deleteaddress")
	public ResponseEntity<ResponseStructure<Address>> deleteaddress(@RequestParam long mobileno,@RequestParam int addid)
	{
		return cs.deleteaddress(mobileno,addid);
	}
	
	@GetMapping("/seeallavailableproducts")
	public ResponseEntity<ResponseStructure<List<Product>>> seeallAvailableProducts()
	{
		return cs.seeallAvailableProducts();
	}

	@PostMapping("/addproductstoCart")
	public ResponseEntity<ResponseStructure<Product>> addproductstoCart(@RequestParam long mobileno, @RequestParam int prodid)
	{
		return addproductstoCart(mobileno,prodid);
	}
}
