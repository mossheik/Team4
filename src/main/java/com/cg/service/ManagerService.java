package com.cg.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bill;
import com.cg.entity.CardPayment;
import com.cg.entity.CashPayment;
import com.cg.entity.Customer;
import com.cg.entity.Slot;
import com.cg.entity.Token;
import com.cg.repository.BillRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.ManagerRepository;
import com.cg.repository.SlotRepository;

@Service
public class ManagerService{
	private static final AtomicInteger count = new AtomicInteger(0); 

	@Autowired
	private ManagerRepository managerRepository;

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
		Customer customer = customerRepository.findById(id).get();
		Bill b = new Bill();
		return b.toString() + " " + customer.toString();

	}
	
	

	public String generateReceipt(int id)
	{

		Customer customer=customerRepository.findById(id).get();
		
		//Setting Receipt Details
		
		Bill bill = new Bill();
		bill.setCustomer(customer);
		int billId = count.incrementAndGet(); 
		bill.setBillId(billId);
		
		ZoneId zonedId = ZoneId.of( "Asia/Kolkata");
		LocalDate date = LocalDate.now( zonedId );
		bill.setDate(date);
		
		LocalTime curentEntryTime = LocalTime.now();
		bill.setEntryTime(curentEntryTime);
		
		//Generating Receipt
		try {
			File billObj = new File("Receipt.txt");
			FileWriter billReceipt = new FileWriter("Receipt.txt");
			billReceipt.append("\t\t==================================");
			billReceipt.append("\n");
			billReceipt.append("\t\t     TEAM 4 - CAR PARKING SYSTEM");
			billReceipt.append("\n");
			billReceipt.append("\t\t==================================");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Receipt Details");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Bill Id : "+bill.getBillId());
			billReceipt.append("\n");
			billReceipt.append("Date : "+bill.getDate());
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Customer Details");		
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Customer Id : "+customer.getCustomerId());
			billReceipt.append("\n");
			billReceipt.append("Name : "+customer.getName());
			billReceipt.append("\n");
			billReceipt.append("Phone Number : "+customer.getPhoneNumber());
			billReceipt.append("\n");
			billReceipt.append("Vehicle Number : "+customer.getVehicleNumber());
			billReceipt.append("\n");
			billReceipt.append("Token Number : "+customer.isHasToken());
			billReceipt.append("\n");
			billReceipt.append("Parking Position : "+customer.getSlotNo());
			billReceipt.append("\n");
			billReceipt.append("Entry Time : "+bill.getEntryTime());
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Payment (Charges : 30 Ruppes per Hour)");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");				
			billReceipt.close();
			
			billRepository.save(bill);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Receipt generated";
		
		
		
	}
	

	public String generateBill(int id) {

		Customer customer = customerRepository.findById(id).get();
		// Setting Bill Details

		Bill bill = new Bill();
		int billId = count.incrementAndGet();
		bill.setBillId(billId);
		
		
		ZoneId zonedId = ZoneId.of("Asia/Kolkata");
		LocalDate date = LocalDate.now(zonedId);
		bill.setDate(date);
		
		LocalTime curentExitTime = LocalTime.now();
		bill.setExitTime(curentExitTime);
		
		long diffTotalDuration=bill.getEntryTime().until(curentExitTime, ChronoUnit.HOURS);	
		bill.setTotalDuration(diffTotalDuration);
		
		double finalBillAmount=30.0*diffTotalDuration;
		bill.setAmount(finalBillAmount);
		
		// Generating Bill Receipt
		try {
			File billObj = new File("Bill.txt");
			FileWriter finalBill = new FileWriter("Bill.txt");
			finalBill.append("\t\t==================================");
			finalBill.append("\n");
			finalBill.append("\t\t     TEAM 4 CAR PARKING SYSTEM");
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
			finalBill.append("Payment (Charges : 30 Ruppes per Hour)");
			finalBill.append("\n");
			finalBill.append("----------------------------------");
			finalBill.append("\n");
			finalBill.append("Total Amount : " + bill.getAmount());
			finalBill.append("\n");
			
			/*
			if (customer.getPaymentMethod().equals("cash")) {
				finalBill.append(CashPayment.cashPaymentDetails(finalBillAmount));

			} else if (customer.getPaymentMethod().equals("card")) {
				finalBill.append(CardPayment.cardPaymentDetails(finalBillAmount));
			} else {
				finalBill.append("Invaid Payment Method ");
			}
			*/

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
