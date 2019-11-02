<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Printizen CSV Tool | CSV File</title>


</head>
<body>
	<h1>CSV File Upload</h1>
	<form method="POST" action="/upload" enctype="multipart/form-data">
		<input type="file" ID="fileSelect" accept=".csv" name="file" /> <br />
		<br /> <select id="cartname" name="cartname">
			<option value="1">Flipkart</option>
			<option value="2">Amazon US</option>
			<option value="3">Amazon UK</option>
		</select> <br /> <br /> <input type="submit" value="Submit" />
	</form>
	${message}
</body>
</html>

<!-- https://stackoverflow.com/questions/11832930/html-input-file-accept-attribute-file-type-csv -->