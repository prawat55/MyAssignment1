<html>
	<head>
	<title>Add Employee</title>
	</head>
<body>
<h1>Add New Employee</h1>

<form method="post" action="rest/empService/addEmployee">
	<table>
		<tr>
			<td>Name :</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>Designation :</td>
			<td><input type="text" name="des" /></td>
		</tr>
		<tr>
			<td>Salary :</td>
			<td><input type="text" name="salary" /></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Save" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>
