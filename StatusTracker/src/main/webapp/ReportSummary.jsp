<!DOCTYPE html>
<html lang="en">
<head>
  <title>Status Tracking System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap-datepicker3.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/1.0.7/css/responsive.dataTables.min.css">		 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js"></script>
   <script src="js/bootstrap-datepicker.min.js"></script>

	<script>
$(document).ready(function() {
    $('#tickets').DataTable( {
	
	responsive: {
           
        "columns": [
			{ "data": "Resource",       className: "all" },
            { "data": "Ticket ID",       className: "all" },
            { "data": "Description",     className: "min-phone-l" },
            { "data": "Application",     className: "min-tablet" },
            { "data": "Priority",        className: "all" },
            { "data": "Activity",        className: "desktop" },
			{ "data": "Current Status",  className: "desktop" },
			{ "data": "Tester",       className: "all" },
			{ "data": "Comments",        className: "desktop" },
			{ "data": "Start Date",          className: "all" }	,	
			{ "data": "End Date",      className: "none" },
			{ "data": "Remedy",      className: "none" },
			{ "data": "Documentation",      className: "none" }
            	
        ],
		 "details": {
                type: 'column',
                target: -1
            }
        },
		"paging":   false,
  "info":     false,
  "autoWidth": false,
  "bFilter": false,
        "columnDefs": [ {
            className: 'control',
            orderable: false,
            targets:   -1,
			
        } ]
		
	
  
    } );
} );
</script>
  
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
    

background: #2C3E50;
background: -webkit-linear-gradient(to left, #2C3E50 , #FD746C);
background: linear-gradient(to left, #2C3E50 , #FD746C);   
}
.rowAlign {
    margin-right: 0px !important;
    margin-left: 0px !important;
	width: 102.7%;
}
 table.dataTable.nowrap td {
    white-space: normal !important; 
}
  .table.dataTable tbody tr td {
    word-wrap: break-word;
    word-break: break-all;
}
  .wraptext {
		white-space: pre-wrap; /* css-3 */
		white-space: -moz-pre-wrap; /* Mozilla, since 1999 */
		white-space: -pre-wrap; /* Opera 4-6 */
		white-space: -o-pre-wrap; /* Opera 7 */
		word-wrap: break-word; /* Internet Explorer 5.5+ */
	}
	.labelLeftAlign
	{
	    left: 6%;
        position: relative;
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
         
      </h3>
   </div>
 <div class = "panel-body">
 <form>
 <div class="row">	
    <div class="form-group col-lg-3">
      <label for="resource_id" class="control-label">Resource:</label>
		<select class="form-control" id="resource_id">
			<option value="AL">Prabu</option>
			<option value="AL">Sathish</option>
			<option value="AL">Dinesh</option>
			<option value="AL">Kavi</option>
			<option value="AL">Navin</option>
		</select> </div>
	<div class="form-group col-lg-3">	
		<label for="application" class="control-label">Application:</label>	
		<select class="form-control" id="application">
			<option value="AL">TMI</option>
			<option value="AL">EFIC</option>
			<option value="AL">WSA</option>
			<option value="AL">Infocenter</option>
			<option value="AL">Common Goals</option>
		</select>
	</div>
	<div class="form-group col-lg-3">
		<label for="state_id" class="control-label">Activity:</label>
		<select class="form-control" id="state_id">
			<option value="AL">Analysis</option>
			<option value="AL">Build</option>
			<option value="AL">Test</option>
		</select>	
	</div>
	<div class="form-group col-lg-3">
      <label for="status" class="control-label">Current Status:</label>
		<select class="form-control" id="status">
			<option value="AL">Completed</option>
			<option value="AL">In Progress</option>
			<option value="AL">Closed</option>
		</select>	
	</div>
		
    </div>
	
	<div class="row">
	<div  id="FromDateContainer" class="date form-group col-lg-3">	 
			<label for="startDate" class="control-label">Start Date:</label>
		<div class="input-group">		
           <input type="text" class="form-control" id="startDate"><span class="input-group-addon">
			<i class="glyphicon glyphicon-th"></i></span>					
        </div>
	</div>
	<div  id="ToDateContainer" class="date form-group col-lg-3">	
		<label for="endDate" class="control-label">End Date:</label>
		<div class="input-group date">		   
            <input type="text" class="form-control" id="endDate"><span class="input-group-addon" >
			<i class="glyphicon glyphicon-th"></i></span>					
        </div>	
	</div>
	<div class="form-group col-lg-6">
	<br>
		<button type="submit" class="btn btn-primary">Submit</button>
		&nbsp;&nbsp;&nbsp;
		<button type="clear" class="btn btn-warning">Clear</button>	
    </div>	

    </div>
	</div>
	</div>
	</div>
	</div>
	<div class="row rowAlign">
 <div class = "panel panel-danger">
 <div class = "panel-heading">
      <h3 class = "panel-title text-center">
        <b> Report Summary </b>
      </h3>
   </div>
 <div class = "panel-body">
 <table id="tickets" class="display responsive  nowrap" cellspacing="0" width="100%">
        <thead>
            <tr>
			    <th>Resource</th>
                <th>Ticket ID</th>
                <th>Description</th>
                <th>Application</th>
                <th>Priority</th>
                <th>Activity</th>
                <th>Current Status</th>
				<th>Tester</th>
                <th>Comments</th>				
                <th>Start Date</th>  
				<th>End Date</th>
				<th>Remedy</th>	
				<th>Documentation</th>	
				<th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
				<td>Ahamed</td>
                <td>INC000010551951</td>
                <td class="wraptext">TMI Edit Data Component Charts are mislined</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">3</td>
                <td>UAT</td>
                <td>Approved</td>
				<td>Dinesh</td>
                <td>UAT Approved</td>
				<td >2016-10-05</td>
                <td >2016-10-05</td>
				<td>Updated</td>
				<td>placed</td>               
				<th></th>
            </tr>
            <tr>
                <td>Ahamed</td>
                <td>INC000010551951</td>
                <td class="wraptext">TMI Edit Data Component Charts are mislined</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">3</td>
                <td>UAT</td>
                <td>Approved</td>
				<td>Dinesh</td>
                <td>UAT Approved</td>
				<td >2016-10-05</td>
                <td >2016-10-05</td>
				<td>Updated</td>
				<td>placed</td>               
				<th></th>
            </tr>
			  <tr>
                <td>Ahamed</td>
                <td>INC000010551951</td>
                <td class="wraptext">TMI Edit Data Component Charts are mislined</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">3</td>
                <td>UAT</td>
                <td>Approved</td>
				<td>Dinesh</td>
                <td>UAT Approved</td>
				<td >2016-10-05</td>
                <td >2016-10-05</td>
				<td>Updated</td>
				<td>placed</td>               
				<th></th>
            </tr>
			</table>
 </div>
 </div>
 </div>
  </form>
  </div>
  </div>


</div>

  
   <script>
   
   $('#from_date input').datepicker({
    autoclose: true
});


   $('#to_date input').datepicker({
    autoclose: true
});

    $('#FromDateContainer').datepicker();
	$('#ToDateContainer').datepicker();
   </script>
</body>
</html>

