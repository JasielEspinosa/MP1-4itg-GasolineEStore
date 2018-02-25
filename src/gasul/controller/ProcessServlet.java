package gasul.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.luhn.ProcessLuhn;
import gasul.model.UserBean;

@WebServlet("")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gasul = request.getParameter("gasolineType");
		double liters = Double.parseDouble(request.getParameter("liters"));
		String paymentType = request.getParameter("paymentType");
		String cardNumber = request.getParameter("cardNumber");

		getServletContext().log("First Name: " + firstName);
		getServletContext().log("Last Name: " + lastName);
		getServletContext().log("Gasul Type: " + gasul);
		getServletContext().log("No. of Liters: " + liters);
		getServletContext().log("Payment CC Type: " + paymentType);
		getServletContext().log("Card Number: " + cardNumber);

		double gasLiterPrice = 0;
		double purchaseAmount = 0;
		double vat = 0;
		double totalAmount = 0;

		DecimalFormat decipogi = new DecimalFormat("#,###,###.00");

		UserBean userDatas = new UserBean(/*((Connection) getServletContext().getAttribute("dbconn")), */firstName, lastName, gasul, liters, gasLiterPrice, purchaseAmount, vat, totalAmount, paymentType);
		UserBean cardNumberData = ProcessLuhn.getInstance(cardNumber);

		userDatas.setFirstName(firstName);
		userDatas.setLastName(lastName);
		userDatas.setLiters(liters);

		if (gasul.equals("Unleaded")) {
			userDatas.setGasLiterPrice(54.00);
		} else if (gasul.equals("Diesel")) {
			userDatas.setGasLiterPrice(41.00);
		} else if (gasul.equals("Premium")) {
			userDatas.setGasLiterPrice(58.00);
		} else {
			userDatas.setGasLiterPrice(54.00);
		}

		gasLiterPrice = userDatas.getGasLiterPrice();
		String gasLiterPriceTrim = decipogi.format(gasLiterPrice);

		purchaseAmount = userDatas.getLiters() * userDatas.getGasLiterPrice();
		userDatas.setPurchaseAmount(purchaseAmount);
		String purchaseAmountTrim = decipogi.format(purchaseAmount);

		vat = purchaseAmount * 0.12;
		userDatas.setVat(vat);
		String vatTrim = decipogi.format(vat);

		totalAmount = purchaseAmount + userDatas.getVat();
		userDatas.setTotalAmount(totalAmount);
		String totalAmountTrim = decipogi.format(totalAmount);

		//int totalAmountInt = (int) totalAmount;

		//get cents
		int piso = (int) Math.floor(totalAmount);
		double cents = totalAmount - piso;
		int sentimo = (int) (100 * cents);

		String pisoTagalog = tagalog(piso, false);
		String sentimoTagalog = tagalog(sentimo, false);

		//System.out.println("dollars: " + piso);
		//System.out.println("cents: " + cents);
		//System.out.println("centsAsInt: " + sentimo);
		//System.out.println(pisoTagalog + "ng piso at " + sentimoTagalog + "ng sentimo");

		String tagalogOutput = pisoTagalog + "ng piso at " + sentimoTagalog + "ng sentimo";
		String tagalogOutputTrim = tagalogOutput.substring(0, 1).toUpperCase() + tagalogOutput.substring(1);

		userDatas.setPaymentType(paymentType);
		
		connection = (Connection) getServletContext().getAttribute("dbconn");
		
		String sql = "INSERT INTO CustomerTable VALUES (NULL, ?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, userDatas.getFirstName());
			pst.setString(2, userDatas.getLastName());
			pst.setString(3, userDatas.getGasul());
			pst.setDouble(4, userDatas.getLiters());
			pst.setDouble(5, userDatas.getGasLiterPrice());
			pst.setDouble(6, userDatas.getPurchaseAmount());
			pst.setDouble(7, userDatas.getVat());
			pst.setDouble(8, userDatas.getTotalAmount());
			pst.setString(9, userDatas.getPaymentType());
			pst.setString(10, cardNumberData.getCardNumber());
			pst.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("Database connect result: " + sqle.getMessage());
		} catch (Exception exp) {
			System.err.println("Database connect result: " + exp.getMessage());
		}

		request.setAttribute("gasul", userDatas);
		request.setAttribute("cardmo", cardNumberData);
		request.setAttribute("gasLiterPriceTrim", gasLiterPriceTrim);
		request.setAttribute("purchaseAmountTrim", purchaseAmountTrim);
		request.setAttribute("vatTrim", vatTrim);
		request.setAttribute("totalAmountTrim", totalAmountTrim);
		request.setAttribute("tagalog", tagalogOutputTrim);

		getServletContext().log("Deploying results");
		//getServletContext().getRequestDispatcher("output.jsp").forward(request, response);

		request.getRequestDispatcher("output.jsp").forward(request, response);

	}

	private static final String extraRaan = "raan";
	private static final String extraIsa = "isan";
	private static final String MINUS = "negatibo";
	private static final String ZERO = "zero";
	private static final String[] digits = { "", "isa", "dalawa", "tatlo", "apat", "lima", "anim", "pito", "walo", "siyam", "sampu" };
	private static final String[] groupName = { "", "daan", "libo", "milyon", "bilyon", "trilyon", "kwadrilyon", "kwintilyon" };
	private static final String[] TYS = { "", "sampu", "dalawampu", "tatlumpu", "apatnapu", "limampu", "animnapu", "pitumpu", "walumpu",
			"siyamnapu" };
	private static final int[] divisor = { 100, 10, 1000, 1000, 1000, 1000, 1000, 1000 };

	private static String appendAnd(String s) {
		switch (s.charAt(s.length() - 1)) {
			case 'u':
				return s.substring(0, s.length() - 1) + "u't";
			case 'o':
				return s.substring(0, s.length() - 1) + "o't";
			case 'n':
			default:
				return s.substring(0, s.length() - 1) + "'t";
		}
	}

	private static String lowName(int i) {
		String s;
		if (i < 11) {
			s = digits[i];
		} else {
			s = teens(i);
		}
		return s;
	}

	private static String makeMultiplicative(String s) {
		String suffix;
		switch (s.charAt(s.length() - 1)) {
			case 'm':
			case 't':
				suffix = " na";
				break;
			default:
				suffix = "ng";
				break;
		}
		return s + suffix;
	}

	private static String teens(int teen) {
		String prefix;
		switch (teen) {
			case 11:
			case 14:
			case 16:
				prefix = "labing-";
				break;
			case 12:
			case 13:
			case 15:
				prefix = "labin";
				break;
			case 17:
				prefix = "labim";
				break;
			case 18:
				prefix = "labing";
				break;
			case 19:
				prefix = "labin";
				break;
			default:
				throw new IllegalArgumentException("teens parm not 11..19");
		}
		return prefix + digits[teen % 10];
	}

	public static String tagalog(long num, boolean andDone) {
		if (num == 0) {
			return ZERO;
		}
		boolean negative = (num < 0);
		if (negative) {
			num = -num;
		}
		String s = "";
		for (int group = 0; num > 0; group++) {
			int remdr = (int) (num % divisor[group]);
			num = num / divisor[group];
			if (remdr == 0) {
				continue;
			}
			String t;
			if (remdr < 20) {
				t = lowName(remdr);
			} else if (remdr < 100) {
				int units = remdr % 10;
				int tens = remdr / 10;
				if (units == 0) {
					t = TYS[tens];
				} else {
					t = appendAnd(TYS[tens]) + " " + lowName(units);
					andDone = true;
				}
			} else {
				t = tagalog(remdr, andDone);
			}
			String groupWord = groupName[group];
			boolean leftPad = (t.length() > 0);
			boolean rightPad = (groupWord.length() > 0);

			if (group == 1 && remdr % 10 == 4) {
				groupWord = extraRaan;
			}
			if (groupWord.length() > 0) {
				t = makeMultiplicative(t);
			}
			if (group == 1 && remdr == 1) {
				t = extraIsa;
				leftPad = false;
			}
			if (!andDone && (s.length() != 0)) {
				groupWord = appendAnd(groupWord);
				andDone = true;
			}
			s = t + (leftPad ? " " : "") + groupWord + (rightPad ? " " : "") + s;
		}
		s = s.trim();
		if (negative) {
			s = MINUS + " " + s;
		}
		return s;
	}

}
