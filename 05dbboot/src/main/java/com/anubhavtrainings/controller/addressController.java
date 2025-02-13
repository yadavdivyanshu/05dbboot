package com.anubhavtrainings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.address;
import com.anubhavtrainings.service.addressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class addressController {

	@Autowired
	addressService addrSrv;
	
	@GetMapping("/addresses")
	public List<address> getAllAddr() {
		return addrSrv.getAllAddress();
	}
	@PostMapping("/addresses")
	public address createaddr(@RequestBody address payload) {
		return addrSrv.createAddress(payload);
	}
	
}
