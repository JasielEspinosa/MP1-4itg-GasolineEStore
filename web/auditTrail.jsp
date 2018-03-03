<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="gasul.dbconnect.DatabaseServletContextListener"%>
<%@page import="gasul.dbconnect.Security"%>
<!DOCTYPE html">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Website Logo -->
<link rel="icon" href="images/mp1logotransparent.png">
<!-- CSS -->
<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/audittrail-style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<!-- Bootstrap CSS - CDN Link 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
-->
<title>Gasoline eStore Audit Trail Page - Eslabon Espinosa</title>
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/customers.js"></script>
<script src="dataTables/datatables.min.js"></script>
</head>
<body>
   <!-- Main Container -->
   <div class="container-fluid">
      <!-- Header -->
      <div class="row header">
         <div class="col-sm-4 header__firstcolumn"></div>
         <div class="col-sm-1 img">
            <img src="images/mp1logotransparent.png" class="header__logo">
         </div>
         <div class="col-sm-3 header__title">
            <h1>Gasoline eStore</h1>
         </div>
         <div class="col-sm-2"></div>
      </div>
      <!-- End of Header-->
      <!-- Form Container-->
      <div class="col-sm-8 container align-items-center flex-column">
         <!-- d-flex -->
         <div class="row">
            <div class="form-content-audit col-md-12 ">
               <table id="customers" class="display">
                  <thead>
                     <tr>
                        <th>NAME</th>
                        <th>GAS TYPE</th>
                        <th>TOTAL PURCHASED AMOUNT</th>
                        <th>ORDER DATE</th>
                        <th>ORDER TIME</th>
                     </tr>
                  </thead>
                  <tbody>
                     <%
                     	try {
                     		Connection conn = (Connection) getServletContext().getAttribute("dbconn");
                     		String sql = "SELECT * FROM CustomerPurchaseTable"; /*WHERE CustomerID = ?";*/
                     		PreparedStatement pst = conn.prepareStatement(sql);
                     		ResultSet rs = pst.executeQuery();

                     		while (rs.next()) {
                     %>
                     <tr>
                        <td><%=Security.decrypt(rs.getString("FirstName"))%> <%=Security.decrypt(rs.getString("LastName"))%></td>
                        <td><%=rs.getString("Gasul")%></td>
                        <td>P<%=Security.decrypt(rs.getString("TotalAmount"))%></td>
                        <td><%=Security.decrypt(rs.getString("OrderDate"))%></td>
                        <td><%=Security.decrypt(rs.getString("OrderTime"))%></td>
                     </tr>
                     <%
                     	}
                     	} catch (Exception exp) {
                     		response.sendRedirect("error.jsp");
                     	}
                     %>
                     <!--                         <tr>
                           <td>Code20</td>
                           <td>Premium</td>
                           <td>P26.13</td>
                           <td>2018/02/03</td>
                           <td>11:00 AM</td>
                        </tr> -->
                  </tbody>
               </table>
               <!-- Back Button -->
               <br />
               <div>
                  <form action='index.jsp'>
                     <button type='submit' class="btn btn-primary btn-block form-content__returnbutton">
                        <i class="fas fa-arrow-left fa-sm"></i> Back
                     </button>
                  </form>
               </div>
               <!-- End of Back Button -->
            </div>
         </div>
      </div>
      <!-- End of Form Container -->
   </div>
   <!-- End of Main Container -->
   <!-- Optional JavaScript - Offline Link  -->
   <script src="js/jquery-3.2.1.slim.min.js"></script>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/main.js"></script>
   <!-- Optional JavaScript - CDN Links
        jQuery first, then Popper.js, then Bootstrap JS 
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   -->
   <!-- FontAwesome CDN Link 
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
   -->
</body>
</html>