<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  
  <body>
    <a href="rest/empService/allEmployee"> All Data </a><br>  <br> 
    <form action="rest/empService/getEmployee" method="post">
    Id: <input type="text" name="id">
    <input type="submit">
    </form>
  </body>
</html>
