package org.amit.personalproject.messenger.letschat.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.amit.personalproject.messenger.letschat.model.Message;
import org.amit.personalproject.messenger.letschat.resources.bean.MessageBean;
import org.amit.personalproject.messenger.letschat.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageBean bean){
		if(bean.getYear() > 0){
			return messageService.getMessagesForAYear(bean.getYear());
		}
		if(bean.getStart() >= 0 && bean.getSize() >= 0){
			return messageService.getAllMessagesPaginated(bean.getStart(), bean.getSize());
		}
		return messageService.getAllMessages();
	}
	

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long messageId, @Context UriInfo uriInfo){
		
		Message message = messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo,message), "self");
		message.addLink(getUriForProfile(uriInfo,message), "profile");
		message.addLink(getUriForComments(uriInfo,message), "comments");
		
		return message;
	}
	


	private String getUriForComments(UriInfo uriInfo, Message message){
		
		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class,"getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId",message.getId())
				.build().toString();
		
		return uri;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message){
		
		String uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class)
				.path(message.getAuhtor()).build().toString();
		
		return uri;
	}
	
	private String getUriForSelf(UriInfo uriInfo, Message message){
		
		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(Long.toString(message.getId())).build().toString();
		
		return uri;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		
		return messageService.addMessage(message);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long messageId, Message message){
		
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long messageId){
		
		 messageService.removeMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		
		return new CommentResource();
	}
	
}
