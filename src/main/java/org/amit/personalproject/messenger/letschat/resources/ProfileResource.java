package org.amit.personalproject.messenger.letschat.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.amit.personalproject.messenger.letschat.model.Profile;
import org.amit.personalproject.messenger.letschat.service.ProfileService;


@Path("/profiles")
public class ProfileResource {

	private ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		
		return profileService.getAllProfiles();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profileName){
		
		return profileService.addProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName")String profileName){
		
		return profileService.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName")String profileName, Profile profile){
		
		profile.setUsername(profileName);
		return profileService.updateProfile(profile);
		
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName")String profileName){
		
		profileService.removeProfile(profileName);
	}
}
