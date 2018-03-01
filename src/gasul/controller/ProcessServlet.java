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

import bank.exceptions.InvalidCreditCardNumberException;
import bank.exceptions.OtherMessages;
import bank.luhn.ProcessLuhn;
import gasul.model.UserBean;

import gasul.dbconnect.Security;

@WebServlet("")
public class ProcessServlet extends HttpServlet implements InvalidCreditCardNumberException, OtherMessages {
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

		UserBean userDatas = new UserBean(/*((Connection) getServletContext().getAttribute("dbconn")), */firstName, lastName, gasul, liters,
				gasLiterPrice, purchaseAmount, vat, totalAmount, paymentType);
		UserBean cardNumberData = ProcessLuhn.getInstance(cardNumber);

		userDatas.setFirstName(firstName);
		userDatas.setLastName(lastName);
		userDatas.setLiters(liters);

		if (gasul.equals("Unleaded")) {
			gasLiterPrice = 54.00;
		} else if (gasul.equals("Diesel")) {
			gasLiterPrice = 41.00;
		} else if (gasul.equals("Premium")) {
			gasLiterPrice = 58.00;
		} else {
			gasLiterPrice = 54.00;
		}

		userDatas.setGasLiterPrice(gasLiterPrice);

		if (ProcessLuhn.cardValid == false) {

			System.out.println("Card Invalid due Card Number");

			getServletContext().setAttribute("gasLiterPriceTrim", NO_PRICE_MSG_1);
			getServletContext().setAttribute("purchaseAmountTrim", NO_PRICE_MSG_1);
			getServletContext().setAttribute("vatTrim", NO_PRICE_MSG_1);
			getServletContext().setAttribute("totalAmountTrim", NO_PRICE_MSG_1);

			getServletContext().setAttribute("tagalogGLP", NO_PRICE_MSG_2);
			getServletContext().setAttribute("tagalogPA", NO_PRICE_MSG_2);
			getServletContext().setAttribute("tagalogVAT", NO_PRICE_MSG_2);
			getServletContext().setAttribute("tagalogTA", NO_PRICE_MSG_2);

		} else if (ProcessLuhn.cardValid == true) {

			if (((paymentType.equals("VISA") || paymentType.equals("PAY MAYA")) && cardNumber.startsWith("4"))
					|| (paymentType.equals("MASTERCARD") && cardNumber.startsWith("5"))
					|| (paymentType.equals("JCB") && cardNumber.startsWith("35"))
					|| (paymentType.equals("AMEX") && cardNumber.startsWith("37"))
					|| (paymentType.equals("DINERS") && cardNumber.startsWith("3"))
					|| (paymentType.equals("GCASH") && cardNumber.startsWith("6"))) {

				System.out.println("Card Valid");
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

				//Convert to Tagalog

				int pisoGLP = (int) Math.floor(gasLiterPrice);
				double centsGLP = gasLiterPrice - pisoGLP;
				int sentimoGLP = (int) (100 * centsGLP + 0.5);

				String pisoTagalogGLP = tagalog(pisoGLP, false);
				String sentimoTagalogGLP = tagalog(sentimoGLP, false);
				String tagalogOutputGLP = pisoTagalogGLP + ENDPISO + sentimoTagalogGLP + ENDSENTIMO;
				String tagalogOutputTrimGLP = tagalogOutputGLP.substring(0, 1).toUpperCase() + tagalogOutputGLP.substring(1);

				int pisoPA = (int) Math.floor(purchaseAmount);
				double centsPA = purchaseAmount - pisoPA;
				int sentimoPA = (int) (100 * centsPA + 0.5);
				String pisoTagalogPA = tagalog(pisoPA, false);
				String sentimoTagalogPA = tagalog(sentimoPA, false);
				String tagalogOutputPA = pisoTagalogPA + ENDPISO + sentimoTagalogPA + ENDSENTIMO;
				String tagalogOutputTrimPA = tagalogOutputPA.substring(0, 1).toUpperCase() + tagalogOutputPA.substring(1);

				int pisoVAT = (int) Math.floor(vat);
				double centsVAT = vat - pisoVAT;
				int sentimoVAT = (int) (100 * centsVAT + 0.5);
				String pisoTagalogVAT = tagalog(pisoVAT, false);
				String sentimoTagalogVAT = tagalog(sentimoVAT, false);
				String tagalogOutputVAT = pisoTagalogVAT + ENDPISO + sentimoTagalogVAT + ENDSENTIMO;
				String tagalogOutputTrimVAT = tagalogOutputVAT.substring(0, 1).toUpperCase() + tagalogOutputVAT.substring(1);

				int pisoTA = (int) Math.floor(totalAmount);
				double centsTA = totalAmount - pisoTA;
				int sentimoTA = (int) (100 * centsTA + 0.5);

				String pisoTagalogTA = tagalog(pisoTA, false);
				String sentimoTagalogTA = tagalog(sentimoTA, false);
				String tagalogOutputTA = pisoTagalogTA + ENDPISO + sentimoTagalogTA + ENDSENTIMO;
				String tagalogOutputTrimTA = tagalogOutputTA.substring(0, 1).toUpperCase() + tagalogOutputTA.substring(1);

				userDatas.setPaymentType(paymentType);

				connection = (Connection) getServletContext().getAttribute("dbconn");

				String sql = "INSERT INTO CustomerPurchaseTable VALUES (NULL, ?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst = connection.prepareStatement(sql);
					pst.setString(1, Security.encrypt(userDatas.getFirstName()));
					pst.setString(2, Security.encrypt(userDatas.getLastName()));
					pst.setString(3, userDatas.getGasul());
					pst.setDouble(4, userDatas.getLiters());
					pst.setDouble(5, userDatas.getGasLiterPrice());
					pst.setString(6, Security.encrypt(Double.toString(userDatas.getPurchaseAmount())));
					pst.setString(7, Security.encrypt(Double.toString(userDatas.getVat())));
					pst.setString(8, Security.encrypt(Double.toString(userDatas.getTotalAmount())));
					pst.setString(9, userDatas.getPaymentType());
					pst.setString(10, Security.encrypt(cardNumberData.getCardNumber()));
					pst.executeUpdate();
					System.out.println("Database connect result: " + "Pumasok ");
				} catch (SQLException sqle) {
					System.err.println("Database connect result: " + sqle.getMessage());
				} catch (Exception exp) {
					System.err.println("Database connect result: " + exp.getMessage());
				}

				getServletContext().setAttribute("gasLiterPriceTrim", "P" + gasLiterPriceTrim);
				getServletContext().setAttribute("purchaseAmountTrim", "P" + purchaseAmountTrim);
				getServletContext().setAttribute("vatTrim", "P" + vatTrim);
				getServletContext().setAttribute("totalAmountTrim", "P" + totalAmountTrim);

				getServletContext().setAttribute("tagalogGLP", tagalogOutputTrimGLP);
				getServletContext().setAttribute("tagalogPA", tagalogOutputTrimPA);
				getServletContext().setAttribute("tagalogVAT", tagalogOutputTrimVAT);
				getServletContext().setAttribute("tagalogTA", tagalogOutputTrimTA + " :)");

			} else {

				System.out.println("Card Invalid due Bank Company");

				userDatas.setPaymentType("Your card number is not a " + paymentType);

				getServletContext().setAttribute("gasLiterPriceTrim", NO_PRICE_MSG_1);
				getServletContext().setAttribute("purchaseAmountTrim", NO_PRICE_MSG_1);
				getServletContext().setAttribute("vatTrim", NO_PRICE_MSG_1);
				getServletContext().setAttribute("totalAmountTrim", NO_PRICE_MSG_1);

				getServletContext().setAttribute("tagalogGLP", NO_PRICE_MSG_2);
				getServletContext().setAttribute("tagalogPA", NO_PRICE_MSG_2);
				getServletContext().setAttribute("tagalogVAT", NO_PRICE_MSG_2);
				getServletContext().setAttribute("tagalogTA", NO_PRICE_MSG_2);

			}

		}

		getServletContext().setAttribute("gasul", userDatas);
		getServletContext().setAttribute("cardmo", cardNumberData);

		getServletContext().log("Deploying results");
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);

		//request.getRequestDispatcher("output.jsp").forward(request, response);

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
