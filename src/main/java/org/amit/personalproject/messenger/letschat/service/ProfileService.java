package org.amit.personalproject.messenger.letschat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.amit.personalproject.messenger.letschat.database.DatabaseServiceStub;
import org.amit.personalproject.messenger.letschat.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseServiceStub.getProfiles();
	
	public ProfileService(){
		
		profiles.put("Kate", new Profile(1L,"Kate","Kate","Middleton"));
	}
	
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getUsername(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		
		if(profile.getUsername().isEmpty())
			return null;
		
		profiles.put(profile.getUsername(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		
		return profiles.remove(profileName);
	}
}
