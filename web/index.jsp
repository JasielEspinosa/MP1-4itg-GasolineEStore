<!doctype html>
<html lang="en">
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
<title>MP1 - Gasoline eStore</title>
</head>
<body>
   <!-- Main Container -->
   <div class="container-fluid" id="page">
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
      <div class="col-sm-4 container align-items-center flex-column">
         <!-- d-flex -->
         <div class="row">
            <div class="form-content col-md-12">
               <!-- Form -->
               <form action='gasulgaming.proc' method=post>
                  <div>
                     <input class="col-md-12 form-content__input-field" type="text" name="firstName" id="firstName" required="required"
                        placeholder="Customer First Name">
                  </div>
                  <div>
                     <input class="col-md-12 form-content__input-field" type="text" name="lastName" id="lastName" required="required"
                        placeholder="Customer Last Name">
                  </div>
                  <div class="form-content__dropdown">
                     <label>Enter Gasoline Type </label> <select name="gasolineType" required="required">
                        <!--  <option selected="selected" disabled="disabled">Select Gasul Type</option> -->
                        <option value="Unleaded">Unleaded</option>
                        <option value="Diesel">Diesel</option>
                        <option value="Premium">Premium</option>
                     </select>
                  </div>
                  <div>
                     <input class="col-md-12 form-content__input-field" type="number" name="liters" id="liters" step=".001" min="1"
                        required="required" placeholder="Enter Number Of Liters">
                  </div>
                  <div class="form-content__radiogroup">
                     <label>Payment CC Type</label>
                     <div>
                        <label><input type="radio" name="paymentType" value="VISA" required="required"> VISA</label>
                     </div>
                     <div>
                        <label><input type="radio" name="paymentType" value="MASTERCARD"> MASTERCARD</label>
                     </div>
                     <div>
                        <label><input type="radio" name="paymentType" value="JCB"> JCB</label>
                     </div>
                     <div>
                        <label><input type="radio" name="paymentType" value="AMEX"> AMEX</label>
                     </div>
                     <div>
                        <label><input type="radio" name="paymentType" value="DINERS"> DINERS</label>
                     </div>
                     <div>
                        <label><input type="radio" name="paymentType" value="GCASH"> GCASH</label>
                     </div>
                     <div>
                        <label><input type="radio" name="paymentType" value="PAY MAYA"> PAY MAYA</label>
                     </div>
                  </div>
                  <div>
                     <input class="col-md-12 form-content__input-field" type="number" maxlength="16" name="cardNumber" id="cardNumber"
                        min="1000000000000000" max="9999999999999999" required="required" placeholder="Enter Credit Card Number">
                  </div>
                  <!-- Submit Button -->
                  <div>
                     <button class="btn btn-primary btn-block form-content__submitbutton" type="submit" id='submit'>
                        <i class="fas fa-paper-plane fa-sm"></i> Submit
                     </button>
                     <button class="btn btn-success btn-block form-content__resetbutton" type='reset'>
                        <i class="fas fa-redo-alt fa-sm"></i> Reset
                     </button>
                  </div>
                  <!-- End of Submit Button -->
               </form>
               <!-- End of Form -->
            </div>
         </div>
      </div>
      <!-- End of Form Container -->
   </div>
   <!-- End of Main Container -->
   <div id="loading"></div>
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
