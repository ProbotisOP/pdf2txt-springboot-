<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PDF 2 TXT</title>


</head>
<body>

<form method="POST" action="/submit" enctype="multipart/form-data">
		<input type="file" name="file" /><br />
		<br /> <input type="submit" value="Submit" />
	</form>
	
	<br>
	<br>

	<textarea rows="20" cols="40" >${data}</textarea>

</body>
</html>