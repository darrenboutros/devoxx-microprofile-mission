package fr.devoxx.microprofile.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.devoxx.microprofile.model.Mission;
import fr.devoxx.microprofile.service.MissionService;

@Path("missions")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class MissionResource {
	

	@Inject 
	MissionService missionService;
	
	@POST
	public Response createMission (Mission mission) {
		return Response.status(Status.CREATED).entity(missionService.save(mission)).build();
	}
	

}
