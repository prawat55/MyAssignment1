package main;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.EmpDao;
import com.Employee;
import com.google.gson.Gson;

@Path("/empService")
public class MyTestService {
	EmpDao empDao = new EmpDao();
	String data = "";
	
	//fetch all employee data
	@GET
	@Path("/allEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() {
		EmpDao empDao = new EmpDao();
		String data = "";
		try {
			List<Employee> list = empDao.getAllEmployee();
			Gson gson = new Gson();
			data = gson.toJson(list);
			System.out.println(data);
		} catch (Exception e) {
			System.out.println("error");
		}
		return data;
	}
	
	//fetch employee data based on id
	@POST
	@Path("/getEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getEmpById(@FormParam("id") int id) {

		List<Employee> list = empDao.getById(id);
		Gson gson = new Gson();
		data = gson.toJson(list);
		System.out.println(data);
		return data;

	}
}
