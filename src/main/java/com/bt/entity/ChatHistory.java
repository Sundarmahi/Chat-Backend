package com.bt.entity;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class ChatHistory{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int chatId;
	
	String vetId;//vet id from Vet_Service
	String petId;//Pet Id from pet Service
	LocalDate startChatSession;
	LocalDate endChatSession;
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getVetId() {
		return vetId;
	}
	public void setVetId(String vetId) {
		this.vetId = vetId;
	}
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public LocalDate getStartChatSession() {
		return startChatSession;
	}
	public void setStartChatSession(LocalDate startChatSession) {
		this.startChatSession = startChatSession;
	}
	public LocalDate getEndChatSession() {
		return endChatSession;
	}
	public void setEndChatSession(LocalDate endChatSession) {
		this.endChatSession = endChatSession;
	}
}