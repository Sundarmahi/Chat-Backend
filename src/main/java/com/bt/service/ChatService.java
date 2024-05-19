package com.bt.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.entity.ChatHistory;
import com.bt.entity.ChatMessage;
import com.bt.exception.UserNotFoundException;
import com.bt.repository.ChatRepository;

@Service
public class ChatService {
	@Autowired
	ChatRepository repo;
	
	int min=1000;
	int max=9999;
	Random random = new Random(); 
	
	// Map the data comming from front end to our models
	public ChatHistory saveData(ChatMessage message) {
		ChatHistory history = new ChatHistory();
		int randomNum=random.nextInt(max-min+1)+min;
		String random=String.valueOf(randomNum);
		history.setPetId(message.getUser());
		history.setVetId(random);
		history.setEndChatSession(LocalDate.now());
		history.setStartChatSession(LocalDate.now());
		return history;
	}

	// To save the chat history into the data base
	public ChatHistory saveChatHistory(ChatHistory data) {
		ChatHistory chatHistory = new ChatHistory();
		if (data.getPetId().isEmpty() || data.getVetId().isEmpty()) {
			throw new UserNotFoundException("User Not found!!!");
		} else {
			chatHistory = repo.save(data);
			System.out.println(chatHistory);
			return chatHistory;

		}
	}
}