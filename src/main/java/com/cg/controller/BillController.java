package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billService;

}
