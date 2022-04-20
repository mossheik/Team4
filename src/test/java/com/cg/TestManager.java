package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
		Slot slot1 = new Slot("A01", SlotStatus.VACANT);
		Slot slot2 = new Slot("A02", SlotStatus.VACANT);

		Slot s = slotRepository.save(slot1);
		s = slotRepository.save(slot2);

		when(slotRepository.findAll()).thenReturn((List<Slot>) s);
		assertEquals((List<Slot>) s, managerService.getAllParkingSlots());
	}

	@Test
	void showAvailableParkingSlots() {
		Slot slot1 = new Slot("A01", SlotStatus.VACANT);
		Slot slot2 = new Slot("A02", SlotStatus.VACANT);

		Slot s = slotRepository.save(slot1);
		s = slotRepository.save(slot2);

		when(slotRepository.findAllAvailableSlot()).thenReturn((List<Slot>) s);
		assertEquals((List<Slot>) s, managerService.showAvailableParkingSlots());
	}

	@Test
	void showTopTenAvailableParkingSlots() {
		Slot slot1 = new Slot("A01", SlotStatus.VACANT);
		Slot slot2 = new Slot("A02", SlotStatus.VACANT);
		Slot slot3 = new Slot("A03", SlotStatus.VACANT);
		Slot slot4 = new Slot("A04", SlotStatus.VACANT);
		Slot slot5 = new Slot("A05", SlotStatus.VACANT);
		Slot slot6 = new Slot("A06", SlotStatus.VACANT);
		Slot slot7 = new Slot("A07", SlotStatus.VACANT);
		Slot slot8 = new Slot("A08", SlotStatus.VACANT);
		Slot slot9 = new Slot("A09", SlotStatus.VACANT);
		Slot slot10 = new Slot("A10", SlotStatus.VACANT);
		Slot slot11 = new Slot("A11", SlotStatus.VACANT);
		Slot slot12 = new Slot("A12", SlotStatus.VACANT);
		Slot s = slotRepository.save(slot1);
		s = slotRepository.save(slot2);
		s = slotRepository.save(slot3);
		s = slotRepository.save(slot4);
		s = slotRepository.save(slot5);
		s = slotRepository.save(slot6);
		s = slotRepository.save(slot7);
		s = slotRepository.save(slot8);
		s = slotRepository.save(slot9);
		s = slotRepository.save(slot10);
		s = slotRepository.save(slot11);

		List<Slot> s1 = new ArrayList<Slot>();
		s1.add(new Slot("A01", SlotStatus.VACANT));
		s1.add(new Slot("A02", SlotStatus.VACANT));
		s1.add(new Slot("A03", SlotStatus.VACANT));
		s1.add(new Slot("A04", SlotStatus.VACANT));
		s1.add(new Slot("A05", SlotStatus.VACANT));
		s1.add(new Slot("A06", SlotStatus.VACANT));
		s1.add(new Slot("A07", SlotStatus.VACANT));
		s1.add(new Slot("A08", SlotStatus.VACANT));
		s1.add(new Slot("A09", SlotStatus.VACANT));
		s1.add(new Slot("A10", SlotStatus.VACANT));
		when(slotRepository.findTop10ByOrderBySlotNoAsc()).thenReturn((List<Slot>) s1);
		assertEquals(s1, managerService.showNearestTenParkingSlots());
	}

//	@Test
//	void generateReceipt() {
//		Customer customer = new Customer();
//		customer.setCustomerId(1);
//		customer.setName("Kaumudi");
//		customer.setVehicleNumber("UP12AD1990");
//		customer.setPhoneNumber("9876543210");
//		customer.setHasToken(true);
//		customer.setSlotNo("A01");
//		Bill receipt = new Bill();
//		billRepository.saveAndFlush(receipt);
//		customer.setBill(receipt);
//		receipt.setCustomer(customer);
//		customerRepository.saveAndFlush(customer);
//		when(customerRepository.existsById(1)).thenReturn(true);
//		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
//		assertEquals("Receipt Generated for Customer Id : 1", managerService.generateReceipt(1));
//	}
//
//	@Test
//	void generateBill() {
//		Customer customer = new Customer();
//		customer.setCustomerId(1);
//		customer.setName("Kaumudi");
//		customer.setVehicleNumber("UP12AD1990");
//		customer.setPhoneNumber("9876543210");
//		customer.setHasToken(true);
//		customer.setSlotNo("A01");
//		Bill bill = new Bill();
//		bill.setBillId(1);
//		bill.setEntryTime(LocalTime.now());
//		bill.setSlotNo("A01");
//		billRepository.save(bill);
//		customer.setBill(bill);
//		bill.setCustomer(customer);
//		customerRepository.save(customer);
//
//		// when(slotRepository.save(slot)).thenReturn(slot);
//		// when(slotRepository.findBySlotNo("A01")).thenReturn(slot);
//		when(customerRepository.existsById(1)).thenReturn(true);
//		when(billRepository.save(bill)).thenReturn(bill);
//		when(billRepository.existsById(1)).thenReturn(true);
//		when(billRepository.findById(1)).thenReturn(Optional.of(bill));
//		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
//		assertEquals("Bill generated for Customer Id : 1", managerService.generateBill(1));
//
//	}
}
