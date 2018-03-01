DROP DATABASE itelec4c_4itg_mp1_eegasuldb;
CREATE DATABASE itelec4c_4itg_mp1_eegasuldb;
USE itelec4c_4itg_mp1_eegasuldb;

CREATE TABLE CustomerPurchaseTable (
	CustomerID int NOT NULL AUTO_INCREMENT,
	LastName varchar(300),
	FirstName varchar(300),
	Gasul varchar(300),
	Liters double,
	GasLiterPrice double,
	PurchaseAmount varchar(500),
	Vat varchar(500),
	TotalAmount varchar(500),
	PaymentType varchar(300),
	CardNumber varchar(500),
	OrderDate varchar(500),
	OrderTime varchar(500),
	PRIMARY KEY (CustomerID)
);