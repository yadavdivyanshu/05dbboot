package com.anubhavtrainings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.Vendor;
import com.anubhavtrainings.service.VendorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class VendorController {
	@Autowired
	VendorService vendorService;
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
		return vendorService.getAllVendors();
	}
	//http://localhost:8080/vendor/search?company=SAP
	@RequestMapping("/vendor/search")
	public List<Vendor> getVendorsByCompany(@RequestParam String company ){
		return vendorService.searchByCompany(company);
	}
	//http://localhost:8080/vendor/lookup/77
//	@RequestMapping("/vendor/lookup/{gstin}")
//	public List<Vendor> getVendorsByGST(@PathVariable("gstin") String GST ){
//		return vendorService.lookupVendorByGST(GST);
//	}
	@RequestMapping(value="/vendor/{vendorId}",method=RequestMethod.GET)
	public Vendor getVendorById(@PathVariable("vendorId") Long code) {
		return vendorService.getVendorById(code);
	}

	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createNewVendor(myPostBody);
	}
	@RequestMapping(value="/vendor", method=RequestMethod.PUT)
	public Vendor updateVendor(@RequestBody Vendor myPutBody) {
		return vendorService.updateVendor(myPutBody);
	}
	@DeleteMapping("/vendor/{vendorId}")
	public String deleteVendor(@PathVariable("vendorId") Long param) {
		return vendorService.deleteVendor(param);
	}
	
	
}
