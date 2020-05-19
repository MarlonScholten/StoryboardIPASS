//package nl.marlon.webservices;
//
//import nl.marlon.model.Archive;
//import nl.marlon.model.User;
//
//import javax.json.Json;
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObjectBuilder;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.List;
//
//@Path("/users")
//public class Userresource {
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getAllUsers(){
//		List<User> allUsers = Archive.getAllUsers();
//		JsonArrayBuilder jab = createUserJsonArray(allUsers);
//		return jab.build().toString();
//	}
//	@GET
//	@Path("/largestsurfaces")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getLargestSurfaces(){
//		List<User> largestSurfaces = archive.get10LargestSurfaces();
//		JsonArrayBuilder jab = createUserJsonArray(largestSurfaces);
//		return jab.build().toString();
//	}
//
//	@GET
//	@Path("/{code}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getUserByCode(@PathParam("code") String code){
//		User target = archive.getUserByCode(code);
//		return createUserJsonObject(target).build().toString();
//	}
//
//	// Utils
//	private JsonArrayBuilder createUserJsonArray(List<User> UserList){
//		JsonArrayBuilder jab = Json.createArrayBuilder();
//
//		for(User User : UserList){
//			jab.add(createUserJsonObject(User));
//		}
//		return jab;
//	}
//
//	private JsonObjectBuilder createUserJsonObject(User User){
//		JsonObjectBuilder job = Json.createObjectBuilder();
//
//		job.add("code", User.getCode());
//		job.add("iso3", User.getIso3());
//		job.add("name", User.getName());
//		job.add("continent", User.getContinent());
//		job.add("capital", User.getCapital());
//		job.add("region", User.getRegion());
//		job.add("surface", User.getSurface());
//		job.add("population", User.getPopulation());
//		job.add("government", User.getGovernment());
//		job.add("lat", User.getLatitude());
//		job.add("lng", User.getLongitude());
//
//		return job;
//	}
//}
