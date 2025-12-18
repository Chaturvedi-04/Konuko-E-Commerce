package com.alpha.konuko.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.konuko.ResponseStructure;
import com.alpha.konuko.dto.AdminDTO;
import com.alpha.konuko.dto.CarrierDTO;
import com.alpha.konuko.entity.Address;
import com.alpha.konuko.entity.Admin;
import com.alpha.konuko.entity.Carrier;
import com.alpha.konuko.exception.AdminNotFoundException;
import com.alpha.konuko.service.AdminService;
import com.alpha.konuko.service.CarrierService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@Autowired
	private CarrierService cs;
	
	@PostMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<Admin>> saveadmin(@RequestBody AdminDTO adto)
	{
		return as.saveadmin(adto);
	}
	
	@PostMapping("/addnewAddress")
	public ResponseEntity<ResponseStructure<Admin>> addnewAddress(@RequestBody Address address,@RequestParam long adminmobileno)
	{
		return as.addnewAddress(address,adminmobileno);
	}
	
	@PostMapping("/saveCarrier")
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(@RequestBody CarrierDTO cdto)
	{
		return cs.saveCarrier(cdto);
	}
	
	@GetMapping("/findCarrier")
	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(@RequestParam long mobileno)
	{
		return cs.findCarrier(mobileno);
	}
	@PutMapping("updateAdmin/deleteAddress")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@RequestParam long mobileno,@RequestParam int addressid) throws AdminNotFoundException
	{
		return as.deleteAddress(mobileno,addressid);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam long mobileno) throws AdminNotFoundException
	{
		return as.deleteAdmin(mobileno);
	}
	
}