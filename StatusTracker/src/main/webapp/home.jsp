<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/1.0.7/css/responsive.dataTables.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js"></script>

	<script>
$(document).ready(function() {
    $('#tickets').DataTable( {
	
	responsive: {
           
        "columns": [
            { "data": "Ticket ID",       className: "all" },
            { "data": "Description",     className: "min-phone-l" },
            { "data": "Application",     className: "min-tablet" },
            { "data": "Priority",        className: "all" },
            { "data": "Activity",        className: "desktop" },
			{ "data": "Current Status",  className: "desktop" },
			{ "data": "Comments",        className: "desktop" },
			{ "data": "Update",          className: "all" }	,	
			{ "data": "Start Date",      className: "none" }
            	
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
$(document).ready(function() {
    $('#doc_table').DataTable( {
	
	responsive: {
           
        "columns": [
            { "data": "Ticket ID",       className: "all" },
            { "data": "Description",     className: "min-phone" },
            { "data": "Application",     className: "min-tablet" },
            { "data": "Status",          className: "all" },
            { "data": "Comments",        className: "desktop" },
			{ "data": "Remedy",          className: "desktop" },
			{ "data": "Documentation",   className: "desktop" },
            { "data": "Update",          className: "all" }			
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
            targets:   -1
        } ]
		
	
  
    } );
} );
</script>
  <style>
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
.rowAlign {
    margin-right: 0px !important;
    margin-left: 0px !important;
	width: 80%;
    position: relative;
    left: 10%;
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
	<!--
	Non-Admin Navigation Bar:
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
					<li><a href="#">Add Tickets</a></li>
					<li><a href="#">My Closed Tickets</a></li>             
                </ul>			
        </div>
		</div>
    </nav>
	
	-->
	<br>
	<br>
	<br>
<div class="row rowAlign">
 <div class = "panel panel-danger">
 <div class = "panel-heading">
      <h3 class = "panel-title text-center">
        <b> Tickets in progress </b>
      </h3>
   </div>
 <div class = "panel-body">
 <table id="tickets" class="display responsive  nowrap" cellspacing="0" width="80%">
        <thead>
            <tr>
                <th>Ticket ID</th>
                <th>Description</th>
                <th>Application</th>
                <th>Priority</th>
                <th>Activity</th>
                <th>Current Status</th>
                <th>Comments</th>
				<th>Update</th>
                <th >Start Date</th>                
				<th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>INC000010551951</td>
                <td class="wraptext">TMI Edit Data Component Charts are mislined</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">3</td>
                <td>UAT</td>
                <td>Approved</td>
                <td>UAT Approved</td>
				<td><a href="UpdateTciket.html">Update</a></td>
                <td >2016-10-05</td>
                
				<th></th>
            </tr>
            <tr>
                <td>INC000010561889</td>
                <td class="wraptext">1. ELPS cleanup2.Migration from Z1PC to Z1P13.Removal of tables</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">2</td>
                <td>Build</td>
                <td>Completed</td>
                <td>Build completed for ELPS Cleanup</td>
				<td><a href="UpdateTciket.html">Update</a></td>
                <td >2016-10-05</td>
               
				<th></th>
            </tr>
			  <tr>
                <td>INC000010699517</td>
                <td>WSA changes</td>
                <td>WORLD SALES ANALYSIS (WSA)</td>
                <td align="right">1</td>
                <td>Analysis</td>
                <td>In Progress</td>
                <td>AnalysisInProgress</td>
				<td><a href="UpdateTciket.html">Update</a></td>
                <td >2016-10-06</td>
                
				<th></th>
            </tr>
			</table>
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
        <b> Documentation</b>
      </h3>
   </div>
 <div class = "panel-body">
 <table id="doc_table" class="display responsive  nowrap" cellspacing="0" width="80%">
        <thead>
            <tr>
                <th >Ticket ID</th>
                <th >Description</th>
                <th >Application</th>
                <th >Status</th>
                <th >Comments</th>
                <th >Remedy</th>
                <th >Documentation</th>
				<th>Update</th>
				<th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>INC000010551951</td>
                <td class="wraptext">TMI Edit Data Component Charts are mislined</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">3</td>
                <td>UAT</td>
                <td>Approved</td>
                <td>UAT Approved</td>
                <td><a href="">Update</a></td>
				<th></th>
            </tr>
            <tr>
                <td>INC000010561889</td>
                <td class="wraptext">1. ELPS cleanup2.Migration from Z1PC to Z1P13.Removal of tables</td>
                <td>TECHNICAL MARKETING INFORMATION (TMI)</td>
                <td align="right">2</td>
                <td>Build</td>
                <td>Completed</td>
                <td>Build completed for ELPS Cleanup</td>
               <td><a href="">Update</a></td>
				<th></th>
            </tr>
			  <tr>
                <td>INC000010699517</td>
                <td>WSA changes</td>
                <td>WORLD SALES ANALYSIS (WSA)</td>
                <td align="right">1</td>
                <td>Analysis</td>
                <td>In Progress</td>
                <td>AnalysisInProgress</td>
               <td><a href="">Update</a></td>
				<th></th>
            </tr>
			</table>
 </div>
 </div>
 </div>
</div>
</div>
</div>

</body>
</html>

