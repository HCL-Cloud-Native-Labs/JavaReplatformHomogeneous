<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet"
	media="screen">
<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet"
	media="screen">


<!--Modifications to Some Class-->
<!--Insert After Main CSS-->
<link href="../css/basic.css" rel="stylesheet" media="screen">
<link rel="shortcut icon" href="../favicon.ico">
</head>
<body>
	<jsp:include page="../header.html" />
	<section>
		<div class="container">

			<div class="row-fluid">

				<s:if test="#session.user != 'admin'">
					<%
						response.sendRedirect("login.jsp");
					%>
				</s:if>
				<s:set var="user" value="#session.user.toString()" />
				<s:set var="user0" value="#session.user0.toString()" />
				<s:set var="user1" value="#session.user1.toString()" />
				<s:set var="user2" value="#session.user2.toString()" />

				<ul class="nav nav-pills pull-right">
					<li class="active"><s:url id="logout" action="logout" />
						<s:a href="%{logout}">Logout</s:a></li>

				</ul>
				<ul class="nav nav-pills pull-right">
					<li class="active"><a href="welcome.jsp">Home</a></li>

				</ul>

				<div class="container" style="margin-top: 50px;">
					<div class="span1"></div>
					<div class="span10">



						<div class="alert alert-error">
							<b>Do not Click on any External Links Or your session will be
								expired </b>
						</div>
						<div class="alert alert-info">
							<b>After adding general info of Employee, Admin need to add
								new Employee Username Password </b>
						</div>

						<div class="alert alert-success">
							Your Unique Employee Bank ID is: <b><s:property value="user1" />
							</b>
						</div>
					</div>
					<div class="span1"></div>
				</div>
				<h4>
					Welcome,
					<s:property value="user0" />
					...!
				</h4>

				<div class="container" style="margin-top: 50px;">
					<div class="span1"></div>
					<div class="span10">
						<div class="well">


							<form class="form-horizontal" action="addEmp" method="post">
								<fieldset>

									<!-- Form Name -->
									<h2>Employee Add Details....</h2>
									<h5>*All Fields are Mandatory</h5>
									<p>&nbsp;</p>
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Bank_Employee_ID</label>
										<div class="controls">
											<s:textfield  name="bank_emp_id" id="bank_emp_id"
												 placeholder="Unique Bank Number"
												class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Branch Name</label>
										<div class="controls">
											<s:textfield  name="branch_name" id="branch_name"
												type="text" placeholder="" class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Role Name</label>
										<div class="controls">
											<s:textfield  name="role_name" id="role_name"
												type="text" placeholder="Employee Role" class="input-xlarge"></s:textfield>
											<p class="help-block"></p> 
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">First Name</label>
										<div class="controls">
											<s:textfield  name="first_name" id="first_name"
												type="text" placeholder="" class="input-xlarge"> </s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Middle Name</label>
										<div class="controls">
											<s:textfield  name="middle_name" id="middle_name"
												type="text" placeholder="" class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Last Name</label>
										<div class="controls">
											<s:textfield name="last_name" id="last_name"
												type="text" placeholder="" class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- Multiple Radios -->
									<div class="control-group">
										<label class="control-label">Gender</label>
										<div class="controls">
										<!--  
											<label class="radio"> <input type="radio"
												name="gender" id="gender" value="Male" checked="checked">
												Male
											</label> <label class="radio"> <input type="radio"
												name="gender" id="gender" value="Female"> Female
											</label>
											-->
											<s:radio name="gender" id="gender" list="{'Male','Female'}" />
										</div>
									</div>
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Birth Date</label>
										<div class="controls">
											<s:textfield name="dob_detail" id="dob_detail"
												placeholder="Date Of Birth" class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Phone No.</label>
										<div class="controls">
											<s:textfield name="phone_land_no" id="phone_land_no"
												type="text" placeholder="Land Line India"
												class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Mobile No.</label>
										<div class="controls">
											<s:textfield name="phone_mobile_no"
												id="phone_mobile_no" type="text" placeholder="Mobile India"
												class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>


									<!-- Text input-->
									<div class="control-group">
										<label class="control-label">Email</label>
										<div class="controls">
											<s:textfield name="email_detail" id="email_detail"
												type="text" placeholder="" class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>

									<!-- address-line1 input-->
									<div class="control-group">
										<label class="control-label">Address Line 1</label>
										<div class="controls">
											<s:textfield name="add_detail" id="add_detail"
												type="text" placeholder="address line 1"
												class="input-xlarge"></s:textfield>
											<p class="help-block">Street address, P.O. box, company
												name, c/o</p>
										</div>
									</div>
									<!-- city input-->
									<div class="control-group">
										<label class="control-label">City / Town</label>
										<div class="controls">
											<s:textfield  name="city_detail" id="city_detail"
												type="text" placeholder="city" class="input-xlarge">
											<p class="help-block"></p></s:textfield>
										</div>
									</div>
									<!-- region input-->
									<div class="control-group">
										<label class="control-label">State / Province / Region</label>
										<div class="controls">
											<s:textfield  name="state_detail" id="state_detail"
												type="text" placeholder="state / province / region"
												class="input-xlarge"></s:textfield>
											<p class="help-block"></p>
										</div>
									</div>
									<!-- Button -->
									<div class="control-group">
										<label class="control-label"></label>
										<div class="controls">
											<!--     <button id="singlebutton" name="singlebutton" class="btn btn-info">Submit</button> -->
											<s:submit type="button" cssClass="btn" id="singlebutton"
												name="singlebutton" class="btn btn-info">Submit</s:submit>
										</div>
									</div>

								</fieldset>
							</form>

						</div>

					</div>
					<div class="span1"></div>
				</div>





			</div>



			<jsp:include page="../footer.html" />
		</div>
	</section>









	<script src="../bootstrap/js/jquery.js"></script>
	<script src="../bootstrap/js/bootstrap.js"></script>

</body>
</html>