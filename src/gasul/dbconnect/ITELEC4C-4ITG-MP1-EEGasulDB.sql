DROP DATABASE itelec4c_4itg_mp1_eegasuldb;
CREATE DATABASE itelec4c_4itg_mp1_eegasuldb;
USE itelec4c_4itg_mp1_eegasuldb;

CREATE TABLE CustomerTable (
	CustomerID int NOT NULL AUTO_INCREMENT,
	LastName varchar(300),
	FirstName varchar(300),
	Gasul varchar(300),
	Liters double,
	GasLiterPrice double,
	PurchaseAmount double,
	Vat double,
	TotalAmount double,
	PaymentType varchar(300),
	CardNumber blob,
	PRIMARY KEY (CustomerID)
);