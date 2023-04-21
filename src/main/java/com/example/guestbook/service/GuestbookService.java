package com.example.guestbook.service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;

public interface GuestbookService {
    
    Long register(GuestbookDTO guestbookDTO);

    default Guestbook dtoToEntity(GuestbookDTO guestbookDTO) {
        Guestbook guestbook = Guestbook.builder()
            .gno(guestbookDTO.getGno())
            .title(guestbookDTO.getTitle())
            .content(guestbookDTO.getContent())
            .writer(guestbookDTO.getWriter())
            .build();
        
        return guestbook;
    }
}
