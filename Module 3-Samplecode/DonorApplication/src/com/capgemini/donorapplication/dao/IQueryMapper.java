package com.capgemini.donorapplication.dao;

public interface IQueryMapper {
	String GETSEQUENCEID = "SELECT donorId_Sequence.NEXTVAL FROM dual";
	String INSERTQUERY="INSERT INTO donor VALUES(?,?,?,?,?,?)";
	String VIEWALL = "SELECT donor_id, donor_name, phone_number, address, amount,donation_date FROM donor";
	String VIEW = "SELECT donor_id, donor_name, phone_number, address, amount,donation_date FROM donor WHERE donor_id=?";

}
