package com.capgemini.donorapplication.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.capgemini.donorapplication.dto.DonorDTO;
import com.capgemini.donorapplication.exception.DonorTransactionException;
import com.capgemini.donorapplication.utility.DbConnection;

/**
 *  Author : CAPGEMINI
 *  Class Name : DonorImplDAO 
 *  Package :com.capgemini.donorapplication.dao 
 *  Date : Nov 21, 2016
 */
public class DonorImplDAO implements IDonorDAO {

	PreparedStatement preparedStatement = null;
	Connection conn = null;
	ResultSet resultSet = null;

	// ---------------- 1. Add donor details ---------------
	/**************************************************************
	 * - Method Name : addDonor() 
	 * - Input Parameters : DonorDTO 
	 * - Return Type :int 
	 * - Throws : DonorTransactionException 
	 * - Author : CAPGEMINI
	 * - Creation Date : Nov 21, 2016 - Description : New donor's detail stored
	 *************************************************************/
	public int addDonor(DonorDTO donor) throws DonorTransactionException {
		int result = 0;
		int sequence = 0;
		try {
			conn = DbConnection.getConnection();
			
			preparedStatement = conn
					.prepareStatement(IQueryMapper.GETSEQUENCEID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sequence = resultSet.getInt(1);
			} else {
				sequence = 0;
			}
			if (sequence != 0) {

				preparedStatement = conn
						.prepareStatement(IQueryMapper.INSERTQUERY);
				preparedStatement.setInt(1, sequence);
				preparedStatement.setString(2, donor.getDonorName());
				preparedStatement.setLong(3, donor.getPhoneNumber());
				preparedStatement.setString(4, donor.getAddress());
				preparedStatement.setDouble(5, donor.getAmount());
				preparedStatement.setDate(6,
						java.sql.Date.valueOf(donor.getDonationDate()));
				result = preparedStatement.executeUpdate();

				if (result == 0) {
					return 0;
				}
			}

		} catch (SQLException e) {
			throw new DonorTransactionException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new DonorTransactionException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new DonorTransactionException(
						"Could not close the connection");
			}
		}
		return sequence;
	}

	// ---------------- 1. Get all donor details ---------------
	/**************************************************************
	 * - Method Name : getAllDonor() 
	 * - Input Parameters : - 
	 * - Return Type :List<DonorDTO> 
	 * - Throws : DonorTransactionException 
	 * - Author : CAPGEMINI
	 * - Creation Date : Nov 21, 2016 
	 * - Description : Retrieval of donor details
	 *************************************************************/
	public List<DonorDTO> getAllDonor() throws DonorTransactionException {
		List<DonorDTO> list = new ArrayList<DonorDTO>();
		DonorDTO dto = new DonorDTO();
		try {
			conn = DbConnection.getConnection();
			preparedStatement = conn.prepareStatement(IQueryMapper.VIEWALL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				dto.setDonorId(resultSet.getInt(1));
				dto.setDonorName(resultSet.getString(2));
				dto.setPhoneNumber(resultSet.getLong(3));
				dto.setAddress(resultSet.getString(4));
				dto.setAmount(resultSet.getDouble(5));
				dto.setDonationDate(resultSet.getDate(6).toLocalDate());
				list.add(dto);
				dto = new DonorDTO();
			}
		} catch (SQLException e) {
			throw new DonorTransactionException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new DonorTransactionException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new DonorTransactionException(
						"Could not close the connection");
			}
		}
		return list;
	}

	// ---------------- 1. Get A donor details ---------------
	/**************************************************************
	 * - Method Name : getDonor() 
	 * - Input Parameters : int 
	 * - Return Type :DonorDTO 
	 * - Throws : DonorTransactionException
	 * - Author : CAPGEMINI
	 * - Creation Date : Nov 21, 2016 
	 * - Description : Search and Retrieve a donor's data
	 *************************************************************/
	public DonorDTO getDonor(int donorId) throws DonorTransactionException {
		DonorDTO dto = new DonorDTO();
		try {
			conn = DbConnection.getConnection();
			preparedStatement = conn.prepareStatement(IQueryMapper.VIEW);
			preparedStatement.setInt(1, donorId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				dto.setDonorId(resultSet.getInt(1));
				dto.setDonorName(resultSet.getString(2));
				dto.setPhoneNumber(resultSet.getLong(3));
				dto.setAddress(resultSet.getString(4));
				dto.setAmount(resultSet.getDouble(5));
				// Convert SQL to Calendar Date
				// Date date = resultSet.getDate(6);
				/*
				 * Calendar cDate = Calendar.getInstance(); cDate.setTime(date);
				 */
				dto.setDonationDate(resultSet.getDate(6).toLocalDate());
			}

		} catch (SQLException e) {
			throw new DonorTransactionException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new DonorTransactionException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new DonorTransactionException(
						"Could not close the connection");
			}
		}
		return dto;
	}

}
