package com.capgemini.donorapplication.service;

import java.util.List;

import com.capgemini.donorapplication.dao.DonorImplDAO;
import com.capgemini.donorapplication.dto.DonorDTO;
import com.capgemini.donorapplication.exception.DonorTransactionException;


public interface IDonorService {
	public int addDonor(DonorDTO donor) throws DonorTransactionException;

	public DonorDTO getDonor(int donorId) throws DonorTransactionException;

	public List<DonorDTO> getAllDonor()throws DonorTransactionException;
}
