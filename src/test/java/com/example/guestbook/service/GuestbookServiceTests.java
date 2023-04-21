package com.example.guestbook.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class GuestbookServiceTests {
    
    @Autowired
    private GuestbookService guestbookService;
    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void registerTest() {
        
        // Given
        String title = "Test title";
        String content = "Test content";
        String writer = "Test writer";
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
            .title(title)
            .content(content)
            .writer(writer)
            .build();

        // When
        Long registeredGno = guestbookService.register(guestbookDTO);

        // Then
        Optional<Guestbook> resultOptional = guestbookRepository.findById(registeredGno);
        Guestbook guestbook = null;
        if(resultOptional.isPresent()) {
            guestbook = resultOptional.get();
        }
        Assertions.assertThat(guestbook.getTitle()).isEqualTo(title);
        Assertions.assertThat(guestbook.getContent()).isEqualTo(content);
        Assertions.assertThat(guestbook.getWriter()).isEqualTo(writer);
    }
}
