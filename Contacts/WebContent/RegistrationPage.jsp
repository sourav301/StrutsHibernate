<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="registerAction" method="registerMethod" validate="true">
	<s:textfield name="username" label="Username" /><br>
	<s:textfield name="password" label="Password" /><br>
	<s:textfield name="address" label="Address" /><br>
	<s:textfield name="phonenumber" label="Phone Number" /><br>
	<s:select headerValue="Select Cities" headerKey="-1" name="Cities" list="cityList"  listKey="cityId" listValue="cityName"></s:select>
	<s:checkboxlist name="colourId" list="colourList" listKey="id" listValue="colourName" ></s:checkboxlist>
	<s:submit name="submit" label="Submit" align="center" />
</s:form>

</body>
</html>