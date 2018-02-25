package gasul.model;

import java.sql.*;

public class UserBean {

	private String firstName;
	private String lastName;
	private String gasul;
	private double liters;
	private double gasLiterPrice;
	private double purchaseAmount;
	private double vat;
	private double totalAmount;
	private String paymentType;
	//private double cardNumber;
	private String cardNumber;
	
	//private Connection connection;

	public UserBean() {

	}

	public UserBean(/*Connection connection, */String firstName, String lastName, String gasul, double liters, double gasLiterPrice,
			double purchaseAmount, double vat, double totalAmount, String paymentType) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.gasul = gasul;
		this.liters = liters;
		this.gasLiterPrice = gasLiterPrice;
		this.purchaseAmount = purchaseAmount;
		this.vat = vat;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		//this.cardNumber = cardNumber;
		//this.connection = connection;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGasul() {
		return gasul;
	}

	public void setGasul(String gasul) {
		this.gasul = gasul;
	}

	public double getLiters() {
		return liters;
	}

	public void setLiters(double liters) {
		this.liters = liters;
	}

	public double getGasLiterPrice() {
		return gasLiterPrice;
	}

	public void setGasLiterPrice(double gasLiterPrice) {
		this.gasLiterPrice = gasLiterPrice;
	}

	public double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

/*	public double getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(double cardNumber) {
		this.cardNumber = cardNumber;
	}*/

/*	public boolean addData() {
		String sql = "INSERT INTO CustomerTable VALUES (NULL, ?,?,?,?,?,?,?,?,?,?)";
		boolean mabuhay = false;
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, this.firstName);
			pst.setString(2, this.lastName);
			pst.setString(3, this.gasul);
			pst.setDouble(4, this.liters);
			pst.setDouble(5, this.gasLiterPrice);
			pst.setDouble(6, this.purchaseAmount);
			pst.setDouble(7, this.vat);
			pst.setDouble(8, this.totalAmount);
			pst.setString(9, this.paymentType);
			pst.setString(10, this.cardNumber);
			pst.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("Database connect result: " + sqle.getMessage());
		} catch (Exception exp) {
			System.err.println("Database connect result: " + exp.getMessage());
		}
		return mabuhay;
	}*/

}
