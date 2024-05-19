package com.bt.service;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.bt.entity.ChatHistory;
import com.bt.exception.UserNotFoundException;
import com.bt.repository.ChatRepository;
 
class ChatServiceTest {
 
    @Mock
    ChatRepository repo;
 
    @InjectMocks
    ChatService chatService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    void saveChatHistory_Success() {
        // Given
        ChatHistory chatHistory = new ChatHistory();
        chatHistory.setPetId("pet123");
        chatHistory.setVetId("vet123");
        chatHistory.setStartChatSession(LocalDate.now());
        chatHistory.setEndChatSession(LocalDate.now());
 
        // When
        when(repo.save(any(ChatHistory.class))).thenReturn(chatHistory);
 
        // Then
        assertDoesNotThrow(() -> {
            chatService.saveChatHistory(chatHistory);
        });
    }
}