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
      <h3 class = "panel-title text-center">
        Update Ticket Status
      </h3>
   </div>
 <div class = "panel-body">
  <form>
  <div class="form-group col-lg-6 col-md-12">
      <label for="ticket_id">Ticket Id:</label>
      <input type="input" class="form-control" id="ticket_id" required> 
    </div>
    <div class="form-group col-lg-6 col-md-12">
      <label for="desc">Description:</label>	 
       <textarea class="form-control" id="desc"  required></textarea>
    </div>
	<div class="form-group col-lg-6 col-md-12">
		<label for="application" class="control-label">Applicaton:</label>
		<select class="form-control" id="application">
			<option value="select">Select</option>
			<option value="CTS">CTS</option>
			<option value="DDS">DDS</option>
			<option value="DMF">DMF</option>
			<option value="EFIC">EFIC</option>
			<option value="FGW">FGW</option>
			<option value="TMI">TMI</option>
		</select>	
	</div>
	
	<div class="form-group col-lg-6 col-md-12">
		<label for="priority" class="control-label">Priority:</label>
		<select class="form-control" id="priority">
			<option value="select">Select</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select>	
	</div>
	<div class="form-group col-lg-6 col-md-12">
		<label for="activity" class="control-label">Activity:</label>
		<select class="form-control" id="activity">
			<option value="select">Select</option>
			<option value="Analysis">Analysis</option>
			<option value="Build">Build</option>
			<option value="Deployment">Deployment</option>
			<option value="Design">Design</option>
			<option value="Documentation">Documentation</option>
			<option value="Estimation">Estimation</option>
		</select>	
	</div>
	
	<div class="form-group col-lg-6 col-md-12">
		<label for="currentStatus" class="control-label">Current Status:</label>
		<select class="form-control" id="currentStatus">
			<option value="select">Select</option>
			<option value="In Progress">In Progress</option>
			<option value="On Hold">On Hold</option>
			<option value="Approved">Approved</option>
			<option value="Completed">Completed</option>
			<option value="Closed">Closed</option>
			<option value="Not Started">Not Started</option>
		</select>	
	</div>
	
	<div class="form-group col-lg-6 col-md-12">
		<label for="tester" class="control-label">Tester:</label>
		<select class="form-control" id="tester">
			<option value="select">Select</option>
			<option value="Vivek">Vivek</option>
			<option value="Dinesh">Dinesh</option>
		</select>	
	</div>
	 <div class="form-group col-lg-6 col-md-12">
      <label for="comments">Comments:</label>	 
       <textarea class="form-control" id="comments"  required></textarea>
    </div>    
    
     <div class="form-group col-lg-6 col-md-12">
	
       <label for="radio"><b>Work On Today:</b></label>
	  <label class="radio-inline">
      <input type="radio" name="worktoday">Yes
    </label>
    <label class="radio-inline">
      <input type="radio" name="worktoday">No
    </label>
    
    </div>
	
	<div class="align:center; col-lg-6 col-md-12">
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

