<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="ISO-8859-1">
<title>Zemoga portfolio</title>
</head>
<body>
	<h1 style="color: olivedrab">Zemoga portfolio</h1>
	<div style="width: 100%; display: table;">
	    <div style="display: table-row">
	    <div style="display: table-cell">
	    	<form id=zp_up name=zp_up method=get action="user-profile">
				twitterUserName : <input type="text" value="twitter user name" name="twitterUserName"><br>
			<input type=submit value="See the user's portfolio">
			</form>
		</div>
			<div style="display: table-cell">
			</div>
		</div>
	</div>
</body>
</html>