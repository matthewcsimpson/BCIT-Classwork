<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8"> <meta name="author" content="Matthew Simpson / A00820997"> <meta name="description" content="COMP 3656 - Lab 05"> 
		<title>
			COMP 3656 - Assignment 
		</title>
		<style>
			
				body {
					font-family: "Courier New", Courier, monospace;
					font-weight: bold;
					background-color: #fbeec1;
				}	
				
				#centering {
					margin: 20px 20px 0px 20px;
					width: 95%;					
				}
				
				#heading {
					width: 100%;
					height: 50px;
					margin: auto auto 2% auto;
					padding: 1%;
					font-weight: bold;
					color: white;
					background-color: #659dbd;
					border: 1px solid black;
					
				}
				
				#mainContainer {
					width: 100%;
					height: 100%;
					padding: 0px;
					background-color: #659dbd;
					border: 1px solid black;
			
				}
				
				#mainSection {
					width: 66%;
					height: 100%;
					margin: auto;
					padding: 1%;
					float: left;
					background-color: #659dbd;
					border: 1px solid black;
					color: white;
			
				}
				
				#mainSection table {
					width: 98%;
				}
				
				#mainSection table tr {
			
				}
				
				#mainSection table th {
					font-weight: bolder;
					border: 1px solid black;
				}
				
				#mainSection table td {
					border: 1px solid black;
					text-align: center;
				}
			
				
				#sidebar {
					width: 28%;
					height: 100%;
					margin-left: 70%;
					margin-right: 0%;
					padding: 1%;
					background-color: #659dbd;
					border: 1px solid black;
					color: white;
					
				}
				
				.inputBox {
					border-top: 1px solid black;
				}
				
				
				.clear:after {
				clear: both;
				}
		</style>
	</head>
	<body>
		<div id="centering">
			<div id="heading">
				<h1>
					${initParam['headerText']} 
				</h1>
			</div>
<!-- heading -->
			<div id="mainSection">
				<h2>
					${initParam['employeeListHeader']} 
				</h2>
				<table>
					<tr>
						<th>
							Employee ID: 
						</th>
						<th>
							First Name: 
						</th>
						<th>
							Last Name: 
						</th>
						<th>
							Date of Birth 
						</th>
					</tr>
					${userList} ${userList2} ${userList3} ${searchResult} 
				</table>
			</div>
<!-- mainSection -->
			<div id="sidebar">
				<div class="inputBox">
					<h3>
						Add Employee 
					</h3>
					<form name="addEmployee" id="addEmployee" action="" method="post">
						<label for="empID-Add">
							Emp. ID: 
						</label>
						<br> <input type="text" name="empID-Add"> <br> 
						<labelfor "firstname">
							First Name: 
							</label>
							<br> <input type="text" name="firstName"><br> 
							<label for="lastName">
								Last Name: 
							</label>
							<br> <input type="text" name="lastName"><br> 
							<label for="dateOfBirth">
								Date of Birth: 
							</label>
							<br> <input type="text" name="dateOfBirth"><br> 
							<form type="hidden" id="formID" name="formID" value="add">
								<input type="submit"> 
					</div>
					<div class="inputBox">
						<h3>
							Find Employee by ID 
						</h3>
						<form name="findEmployee" id="findEmployee" action="" method="post">
							<label for="userName">
								Emp. ID: 
							</label>
							<br> <input type="text" name="userName"> <br> <input type="submit"> 
					</div>
					
					
					<div class="inputBox">
						<h3>
							Delete Employee 
						</h3>
						<form name="deleteEmployee" id="addEmployee" action="" method="post">
							<label for="empID-Delete">
								Emp. ID: 
							</label>
							<br> <input type="text" name="empID-Delete"> <br> 
							<form type="hidden" id="formID" name="formID" value="add">
								<input type="submit"> 
					</div>
				</div>
<!-- sidebar -->
			</div>
<!-- centering -->
		</body>
	</html>
