package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Bill;
import com.cg.entity.Customer;
import com.cg.entity.Slot;
import com.cg.entity.SlotStatus;
import com.cg.repository.CustomerRepository;
import com.cg.repository.ManagerRepository;
import com.cg.repository.SlotRepository;
import com.cg.service.CustomerService;
import com.cg.service.ManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestManager {
	
	@Autowired 
	private ManagerService managerService;
	
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private ManagerRepository managerrepository;
	
	@MockBean
	private SlotRepository slotRepository;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	

	@Test
	void getAllParkingSlots() {
		Slot slot1 = new Slot("A01",SlotStatus.VACANT);
		Slot slot2 = new Slot("A02",SlotStatus.VACANT);

		Slot s = slotRepository.save(slot1);
			s = slotRepository.save(slot2);

		when(slotRepository.findAll()).thenReturn((List<Slot>) s);
		assertEquals((List<Slot>) s,managerService.getAllParkingSlots());
	}
	
	@Test 
	void showAvailableParkingSlots() {
		Slot slot1 = new Slot("A01",SlotStatus.VACANT);
		Slot slot2 = new Slot("A02",SlotStatus.VACANT);

		Slot s = slotRepository.save(slot1);
			s = slotRepository.save(slot2);

		when(slotRepository.findAllAvailableSlot()).thenReturn((List<Slot>) s);
		assertEquals((List<Slot>) s,managerService.showAvailableParkingSlots());
	}
	
	@Test
	void generateReceipt() {
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setName("Kaumudi");
		customer.setVehicleNumber("UP12AD1990");
		customer.setPhoneNumber("9876543210");
		customer.setHasToken(true);
		customer.setSlotNo("A01");
		
		Bill bill = new Bill();
		bill.setBillId(1);
		bill.setDate(LocalDate.now());
		bill.setEntryTime(LocalTime.now());
		
		customer.setBill(bill);
		
		bill.setCustomer(customer);
		
		customerRepository.save(customer);
		when(customerRepository.existsById(1)).thenReturn(true);
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		
		assertEquals("Receipt Generated for Customer Id : 1",managerService.generateReceipt(1));
	}

	@Test
	void generateBill() {
		Bill bill = new Bill(); 
		Customer customer = new Customer(1,"Kaumudi","UP12AD1990","8900110099",true,null,bill);
		customerRepository.save(customer);
		Slot slot = new Slot("A01",SlotStatus.VACANT);
		when(customerRepository.existsById(1)).thenReturn(true);
		when(slotRepository.save(slot)).thenReturn(slot);
		when(slotRepository.findBySlotNo("A01")).thenReturn(slot);
		//when(customerRepository.findById(1)).thenReturn(Optional.of(new Customer(1,"Kaumudi","UP12AD1990","9876543210",true,null,bill)));
		assertEquals("Slot No : A01 is Alloted to Customer Id : 1",customerService.selectSlot(1,"A01"));

		
	}
}
