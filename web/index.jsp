<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gasoline eStore Home Page - Eslabon Espinosa</title>
</head>
<body>
   <div>
      <h1>Here to put labels</h1>
   </div>
   <form action='gasulgaming.proc' method=post>
      <div>
         <label>Customer First Name</label> <input type="text" name="firstName" id="firstName" required="required">
      </div>
      <div>
         <label>Customer Last Name</label> <input type="text" name="lastName" id="lastName" required="required">
      </div>
      <div>
         <label>Enter Gasoline Type</label> <select name="gasolineType" required="required">
            <!--  <option selected="selected" disabled="disabled">Select Gasul Type</option> -->
            <option value="Unleaded">Unleaded</option>
            <option value="Diesel">Diesel</option>
            <option value="Premium">Premium</option>
         </select>
      </div>
      <div>
         <label>Enter Number of Liters</label> <input type="number" name="liters" id="liters" min="1" required="required">
      </div>
      <div>
         <label>Payment CC Type</label>
         <div>
            <label><input type="radio" name="paymentType" value="VISA" required="required">VISA</label>
         </div>
         <div>
            <label><input type="radio" name="paymentType" value="MASTERCARD">MASTERCARD</label>
         </div>
         <div>
            <label><input type="radio" name="paymentType" value="JCB">JCB</label>
         </div>
         <div>
            <label><input type="radio" name="paymentType" value="AMEX">AMEX</label>
         </div>
         <div>
            <label><input type="radio" name="paymentType" value="DINERS">DINERS</label>
         </div>
         <div>
            <label><input type="radio" name="paymentType" value="GCASH">GCASH</label>
         </div>
         <div>
            <label><input type="radio" name="paymentType" value="PAY MAYA">PAY MAYA</label>
         </div>
      </div>
      <div>
         <label>Enter Credit Card Number</label> <input type="number" name="cardNumber" id="cardNumber" min="1000000000000000"
            max="9999999999999999" required="required">
      </div>
      <div>
         <input type="submit" id='submit' value='Submit'> <input type='reset' value='Ulit' />
      </div>
   </form>
</body>
</html>