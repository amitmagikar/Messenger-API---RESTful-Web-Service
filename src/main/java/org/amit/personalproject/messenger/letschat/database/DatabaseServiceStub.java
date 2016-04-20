package org.amit.personalproject.messenger.letschat.database;

import java.util.HashMap;
import java.util.Map;

import org.amit.personalproject.messenger.letschat.model.Message;
import org.amit.personalproject.messenger.letschat.model.Profile;

public class DatabaseServiceStub {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		
		return profiles;
	}
}
