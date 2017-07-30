package com.capgemini.donorapplication.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.donorapplication.dto.DonorDTO;
import com.capgemini.donorapplication.exception.DonorTransactionException;
import com.capgemini.donorapplication.service.DonorImplService;

/**
 *  Author : CAPGEMINI
 *  Class Name : DonorTransactionServlet 
 *  Package :com.capgemini.donorapplication.controller; 
 *  Date : Nov 21, 2016
 */

@WebServlet("*.obj")
public class DonorTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonorTransactionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		DonorImplService donorService = null;
		DonorDTO donor = null;
		String target = "";

		HttpSession session = request.getSession(true);
		// Object creations
		donor = new DonorDTO();
		donorService = new DonorImplService();
		int donorId = 0;
		String targetAdd = "view/addDonor.jsp";
		String targetSuccess = "view/success.jsp";
		String targetView = "view/viewDonation.jsp";
		String targetViewAll = "view/viewAllDonations.jsp";
		String targetError = "view/error.jsp";
		String targetHome = "view/index.jsp";

		String path = request.getServletPath().trim();

		switch (path) {

		case "/Home.obj":
			session.setAttribute("error", null);
			session.setAttribute("donor", null);
			target = targetHome;
			break;

			// Redirect to Add donor Page

		case "/Add Donor.obj":
			target = targetAdd;
			break;

			// Code for Donating***********************/
		case "/Donate Now.obj":

			List<String> errorList = new ArrayList<String>();

			String donorName = request.getParameter("donorName").trim();
			long phoneNumber = Long.parseLong(request.getParameter(
					"phoneNumber").trim());
			String address = request.getParameter("address").trim();
			double amount = Double.parseDouble(request.getParameter("amount")
					.trim());

			donor.setDonorName(donorName);
			donor.setAddress(address);
			donor.setPhoneNumber(phoneNumber);
			donor.setAmount(amount);

			donor.setDonationDate(LocalDate.now());
			errorList = donorService.isValidated(donor);

			if (errorList.isEmpty()) {
				/************ Code for Adding donation Details **************/
				try {
					donorId = donorService.addDonor(donor);
				} catch (DonorTransactionException e) {
					session.setAttribute("error", e.getMessage());
					target = targetError;
				}
				if (donorId != 0) {
					donor.setDonorId(donorId);

					// set ID to display ID alone
					// session.setAttribute("donorId", donorId);
					session.setAttribute("donor", donor);
					target = targetSuccess;
				}

			} else {
				session.setAttribute("errorList", errorList);
				target = targetAdd;
			}

			break;
			// Redirect to View Donation Page
		case "/View Donor.obj":
			target = targetView;
			break;
			// Code for Searching a particular donor history
		case "/Search.obj":
			donorId = Integer.parseInt(request.getParameter("donorId"));
			try {
				donor = donorService.getDonor(donorId);
			} catch (DonorTransactionException e) {
				session.setAttribute("error", e.getMessage());
				target = targetError;
			}
			if (donor.getDonorId() != 0) {
				session.setAttribute("error", null);
				session.setAttribute("donor", donor);
				target = targetView;
			} else {
				session.setAttribute("donor", null);
				session.setAttribute("error",
						"Sorry No data Found for given ID!");
				target = targetError;
			}

			break;

			// Redirect to View All Donation Page
		case "/View All Donors.obj":
			List<DonorDTO> donorList = null;
			try {
				donorList = donorService.getAllDonor();
			} catch (DonorTransactionException e) {
				session.setAttribute("error", e.getMessage());
				target = targetError;
			}
			if (!donorList.isEmpty()) {
				session.setAttribute("error", null);
				session.setAttribute("donorList", donorList);
				target = targetViewAll;
			} else {
				session.setAttribute("donorList", null);
				session.setAttribute("error", "Sorry No data Found!");
				target = targetViewAll;
			}

			break;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}
