<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="styles.css" rel="stylesheet" type="text/css">
<title>Lisää Henkilo</title>
</head>

<body>
	<h1>Lisää Henkilo</h1>
		<form method="post" action="lisaa-henkilo">
			<table class="lisaa-pizza">
				<tr>
					<td>Id:</td>
					<td><input type="text" 
					value=""
					name="id" size="50"  />
					</td>
				</tr>
				<tr>
					<td>Paino:</td>
					<td><input type="text" 
					value=""
					name="paino" size="50"  />
					</td>
				</tr>
				<tr>
					<td>Pituus:</td>
					<td><input type="text" 
					value=""
					name="pituus" size="50"  />
					</td>
				</tr>
				<tr>	
					<td>Ika:</td>
					<td><input type="text" 
					value=""
					name="ika" size="50"  />
				</td>
				</tr>
				<tr>
					<td>Kotimaa:</td>
					<td><input type="text" 
					value=""
					name="kotimaa" size="50"  />
					</td>
				</tr>
				<tr>	
					<td>Sukupuoli:</td>
					<td><input type="text" 
					value=""
					name="sukupuoli" size="50"  />
					</td>
				</tr>
				<tr>
					<td><div class ="button"><a href="listaa-henkilot">Peruuta</a></div></td>
					<td>
						<input type="submit" name="submit-button" class="submit-button" value="Tallenna" />
					</td>
				</tr>	
			</table>
			</form>
		
</body>
</html>