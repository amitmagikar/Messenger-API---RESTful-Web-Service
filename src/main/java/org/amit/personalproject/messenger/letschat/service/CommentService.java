package org.amit.personalproject.messenger.letschat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.amit.personalproject.messenger.letschat.database.DatabaseServiceStub;
import org.amit.personalproject.messenger.letschat.model.Comment;
import org.amit.personalproject.messenger.letschat.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseServiceStub.getMessages();
	
	
	public List<Comment> getAllComments(long messageId){
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values()); 
	}
	
	
	public Comment getComment(long messageId, long commentId){
		
		Message message = messages.get(messageId);
		
		Response response = Response.status(Status.NOT_FOUND).build();
		if(message == null){
			throw new NotFoundException(response);
		}
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		Comment comment = comments.get(commentId);
		if(comment == null){
			throw new NotFoundException(response);
		}
		
		return comment;
	}
	
	
	public Comment addComment(long messageId, Comment comment){
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	
	public Comment updateComment(long messageId, Comment comment){
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() < 0){
			return null;
		}
		else{
			comments.put(comment.getId(), comment);
			return comment;
			
		}
	}
	
	
	public Comment removeComment(long messageId, long commentId){
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
