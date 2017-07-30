package com.capgemini.donorapplication.dao;

import java.util.List;

import com.capgemini.donorapplication.dto.DonorDTO;
import com.capgemini.donorapplication.exception.DonorTransactionException;

public interface IDonorDAO {
	public int addDonor(DonorDTO donor) throws DonorTransactionException;

	public DonorDTO getDonor(int donorId) throws DonorTransactionException;

	public List<DonorDTO> getAllDonor()throws DonorTransactionException;

}
