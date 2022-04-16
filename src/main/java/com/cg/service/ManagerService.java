package com.cg.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bill;
import com.cg.entity.Customer;
import com.cg.entity.Slot;
import com.cg.entity.Token;
import com.cg.repository.BillRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.SlotRepository;

@Service
public class ManagerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private SlotRepository slotRepository;
	
	
	
	public List<Slot> getAllParkingSlots()
	{
		return slotRepository.findAll();
	}
	
	public List<Slot> showAvailableParkingSlots()
	{
		return slotRepository.findAllAvailableSlot();
	}

	public String registerCustomer(int id) {
		if(customerRepository.findById(id).isPresent());
		Customer customer = customerRepository.findById(id).get();
		Bill b = new Bill();
		return b.toString() + " " + customer.toString();

	}
	
	
	Bill bill = new Bill();

	public String generateReceipt(int id)
	{
		Customer customer=customerRepository.findById(id).get();
		
		//Setting Receipt Details
		
		
		bill.setCustomer(customer);
		bill.setDate(LocalDate.now());	
		bill.setEntryTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));		
		
		//Generating Receipt
		try {
			FileWriter receipt = new FileWriter("Receipt.txt");
			receipt.append("\t\t==================================");
			receipt.append("\n");
			receipt.append("\t\t  TEAM 4 - CAR PARKING SYSTEM (Receipt)");
			receipt.append("\n");
			receipt.append("\t\t==================================");
			receipt.append("\n");
			receipt.append("----------------------------------");
			receipt.append("\n");
			receipt.append("Receipt Details");
			receipt.append("\n");
			receipt.append("----------------------------------");
			receipt.append("\n");
			receipt.append("Bill Id : "+bill.getBillId());
			receipt.append("\n");
			receipt.append("Date : "+bill.getDate());
			receipt.append("\n");
			receipt.append("----------------------------------");
			receipt.append("\n");
			receipt.append("Customer Details");		
			receipt.append("\n");
			receipt.append("----------------------------------");
			receipt.append("\n");
			receipt.append("Customer Id : "+customer.getCustomerId());
			receipt.append("\n");
			receipt.append("Name : "+customer.getName());
			receipt.append("\n");
			receipt.append("Phone Number : "+customer.getPhoneNumber());
			receipt.append("\n");
			receipt.append("Vehicle Number : "+customer.getVehicleNumber());
			receipt.append("\n");
			receipt.append("Token Number : "+customer.isHasToken());
			receipt.append("\n");
			receipt.append("Parking Position : "+customer.getSlotNo());
			receipt.append("\n");	
			receipt.append("Entry Time : "+bill.getEntryTime());
			receipt.append("\n");
			receipt.close();
			
			billRepository.save(bill);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Receipt generated";
		
		
		
	}
	

	public String generateBill(int id) {


		Customer customer = customerRepository.findById(id).get();
		
		bill.setExitTime(LocalTime.now());
		
		long diffTotalDuration=ChronoUnit.HOURS.between(bill.getEntryTime(), bill.getExitTime());
		bill.setTotalDuration(diffTotalDuration);
		
		double finalBillAmount=60.0;
		if(diffTotalDuration<1)
			bill.setAmount(finalBillAmount);
		else {
			finalBillAmount=60*(double)diffTotalDuration;
			bill.setAmount(finalBillAmount);
		}
		billRepository.save(bill);

		// Generating Bill Receipt
		try {
			FileWriter finalBill = new FileWriter("Bill.txt");
			finalBill.append("\t\t==================================");
			finalBill.append("\n");
			finalBill.append("\t\t     TEAM 4 CAR PARKING SYSTEM (Bill)");
			finalBill.append("\n");
			finalBill.append("\t\t==================================");
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Bill Details");
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Bill Id : " + bill.getBillId());
			finalBill.append("\n");
			finalBill.append("Date : " + bill.getDate());
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Customer Details");
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Customer Id : " + customer.getCustomerId());
			finalBill.append("\n");
			finalBill.append("Name : " + customer.getName());
			finalBill.append("\n");
			finalBill.append("Phone Number : " + customer.getPhoneNumber());
			finalBill.append("\n");
			finalBill.append("Vehicle Number : " + customer.getVehicleNumber());
			finalBill.append("\n");
			finalBill.append("Token Number : "+customer.isHasToken());
			finalBill.append("\n");
			finalBill.append("Parking Position : "+customer.getSlotNo());
			finalBill.append("\n");
			finalBill.append("Entry Time : " + bill.getEntryTime());
			finalBill.append("\n");
			finalBill.append("Exit Time : " + bill.getExitTime());
			finalBill.append("\n");
			finalBill.append("Parking Duration (in Hours) : " + bill.getTotalDuration());
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Payment (Charges : 60 Ruppes per Hour)");
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Total Amount : " + bill.getAmount());
			finalBill.append("\n");
			
			finalBill.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Bill generated";

	}
	
	public void customerExit(Customer customer)
	{
		customer.setHasToken(false);
		Token.tokenCount++;
		String customersSlot=customer.getSlotNo();
		customer.setSlotNo(null);
		Slot s=slotRepository.findBySlotNo(customersSlot);
		s.setSlotStatus("Vacant");
		slotRepository.save(s);
		
	}
	
}
