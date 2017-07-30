package com.capgemini.donorapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.donorapplication.dao.DonorImplDAO;
import com.capgemini.donorapplication.dao.IDonorDAO;
import com.capgemini.donorapplication.dto.DonorDTO;
import com.capgemini.donorapplication.exception.DonorTransactionException;

/**
 * Author 		: CAPGEMINI 
 * Class Name 	: DonorDTO 
 * Package 		: com.capgemini.donorapplication.dto 
 * Date 		: Nov 21, 2016
 */

public class DonorImplService implements IDonorService {
	IDonorDAO dao = new DonorImplDAO();

	public int addDonor(DonorDTO donor) throws DonorTransactionException {

		int result = dao.addDonor(donor);
		return result;
	}

	public List<DonorDTO> getAllDonor() throws DonorTransactionException {

		List<DonorDTO> list = dao.getAllDonor();
		return list;
	}

	public DonorDTO getDonor(int donorId) throws DonorTransactionException {
		DonorDTO dto = new DonorDTO();

		dto = dao.getDonor(donorId);
		return dto;

	}

	public List<String> isValidated(DonorDTO donor) {
		List<String> errorList = new ArrayList<String>();

		Pattern pattern = null;
		Matcher matcher = null;

		// Donor Name Validation
		pattern = Pattern.compile("^[A-Za-z\\s]{3,25}$");
		matcher = pattern.matcher(donor.getDonorName());
		if (!matcher.matches()) {
			errorList.add("Please enter a valid Name");
		}

		// Phone Number Validation
		if (donor.getPhoneNumber() <= 999999999) {
			errorList.add("Please enter a valid Phone Number");
		}

		// Address Validation
		pattern = Pattern.compile("^[A-Za-z0-9\\s,./]{3,}$");
		matcher = pattern.matcher(donor.getAddress());
		if (!matcher.matches()) {
			errorList.add("Please enter a valid Address");
		}

		// Amount Validation
		if (donor.getAmount() <= 0) {
			errorList.add("Please enter a valid Amount");
		}
		return errorList;
	}

}
