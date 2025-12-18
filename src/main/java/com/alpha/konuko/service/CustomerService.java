package com.alpha.konuko.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.CustomerDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Customer;
import com.alpha.konuko.entity.Product;
import com.alpha.konuko.exception.CustomerNotFoundException;
import com.alpha.konuko.exception.ProductNotFoundException;
import com.alpha.konuko.repository.AddressRepo;
import com.alpha.konuko.repository.CustomerRepo;
import com.alpha.konuko.repository.ProductRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cr;
	
	@Autowired
	private AddressRepo ar;
	
	@Autowired
	private ProductRepo pr;
	
	public ResponseEntity<ResponseStructure<Customer>> registerCustomer(CustomerDTO cdto) {
		Customer c = new Customer();
		c.setName(cdto.getName());
		c.setMobileno(cdto.getMobileno());
		c.setMail(cdto.getMail());
		c.getAddressesList().add(cdto.getAddress());
		ar.save(cdto.getAddress());
		cr.save(c);
		
		ResponseStructure<Customer> rs = new ResponseStructure<Customer>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Customer saved successfully");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> addaddress(long mobileno, Address address) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		c.getAddressesList().add(address);
		ar.save(address);
		cr.save(c);
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer address added");
		rs.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteaddress(long mobileno, int addid) {
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()->new CustomerNotFoundException());
		List<Address> alist = c.getAddressesList();
		Address add = new Address();
		for(Address a: alist)
		{
			if(a.getId()==addid)
			{
				add=a;
				break;
			}
		}
		c.getAddressesList().remove(add);
		ar.delete(add);
		cr.save(c);
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer address deleted");
		rs.setData(add);
		return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> seeallAvailableProducts() {
		
		List<Product> plist = pr.findByAvailabilityStatus().orElseThrow(()-> new ProductNotFoundException());
		 
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Available Product list");
		rs.setData(plist);
		return new ResponseEntity<ResponseStructure<List<Product>>>(rs,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Product>> addproductstoCart(long mobileno,int prodid)
	{
		Customer c = cr.findBymobileno(mobileno).orElseThrow(()-> new CustomerNotFoundException());
		Product p= pr.findById(prodid).orElseThrow(()-> new ProductNotFoundException());
		c.getCart().add(p);
		cr.save(c);
//		pr.save(p);
		ResponseStructure<Product> rs = new ResponseStructure<Product>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Available Product list");
		rs.setData(p);
		return new ResponseEntity<ResponseStructure<Product>>(rs,HttpStatus.CREATED);		
	}
}
	
