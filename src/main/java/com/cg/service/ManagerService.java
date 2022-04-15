package com.cg.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Bill;
import com.cg.entity.CardPayment;
import com.cg.entity.CashPayment;
import com.cg.entity.Customer;
import com.cg.entity.Slot;
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

	public String generateBill(int id) {

		Customer customer = customerRepository.findById(id).get();
		// Setting Bill Details

		Bill bill = new Bill();
		int billId = count.incrementAndGet();
		bill.setBillId(billId);
		ZoneId zonedId = ZoneId.of("Asia/Kolkata");
		LocalDate date = LocalDate.now(zonedId);
		bill.setDate(date);
		int amount = customer.getParkingDuration()*30;
		bill.setAmount(amount);

		// Generating Bill Receipt
		try {
			File billObj = new File("Bill.txt");
			FileWriter billReceipt = new FileWriter("Bill.txt");
			billReceipt.append("\t\t==================================");
			billReceipt.append("\n");
			billReceipt.append("\t\t     TEAM 4 CAR PARKING SYSTEM");
			billReceipt.append("\n");
			billReceipt.append("\t\t==================================");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Bill Details");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Bill Id : " + bill.getBillId());
			billReceipt.append("\n");
			billReceipt.append("Date : " + bill.getDate());
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Customer Details");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Customer Id : " + customer.getCustomerId());
			billReceipt.append("\n");
			billReceipt.append("Name : " + customer.getName());
			billReceipt.append("\n");
			billReceipt.append("Phone Number : " + customer.getPhoneNumber());
			billReceipt.append("\n");
			billReceipt.append("Vehicle Number : " + customer.getVehicleNumber());
			billReceipt.append("\n");
			billReceipt.append("Token Number : "+customer.getHasToken());
			billReceipt.append("\n");
			billReceipt.append("Parking Position : "+customer.getSlotNo());
			billReceipt.append("\n");
			billReceipt.append("Parking Duration (in Hours) : " + customer.getParkingDuration());
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Payment (Charges : 30 Ruppes per Hour)");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Total Amount : " + bill.getAmount());
			billReceipt.append("\n");

			if (customer.getPaymentMethod().equals("cash")) {
				billReceipt.append(CashPayment.cashPaymentDetails(amount));

			} else if (customer.getPaymentMethod().equals("card")) {
				billReceipt.append(CardPayment.cardPaymentDetails(amount));
			} else {
				billReceipt.append("Invaid Payment Method ");
			}

			billReceipt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Bill generated";

	}
	
	
	public String generateReceipt(int id)
	{

		Customer customer=customerRepository.findById(id).get();
		//Setting Bill Details
		
		Bill bill = new Bill();
		int billId = count.incrementAndGet(); 
		bill.setBillId(billId);
		ZoneId zonedId = ZoneId.of( "Asia/Kolkata");
		LocalDate date = LocalDate.now( zonedId );
		bill.setDate(date);
		int amount = customer.getParkingDuration()*30;
		bill.setAmount(amount);
	
		//Generating Bill Receipt
		try {
			File billObj = new File("Bill.txt");
			FileWriter billReceipt = new FileWriter("Bill.txt");
			billReceipt.append("\t\t==================================");
			billReceipt.append("\n");
			billReceipt.append("\t\t     TEAM 4 CAR PARKING SYSTEM");
			billReceipt.append("\n");
			billReceipt.append("\t\t==================================");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Bill Details");
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
			billReceipt.append("Token Number : "+customer.getHasToken());
			billReceipt.append("\n");
			billReceipt.append("Parking Position : "+customer.getSlotNo());
			billReceipt.append("\n");
			billReceipt.append("Parking Duration (in Hours) : "+customer.getParkingDuration());
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");
			billReceipt.append("Payment (Charges : 30 Ruppes per Hour)");
			billReceipt.append("\n");
			billReceipt.append("----------------------------------");
			billReceipt.append("\n");		
			billReceipt.append("Total Amount : "+bill.getAmount());
			billReceipt.append("\n");		

			if(customer.getPaymentMethod().equals("cash")) {
				billReceipt.append(CashPayment.cashPaymentDetails(amount));

			}
			else if(customer.getPaymentMethod().equals("card")) {
				billReceipt.append(CardPayment.cardPaymentDetails(amount));
			}
			else {
				billReceipt.append("Invaid Payment Method ");
			}
			
			
			billReceipt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Bill generated";
		
		
		
	}
	
	
}
