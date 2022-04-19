package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Manager;
import com.cg.entity.Security;
import com.cg.service.AdminService;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {
	// change @RequestBody to RequestParam for future work
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/addSecurity")
	public String addSecurity(@RequestBody Security sec) {
		return adminService.addSecurity(sec);
	}

	@GetMapping("/delSecurity/{securityId}")
	public String removeSecurity(@PathVariable("securityId") int id){
		return adminService.removeSecurity(id);
	}

	@PostMapping("/addManager")
	public String addManager(@RequestBody Manager man) {
		return adminService.addManager(man);
	}

	@GetMapping("/delManager/{id}")
	public String removeManager(@PathVariable("id") int id){
		return adminService.removeManager(id);
	}
	
	@GetMapping("/addAllSlot/{mode}/{totalSlotCount}/{type}")
	public String addParking(@PathVariable("mode") String mode,@PathVariable("totalSlotCount") int totalSlotCount,@PathVariable("type") String type){
	return adminService.addSlot(totalSlotCount,type,mode);
	}
	
	@DeleteMapping("/deleteSlot/{decr}/{start}")
	public String removeSlot(@PathVariable("decr") int decr,@PathVariable("start") String start){
		return adminService.removeSlot(decr, start);
	}
	@PutMapping("/update/{slotNo}/{type}")
	public String update(@PathVariable("slotNo") String slotNo,@PathVariable("type") String type ) {
		return adminService.updateSlot(slotNo,type);
	}
	@PutMapping("/rangeChange/{start}/{end}/{type}")
	public String rangechangeSlot(@PathVariable("start") String start,@PathVariable("end") String end, @PathVariable("type") String type ) {
		return adminService.rangeChangeStatusSlot(start, end, type);
	}
}
