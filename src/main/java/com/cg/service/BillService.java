package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

}
