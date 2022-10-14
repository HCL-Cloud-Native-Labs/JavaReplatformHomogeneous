
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
<link href="../css/login.css" rel="stylesheet" media="screen">
</head>
<body>
	<jsp:include page="header.html" />
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
					<li class="active"><s:url id="logout" action="logout" /> <s:a
							href="%{logout}">Logout</s:a></li>

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

						<div class="alert alert-success">
							Your Unique Employee Bank ID is: <b><s:property value="user1" />
							</b>
						</div>
					</div>
					<div class="span1"></div>
				</div>
				<h4>
					Welcome
					<s:property value="user0" />
					...!
				</h4>

				<div class="container" style="margin-top: 50px;">

					<div class="span1"></div>
					<div class="span10">
						<div class="well clearfix ">

							<h4 class="text-center" style="color: red;">List of
								Applicants for applying Loan</h4>
							<br>
							<!-- <form method="post" action="push2mysql" class="span2" > -->
							<form class="span2" action="push2mysql" method="post">
								<table class="table table-striped table-bordered"
									style="width: 100%" align="left">
									<tr>
										<th style="text-align: center;">Applicant Name</th>
										<th style="text-align: center;">Loan Type</th>
										<th style="text-align: center;">Application Date</th>
										<th style="text-align: center;">Monthly Salary</th>
										<th style="text-align: center;">Loan Amount</th>
										<th style="text-align: center;">Eligible for Loan?*</th>
										<th style="text-align: center;">Approved?</th>
									</tr>
									<s:iterator value="loanList" var="type">
										<tr>
											<td><s:property value="name" /></td>
											<td><s:property value="loanType" /></td>
											<td><s:property value="date" /></td>
											<td><s:property value="monthlySalary" /></td>
											<td><s:property value="loanAmount" /></td>
											<td><s:property value="isEligible" /></td>
											<td><input type="checkbox" name="checkedname" value="<s:property value="name"/>" /></td>
											<%-- <td><input type="checkbox" name="checkedname" value="<s:property value="name"/> "/></td> --%>
											
										</tr>
									</s:iterator>
								</table>
								<s:submit class="btn btn-primary" value="Submit for Back office process" name="submit"> </s:submit>
							</form>

					
						</div>


						<%-- <div class="row">
							<form class="span2"></form>
							<form class="span2" action="push2mysql" method="post">
								<div class="control-group">
									<button id="submit" name="submit" class="btn btn-primary">
										<span><strong>Submit for Back office process</strong></span>
									</button>
								</div>
							</form>
							<form class="span2" action="push2mysql" method="post">
								<div class="control-group">
									<button id="submit" name="submit" class="btn btn-primary">
										<span><strong>Push to MySql</strong></span>
									</button>
								</div>
							</form>
						</div> --%>
						<br> <br> <br> <br> <br> <br> <br>
						<br> <br> <br>
						<div class="span2"></div>
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