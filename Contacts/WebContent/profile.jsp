<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:property value="#request.status"/><br>
Welcome <s:property value="#session.userObject.username"/><br>
Address:<s:property value="#session.userObject.address"/><br>
Phone Number:  <s:property value="#session.userObject.phonenumber"/><br>
City:<s:property value="#session.userObject.cityName"/><br>
Colour:<s:property value="#session.userObject.colourName"/><br>

</body>
</html>