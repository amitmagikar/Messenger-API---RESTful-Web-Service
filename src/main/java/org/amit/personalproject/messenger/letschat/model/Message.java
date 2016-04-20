package org.amit.personalproject.messenger.letschat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date messageCreationDate;
	private String auhtor;
	private Map<Long, Comment> comments = new HashMap<>(); 
	private List<Link> links = new ArrayList<>(); 
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Message(){}
	
	public Message(long id, String message, String author){
		
		this.id = id;
		this.message = message;
		this.auhtor = author;
		this.messageCreationDate = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMessageCreationDate() {
		return messageCreationDate;
	}
	public void setMessageCreationDate(Date messageCreationDate) {
		this.messageCreationDate = messageCreationDate;
	}
	public String getAuhtor() {
		return auhtor;
	}
	public void setAuhtor(String auhtor) {
		this.auhtor = auhtor;
	}
	
    @XmlTransient
	public Map<Long, Comment> getComments(){
		
		return comments;
	}
	
	public void setComments(Map<Long, Comment> comments){
		
		this.comments = comments;
	}
	
	public void addLink(String url, String rel){
		
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	

}
