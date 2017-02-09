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
    background-color: none !important;
    width: 100%;
    height: 100%;
    background-size: cover;
    overflow: hidden;
}
body  {
  

background: #09b2e5; /* fallback for old browsers */
background: -webkit-linear-gradient(to left, #09b2e5 , #025c70); /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to left, #09b2e5 , #025c70); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        
}
  </style>
  
</head>

<body>

<!--
<nav id="myNavbar" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
       
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <a class="navbar-brand" href="#">Status Tracking System</a>
            </div>
           
            <div class="collapse navbar-collapse" id="navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="home.html">Home</a></li>
                    <li><a href="changePassword.html">Change Password</a></li>
					<li><a href="#">Upload File</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Tickets <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="test1.html">Inbox</a></li>
                            <li><a href="#">Drafts</a></li>
                            <li><a href="#">Sent Items</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Trash</a></li>
                        </ul>
                    </li>
                </ul>
			 
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Resource <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Settings</a></li>
                        </ul>
                    </li>
                </ul>
				 <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Reports <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Settings</a></li>
                        </ul>
                    </li>
                </ul>
				
			
        </div>
		</div>
    </nav>
	
	<br>
	<br>
	<br> 
	-->
	
<div class="container">

<div >
  <div class="container1">
 <h1>Welcome to Status Tracking System</h1>
 </div>

<br><br><br>
<div class="container container1">
<div class="row">
 <div class = "panel panel-warning">
 <div class = "panel-heading">
      <h3 class = "panel-title">
         Login Here
      </h3>
   </div>
 <div class = "panel-body">
  <form action="assignticket.htm">
    <div class="form-group has-feedback">
      <label for="emp_id">Employee ID:</label>
	  <i class="glyphicon glyphicon-user form-control-feedback"></i>
      <input type="emp_id" class="form-control" id="input" placeholder="Enter Your Employee ID" required>
	 
    </div>
    <div class="form-group has-feedback ">
      <label for="pwd">Password:</label>
	  <i class="glyphicon glyphicon-warning-sign form-control-feedback"></i>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" required>
    </div>
   <div >
  <button type="submit" class="btn btn-primary">Submit</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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

