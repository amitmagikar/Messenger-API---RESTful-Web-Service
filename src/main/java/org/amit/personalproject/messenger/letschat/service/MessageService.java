package org.amit.personalproject.messenger.letschat.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.amit.personalproject.messenger.letschat.database.DatabaseServiceStub;
import org.amit.personalproject.messenger.letschat.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseServiceStub.getMessages();
	
	public MessageService(){
		
		messages.put(1L, new Message(1, "Hey there!!!", "Stephany" ));
		messages.put(2L, new Message(2, "How you doin!!!", "Amit" ));

	}
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	//This method will return only those messages that are created in a particular year
	public List<Message> getMessagesForAYear(int year){
		
		List<Message> messageForAYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		
		for(Message message: messages.values()){
			
			cal.setTime(message.getMessageCreationDate());
			if(cal.get(Calendar.YEAR) == year){
				
				messageForAYear.add(message);
			}
		}
		
		return messageForAYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size > list.size()){
			return new ArrayList<Message>();
		}
		else{
			
			return list.subList(start, start+size);

		}
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0)
			return null;
		
		messages.put(message.getId(), message);
		return message;
	}
	
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
