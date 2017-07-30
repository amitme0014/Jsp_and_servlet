package com.capgemini.donorapplication.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Author 		: CAPGEMINI 
 * Class Name 	: DonorDTO 
 * Package 		: com.capgemini.donorapplication.dto 
 * Date 		: Nov 21, 2016
 */

public class DonorDTO {
	private int donorId;
	private String donorName;
	private long phoneNumber;
	private String address;
	private double amount;
	private LocalDate donationDate;

	/**
	 * Constructors
	 */

	public DonorDTO() {

	}

	public DonorDTO(int donorId, String donorName, long phoneNumber,
			String address, double amount) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.amount = amount;
	}

	/**
	 * Getter and Setter Methods
	 */

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDonationDate() {
		/* Calendar Date Converted to String format for Displaying to User */
		/*java.util.Date date = donationDate.getTime();
		SimpleDateFormat frmat = new SimpleDateFormat("dd-MMM-yyyy");
		String jDate = frmat.format(date);*/
		return donationDate;
	}

	public void setDonationDate(LocalDate localDate) {
		this.donationDate = localDate;
	}

	/**
	 * toString() Method
	 */
	public String toString() {

		return "<tr><td>" + donorId + "</td><td>" + donorName + "</td><td>"
				+ phoneNumber + "</td><td>" + address + "</td><td>" + amount
				+ "</td><td>" + donationDate + "</td></tr>";
	}
}
