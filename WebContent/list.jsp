<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="ua.bakery.db.jpa.Request"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Requests</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<span>${title}</span><br>		
	<%
		ArrayList requests = (ArrayList)request.getAttribute("requests");
		if (requests != null) {
			if (requests.size()==0)
				out.print("Заявки відсутні!");
			else {
				out.print("<table border=\"1\">");
				out.print("<TR><TD>Id</TD><TD>Оформлено</TD><TD>Виконати</TD>" + "<TD>Виконано</TD</TR>");
			for (int i = 0; i < requests.size(); i++) {
				out.print("<TR>");
				Request req = (Request)requests.get(i);
				out.print("<TD>" + req.getId() + "</TD>");
				out.print("<TD>" + req.getDate_Oformleniya() + "</TD>");
				out.print("<TD>" + req.getDate_Request() + "</TD>");
				out.print("<TD>" + req.isOk() + "</TD>");
				out.print("</TR>");
			}
			out.print("</table>");
	}
}
%>
	
	
</body>
</html>