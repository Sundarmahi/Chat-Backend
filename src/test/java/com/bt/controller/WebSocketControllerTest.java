package com.bt.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.bt.entity.ChatHistory;
import com.bt.entity.ChatMessage;
import com.bt.service.ChatService;
 
class WebSocketControllerTest {
 
    @Mock
    ChatService chatService;
 
    @InjectMocks
    WebSocketController webSocketController;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    void chat_Success() {
        // Given
        String roomId = "vet123";
        ChatMessage message = new ChatMessage("Hello", "user123");
        ChatHistory chatHistory = new ChatHistory();
        chatHistory.setPetId("user123");
        chatHistory.setVetId("vet123");
 
        // When
        when(chatService.saveData(message)).thenReturn(chatHistory);
 
        // Then
        assertDoesNotThrow(() -> {
            webSocketController.chat(roomId, message);
        });
    }
 
    @Test
    void chat_SaveDataException() {
        // Given
        String roomId = "vet123";
        ChatMessage message = new ChatMessage("Hello", "user123");
 
        // Then
        assertThrows(Exception.class, () -> {
            // When
            when(chatService.saveData(message)).thenThrow(new Exception());
 
            // Then
            webSocketController.chat(roomId, message);
        });
    }
}
 