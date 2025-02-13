package com.anubhavtrainings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anubhavtrainings.entities.Vendor;
@Component
public class VendorService {

	@Autowired
	public IVendorPersistence IVend;
	public List<Vendor> getAllVendors(){
		return IVend.findAll();
	}
//	public Vendor getVendorById(String code) {
//		return (Vendor)vendors.get(code);
//	}
	public Vendor createNewVendor(Vendor vend) {
		return IVend.save(vend);
	}
//	public Vendor updateVendor(Vendor vend) {
//		vend.code = "Changed Vendor";
//		return vend;
//	}
	public List <Vendor> searchByCompany(String company){
		return IVend.findByCompanyName(company);
	}
//	public List<Vendor> lookupVendorByGST(String GST){
////		return IVend.lookupVendorByGST(GST);
//	}
	public Vendor getVendorById(Long id){
		if (!IVend.findById(id).isPresent()) {
			return new Vendor((long)0,null, null, null, null, null, null, null);
		}
		return IVend.findById(id).get();
	}
	public Vendor updateVendor(Vendor payload) {
		Optional<Vendor> myVend = IVend.findById(payload.getId());
		if (!myVend.isPresent()) {
			return new Vendor((long)0,null, null, null, null, null, null, null);
		}
		return IVend.save(payload);
	}
	public String deleteVendor(Long id) {
		IVend.deleteById(id);
		return "Deleted successfully";
	}
}
