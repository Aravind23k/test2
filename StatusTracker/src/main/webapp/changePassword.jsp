<!DOCTYPE html>
<html lang="en">
<head>
  <title>Status Tracking System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <style>
.container1{
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: transparent !important;
}
	.visible-lg {
  @media (max-width: @screen-phone-max) {
  .responsive-invisibility();
  }
  &.visible-xs {
    @media (max-width: @screen-phone-max) {
      .responsive-visibility();
    }    
  }
  @media (min-width: @screen-tablet) and (max-width: @screen-tablet-max) {
    .responsive-invisibility();
  }
  &.visible-sm {
    @media (min-width: @screen-tablet) and (max-width: @screen-tablet-max) {
      .responsive-visibility();
    }    
  }
  @media (min-width: @screen-desktop) and (max-width: @screen-desktop-max) {
    .responsive-invisibility();
  }
  &.visible-md {
    @media (min-width: @screen-desktop) and (max-width: @screen-desktop-max) {
      .responsive-visibility();
    }    
  }
  @media (min-width: @screen-large-desktop) {
    .responsive-visibility();
  }
}
.jumbotron
{
    position: relative;
    background-color: #337ab7;
    width: 100%;
    height: 100%;
    background-size: cover;
    overflow: hidden;
}
.jumbotron {
    padding-top: 48px !important;
    padding-bottom: 28px !important;
}
body  {
    

background: #2C3E50; /* fallback for old browsers */
background: -webkit-linear-gradient(to left, #2C3E50 , #FD746C); /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to left, #2C3E50 , #FD746C); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        
    
}

  </style>
  
</head>

<body>


<nav id="myNavbar" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" >Status Tracking System</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="home.html">Home</a></li>
                    <li><a href="changePassword.html">Change Password</a></li>
					<li><a href="uploadfile.html">Upload File</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Tickets <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="AddTicket.html">Add Tickets</a></li>
                            <li><a href="DeleteTicket.html">Delete Tickets</a></li>
                            <li><a href="MyClosedTicket.html">My Closed Tcikets</a></li>                           
                            <li><a href="AssignTicket.html">Assign Tickets</a></li>
							 <li><a href="Re-assign.html">Re-assign Tickets</a></li>
                        </ul>
                    </li>
                </ul>
			 
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Resource <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="AddResource.html">Add Resource</a></li>
                            <li><a href="ModifyResource.html">Modify Resource</a></li>                           
                        </ul>
                    </li>
                </ul>
				 <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Report<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="DailyStatusRpt.html">Daily Status Report</a></li>
                            <li><a href="ReportSummary.html">Report Summary</a></li>                          
                            <li><a href="TicketStatus.html">Ticket Status</a></li>
							<li><a href="TicketOfTheDay.html">Ticket Of The Day</a></li>
                        </ul>
                    </li>
                </ul>
				<!-- /.navbar-collapse -->
			
        </div>
		</div>
    </nav>
	
	<br>
	<br>
	<br>
<div class="container">

	<div >
<br><br><br>
<div class="container container1">
<div class="row">
 <div class = "panel panel-warning">
 <div class = "panel-heading">
      <h3 class = "panel-title">
         Set Your Password
      </h3>
   </div>
 <div class = "panel-body">
  <form>
  <div class="form-group col-lg-12 col-sm-12">
      <label for="password">Old Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter your old password" required> 
    </div>
    <div class="form-group col-lg-12 col-sm-12">
      <label for="new_pwd">New Password:</label>	 
      <input type="password" class="form-control" id="new_pwd" placeholder="Enter your new password" required>
    </div>
	<div class="form-group col-lg-12 col-sm-12">	  
		<label for="conf_pwd">Confirm Password:</label>	  
      <input type="password" class="form-control" id="conf_pwd" placeholder="Enter your confirm password" required>
    </div>
	<div class="align:center;">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-primary">Submit</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="clear" class="btn btn-warning">Clear</button>
	</div>
  </form>
  </div>
  </div>
  </div>
</div>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
   
</body>
</html>

