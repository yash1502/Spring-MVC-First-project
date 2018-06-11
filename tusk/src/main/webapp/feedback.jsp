<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addFeedback" method="get">

Your name: <br>
<input type="text" name="name"><br>
<br>

Your email: <br>
<input type="text" name="email"><br>
<br>

Select <br>
<select id="reg" name="reg">
  <option value="website">website</option>
  <option value="Myself">Mr. Yash Neema</option>
  <option value="OnlineSession">Online Session</option>
  </select>
<br><br>

Any Code: <br>
<input type="text" name="code"><br>
<br>
Your comments: <br>
<textarea name="comments" rows="15" cols="50"></textarea><br><br>

Rating <br>
<select id="rating" name="rating">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  </select>
<br><br>

<input type="submit" value="Submit">
 
</form>
</body>
</html>