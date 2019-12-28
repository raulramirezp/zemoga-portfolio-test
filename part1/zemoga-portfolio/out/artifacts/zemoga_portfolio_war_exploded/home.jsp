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
	        <div style="display: block"; max-width:180px; max-height:180px; width: auto; height: auto;display: table-cell;>
	        	<img  width="500" height="600"  id="image-1" alt="" src="${profile.imageURl}"/>
	        </div>
	        <div style="display: table-cell;"> 
		        <div>
		        	<h2 style="color: olive">
						${profile.twitterUserName}!
					</h2>
				</div>	
			</div>
	    </div>
	    <div style="display: table-row">
				<h2 style="color: olive"> ${profile.twitterUserName} timeline</h2>
				<tr>
					<td>
						<h4>${profile.twitterUserName}</h4>
						<h4 style="color: cornflowerblue">${tweet1}</h4>
					</td><td>
						<h4>${profile.twitterUserName}</h4>
						<h4 style="color: cornflowerblue">${tweet2}</h4>
					</td><td>
						<h4>${profile.twitterUserName}</h4>
						<h4 style="color: cornflowerblue">${tweet3}</h4>
					</td><td>
						<h4>${profile.twitterUserName}</h4>
						<h4 style="color: cornflowerblue">${tweet4}</h4>
					</td><td>
						<h4>${profile.twitterUserName}</h4>
						<h4 style="color: cornflowerblue">${tweet5}</h4>
					</td>

				</tr>

	    <div style="display: table-cell;"> 
		        <div>
						<h2 style="color: olive">Description</h2>
						<p>${profile.description}</p>
				</div>
			</div>
	    </div>
	</div>
</body>
</html>