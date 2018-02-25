<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gasoline eStore Purchase Page - Eslabon Espinosa</title>
</head>

<body>
   <div>
      <b>Customer Name: ${gasul.firstName} ${gasul.lastName}</b>
   </div>
   <div>
      <b>Fuel Type: ${gasul.gasul}</b>
   </div>
   <%--    <div>
      <b>${gasul.liters}</b>
   </div> --%>
   <div>
      <b>Price per Liter Amount: P${gasLiterPriceTrim}</b>
   </div>
   <div>
      <b>Purchase Amount: ${purchaseAmountTrim}</b>
   </div>
   <div>
      <b>VAT: ${vatTrim}</b>
   </div>
   <div>
      <b>TOTAL AMOUNT: ${totalAmountTrim}</b>
   </div>
      <div>
      <b> ${tagalog}</b>
   </div>
   <div>
      <b>${gasul.paymentType}</b>
   </div>
   <div>
      <b>${cardmo.cardNumber}</b>
   </div>
   <div>
      <form action='index.jsp'>
         <input type='submit' value='Go Back' />
      </form>
   </div>
</body>
</html>