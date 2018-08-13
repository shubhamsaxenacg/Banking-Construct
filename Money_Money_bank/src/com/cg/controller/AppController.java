package com.cg.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.pojo.CurrentAccount;
import com.cg.pojo.Customer;
import com.cg.pojo.SavingsAccount;
import com.cg.service.BankAccountService;



/**
 * Servlet implementation class AppController
 */
@WebServlet("*.app")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BankAccountService accountService = new BankAccountService();
		HttpSession session = request.getSession();
		String action = request.getServletPath();
		
		switch(action) {
			case "/add.app":
				DateTimeFormatter JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dateOfBirth = LocalDate.parse(request.getParameter("c_dob"), JAVAFormat);
				
				String customerName = request.getParameter("c_Name");
				String emailId = request.getParameter("c_Email");
				long contactNumber = Long.parseLong(request.getParameter("c_contact"));
				String permanentAddress = request.getParameter("c_Address");
				String gender = request.getParameter("gender");
				String nationality = "indian";
				Customer customer = new Customer(customerName, emailId, contactNumber, dateOfBirth, permanentAddress,
						gender, nationality);
				
				if (request.getParameter("c_AccType").equals("sav")) {
					if (request.getParameter("c_salary").equals("salary")) {
						SavingsAccount savingsAccount = new SavingsAccount(customer, true, "Savings");
						accountService.AddNewAccount(savingsAccount);
						System.out.println(accountService.getAccountNo());
						session.setAttribute("accNO", accountService.getAccountNo()-1);
						response.sendRedirect("createSuccess.jsp");
					} else {
						double accountBalance = Double.parseDouble(request.getParameter("c_amount"));
						SavingsAccount savingsAccount = new SavingsAccount(customer, accountBalance, "Savings", false);
						accountService.AddNewAccount(savingsAccount);
						session.setAttribute("accNO", accountService.getAccountNo()-1);
						response.sendRedirect("createSuccess.jsp");
					}
				} else {
					double accountBalance = Double.parseDouble(request.getParameter("c_amount"));
					double odLimit = Double.parseDouble(request.getParameter("c_ODLimit"));
					CurrentAccount currentAccount = new CurrentAccount(customer, accountBalance, "Current", odLimit);
					accountService.AddNewAccount(currentAccount);
					session.setAttribute("accNO", accountService.getAccountNo()-1);
					response.sendRedirect("createSuccess.jsp");
				}
				break;
				
			case "/view.app":
				break;
				
			case "/search.app": 
				break;

			case "/withdraw.app":
				break;
				
			case "/deposit.app":
				break;
				
			case "/transfer.app":
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
