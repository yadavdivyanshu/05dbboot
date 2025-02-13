package com.anubhavtrainings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anubhavtrainings.entities.address;

@Component
public class addressService {

	@Autowired
	IAddressPersistence IADP;
	
	public address createAddress(address payload) {
		return IADP.save(payload);
	}
	
	public List<address> getAllAddress(){
		return IADP.findAll();
	}
}
