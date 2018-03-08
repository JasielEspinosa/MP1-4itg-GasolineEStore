<!DOCTYPE html">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Website Logo -->
<link rel="icon" href="images/mp1logotransparent.png">
<!-- CSS - Offline Links  -->
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
            <h2>Gasoline eStore</h2>
         </div>
         <div class="col-sm-2"></div>
      </div>
      <!-- End of Header-->
      <!-- Form Container-->
      <div class="col-sm-5 container align-items-center flex-column">
         <!-- d-flex -->
         <div class="row">
            <div class="form-content-output col-md-12">
               <div>
                  Customer Name: <b class="form-content_labelcolor"> ${gasul.firstName} ${gasul.lastName} </b>
               </div>
               <div>
                  Fuel Type: <b class="form-content_labelcolor"> ${gasul.gasul} </b>
               </div>
               <%--    
          <div>
            <b>${gasul.liters}</b>
          </div> 
          --%>
               <div>
                  Price per Liter Amount: <b class="form-content_labelcolor"> ${gasLiterPriceTrim} </b>
               </div>
               <div>
                  Purchase Amount: <b class="form-content_labelcolor"> ${purchaseAmountTrim} </b>
               </div>
               <div>
                  VAT: <b class="form-content_labelcolor"> ${vatTrim} </b>
               </div>
               <div class="form-content__lowerlabelsspacing">
                  TOTAL AMOUNT: <b class="form-content_labelcolor"> ${totalAmountTrim} </b>
               </div>
               <div class="form-content__lowerlabelsspacing form-content__description">
                  Binubuo ito ng <b class="form-content_labelcolor"> ${tagalogGLP}ng price </b> kada litro, <br /> <b
                     class="form-content_labelcolor"> ${tagalogPA} </b> na purchased amount, <br /> at <b class="form-content_labelcolor">
                     ${tagalogVAT} </b> na value-added tax. <br /> Kabuuang <b class="form-content_labelcolor"> ${tagalogTA} </b>
               </div>
               <div class="form-content__lowerlabelsspacing">
                  Gamit ang <b class="form-content_labelcolor"> ${gasul.paymentType} Card </b>
               </div>
               <div class="form-content__lowerlabelsspacing">
                  Credit card number: <b class="form-content_labelcolor"> ${cardmo.cardNumber} </b>
               </div>
               <!-- Back Button -->
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