<!DOCTYPE html">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Website Logo -->
<link rel="icon" href="images/mp1logotransparent.png">
<!-- Bootstrap CSS - Offline Links  -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<!-- Bootstrap CSS - CDN Link 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    -->
<title>Gasoline eStore Purchase Page - Eslabon Espinosa</title>
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
         <div class="col-sm-4 header__thirdcolumn"></div>
      </div>
      <!-- End of Header-->
      <!-- Form Container-->
      <div class="d-flex align-items-center flex-column">
         <div class="row">
            <div class="form-content col-md-12">
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
                  <b>Purchase Amount: P${purchaseAmountTrim}</b>
               </div>
               <div>
                  <b>VAT: P${vatTrim}</b>
               </div>
               <div>
                  <b>TOTAL AMOUNT: P${totalAmountTrim}</b>
               </div>
               <div>
                  <p>
                     <b>Nagbubuo ito ng ${tagalogGLP}ng price per liter, <br /> ${tagalogPA} na purchased amount, <br /> ${tagalogVAT}
                        na value-added tax, at ang kabuuan ng <br /> ${tagalogTA}.
                     </b>
                  <p>
               </div>
               <div>
                  <b>Na ginamit ang ${gasul.paymentType}Card</b>
               </div>
               <div>
                  <b>${cardmo.cardNumber}</b>
               </div>
               <div>
                  <form action='index.jsp'>
                     <input type='submit' value='Go Back' />
                  </form>
                  <!-- End of Form -->
               </div>
            </div>
         </div>
      </div>
      <!-- End of Form Container -->
   </div>
   <!-- End of Main Container -->
<!--    <div id="loading"></div> -->
   <!-- Optional JavaScript - Offline Link  -->
   <script src="js/jquery-3.2.1.slim.min.js"></script>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/main.js"></script>
   <!-- Optional JavaScript - CDN Links
    - jQuery first, then Popper.js, then Bootstrap JS 
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   -->
</body>
</html>