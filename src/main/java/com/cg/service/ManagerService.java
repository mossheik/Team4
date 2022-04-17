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


	//Display All Added Parking Slots
	public List<Slot> getAllParkingSlots()
	{
		return slotRepository.findAll();
	}

	//Display All Vacant/Available Parking Slots
	public List<Slot> showAvailableParkingSlots()
	{
		return slotRepository.findAllAvailableSlot();
	}

	//Add Customer in Bill Table and Generate Receipt
	public String generateReceipt(int customerId)
	{
//		Customer customer=customerRepository.findById(id).get();

		//Setting Receipt Details
//
//
//		bill.setCustomer(customer);
//		bill.setDate(LocalDate.now());
//		bill.setEntryTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
//		billRepository.save(bill);
//
//		//Generating Receipt
//		try {
//			FileWriter receipt = new FileWriter("Receipt.txt");
//			receipt.append("\t\t=========================================");
//			receipt.append("\n");
//			receipt.append("\t\t  TEAM 4 - CAR PARKING SYSTEM (Receipt)");
//			receipt.append("\n");
//			receipt.append("\t\t=========================================");
//			receipt.append("\n");
//			receipt.append("----------------------------------");
//			receipt.append("\n");
//			receipt.append("Receipt Details");
//			receipt.append("\n");
//			receipt.append("----------------------------------");
//			receipt.append("\n");
//			receipt.append("Bill Id : "+bill.getBillId());
//			receipt.append("\n");
//			receipt.append("Date : "+bill.getDate());
//			receipt.append("\n");
//			receipt.append("----------------------------------");
//			receipt.append("\n");
//			receipt.append("Customer Details");
//			receipt.append("\n");
//			receipt.append("----------------------------------");
//			receipt.append("\n");
//			receipt.append("Customer Id : "+customer.getCustomerId());
//			receipt.append("\n");
//			receipt.append("Name : "+customer.getName());
//			receipt.append("\n");
//			receipt.append("Phone Number : "+customer.getPhoneNumber());
//			receipt.append("\n");
//			receipt.append("Vehicle Number : "+customer.getVehicleNumber());
//			receipt.append("\n");
//			receipt.append("Token Number : "+customer.isHasToken());
//			receipt.append("\n");
//			receipt.append("Parking Position : "+customer.getSlotNo());
//			receipt.append("\n");
//			receipt.append("Entry Time : "+bill.getEntryTime());
//			receipt.append("\n");
//			receipt.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "DeleteThisLine";
	}

	//Generate Final Bill with Amount
	public String generateBill(int billId) {
//
//		long diffTotalDuration=ChronoUnit.HOURS.between(bill.getEntryTime(), bill.getExitTime());
//		bill.setTotalDuration(diffTotalDuration);
//
//		double finalBillAmount=60.0;
//		if(diffTotalDuration<1)
//			bill.setAmount(finalBillAmount);
//		else {
//			finalBillAmount=60*(double)diffTotalDuration;
//			bill.setAmount(finalBillAmount);
//		}
//		billRepository.save(bill);
//
//		// Generating Bill Receipt
//		try {
//			FileWriter finalBill = new FileWriter("Bill.txt");
//			finalBill.append("\t\t==================================");
//			finalBill.append("\n");
//			finalBill.append("\t\t  TEAM 4 CAR PARKING SYSTEM (Bill)");
//			finalBill.append("\n");
//			finalBill.append("\t\t==================================");
//			finalBill.append("\n");
//			finalBill.append("----------------------------------");
//			finalBill.append("\n");
//			finalBill.append("Bill Details");
//			finalBill.append("\n");
//			finalBill.append("----------------------------------");
//			finalBill.append("\n");
//			finalBill.append("Bill Id : " + bill.getBillId());
//			finalBill.append("\n");
//			finalBill.append("Date : " + bill.getDate());
//			finalBill.append("\n");
//			finalBill.append("----------------------------------");
//			finalBill.append("\n");
//			finalBill.append("Customer Details");
//			finalBill.append("\n");
//			finalBill.append("----------------------------------");
//			finalBill.append("\n");
//			finalBill.append("Customer Id : " + customer.getCustomerId());
//			finalBill.append("\n");
//			finalBill.append("Name : " + customer.getName());
//			finalBill.append("\n");
//			finalBill.append("Phone Number : " + customer.getPhoneNumber());
//			finalBill.append("\n");
//			finalBill.append("Vehicle Number : " + customer.getVehicleNumber());
//			finalBill.append("\n");
//			finalBill.append("Token Number : "+customer.isHasToken());
//			finalBill.append("\n");
//			finalBill.append("Parking Position : "+customer.getSlotNo());
//			finalBill.append("\n");
//			finalBill.append("Entry Time : " + bill.getEntryTime());
//			finalBill.append("\n");
//			finalBill.append("Exit Time : " + bill.getExitTime());
//			finalBill.append("\n");
//			finalBill.append("Parking Duration (in Hours) : " + bill.getTotalDuration());
//			finalBill.append("\n");
//			finalBill.append("----------------------------------");
//			finalBill.append("\n");
//			finalBill.append("Payment (Charges : 60 Ruppes per Hour)");
//			finalBill.append("\n");
//			finalBill.append("----------------------------------");
//			finalBill.append("\n");
//			finalBill.append("Total Amount : " + bill.getAmount());
//			finalBill.append("\n");
//
//			//Check for Duration : If 0 assign 1
//			if(diffTotalDuration<1)
//			{
//				bill.setTotalDuration(1);
//				bill.setAmount(finalBillAmount);
//			}
//			else {
//				bill.setTotalDuration(diffTotalDuration);
//				finalBillAmount=60*(double)diffTotalDuration;
//				bill.setAmount(finalBillAmount);
//			}
//
//			//Saving Bill Details in Bill Table
//			billRepository.save(bill);
//
//			//Generating Final Bill in File
//			try {
//				FileWriter finalBill = new FileWriter("Bill.txt");
//				finalBill.append("\t\t==================================");
//				finalBill.append("\n");
//				finalBill.append("\t\t     TEAM 4 CAR PARKING SYSTEM (Bill)");
//				finalBill.append("\n");
//				finalBill.append("\t\t==================================");
//				finalBill.append("\n");
//				finalBill.append("----------------------------------");
//				finalBill.append("\n");
//				finalBill.append("Bill Details");
//				finalBill.append("\n");
//				finalBill.append("----------------------------------");
//				finalBill.append("\n");
//				finalBill.append("Bill Id : " + bill.getBillId());
//				finalBill.append("\n");
//				finalBill.append("Date : " + bill.getDate());
//				finalBill.append("\n");
//				finalBill.append("----------------------------------");
//				finalBill.append("\n");
//				finalBill.append("Customer Details");
//				finalBill.append("\n");
//				finalBill.append("----------------------------------");
//				finalBill.append("\n");
//				finalBill.append("Customer Id : " + bill.getCustomer().getCustomerId());
//				finalBill.append("\n");
//				finalBill.append("Name : " + bill.getCustomer().getName());
//				finalBill.append("\n");
//				finalBill.append("Phone Number : " + bill.getCustomer().getPhoneNumber());
//				finalBill.append("\n");
//				finalBill.append("Vehicle Number : " + bill.getCustomer().getVehicleNumber());
//				finalBill.append("\n");
//				finalBill.append("Token Number : "+bill.getCustomer().isHasToken());
//				finalBill.append("\n");
//				finalBill.append("Parking Position : "+bill.getCustomer().getSlotNo());
//				finalBill.append("\n");
//				finalBill.append("Entry Time : " + bill.getEntryTime());
//				finalBill.append("\n");
//				finalBill.append("Exit Time : " + bill.getExitTime());
//				finalBill.append("\n");
//				finalBill.append("Parking Duration (in Hours) : " + bill.getTotalDuration());
//				finalBill.append("\n");
//				finalBill.append("----------------------------------");
//				finalBill.append("\n");
//				finalBill.append("Payment (Charges : 60 Ruppes per Hour)");
//				finalBill.append("\n");
//				finalBill.append("----------------------------------");
//				finalBill.append("\n");
//				finalBill.append("Total Amount : " + bill.getAmount());
//				finalBill.append("\n");
//
//				finalBill.close();
//
//				//Getting Customer details by Id from bill
//				Customer customer=customerRepository.getById(bill.getCustomer().getCustomerId());
//
//				//Calling Customer Exit to reset Values
//				customerExit(customer);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return "Bill generated";
//		}else
//		{
//			return "Receipt Not Generated or Entered Bill Id is Wrong!";
//		}
		return "Delete This Line";
	}

	//Customer Exit
	public void customerExit(Customer customer)
	{
		//Setting Customer hasToken to False and Increment token
		customer.setHasToken(false);
		Token.tokenCount++;

		//Getting Customer SlotNo
		String customersSlot=customer.getSlotNo();

		//Getting Slot using customerSlot and Setting Vacant
		Slot s=slotRepository.findBySlotNo(customersSlot);
		s.setSlotStatus("Vacant");

		//Setting Customer slotNo to Null
		customer.setSlotNo(null);

		//Saving Slot in Slot Table
		slotRepository.save(s);
	}

}
