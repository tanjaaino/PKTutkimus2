<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="pktutkimus.model.Henkilo"%>
<jsp:useBean id="henkilot" type="java.util.ArrayList<Henkilo>"
	scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>PKTutkimuksen Henkilöt</title>
<link href="styles.css" rel="stylesheet" type="text/css">

</head>
	<body>

		<h1>Henkilöt</h1>
		<table width="336" border="1" align="center">
		<tr>
			<td>Id</td>
				<td>Painokeroin</td>
				<td>Paino (kg)</td>
				<td>Pituus (m)</td>
				<td>Ika</td>
				<td>Kotimaa</td>
				<td>Sukupuoli</td>
		</tr>
		<% Henkilo henkilo;
			for(int i = 0; i < henkilot.size(); i++) {
			  henkilo = henkilot.get(i);
		%>
			  <tr>
				<td><%=henkilo.getId()%></td>
				<td><%=henkilo.getPainokerroin()%></td>
				<td><%=henkilo.getPaino()%></td>
				<td><%=henkilo.getPituus()%></td>
				<td><%=henkilo.getIka()%></td>
				<td><%=henkilo.getKotimaa()%></td>
				<td><%=henkilo.getSukupuoli()%></td>
			  </tr>
		   <% } %>
		</table>
	</body>
</html>