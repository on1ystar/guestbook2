package com.example.guestbook.service;

import org.springframework.stereotype.Service;

import com.example.guestbook.dto.GuestbookDTO;
import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO guestbookDTO) {
        
        log.info("register -> " + guestbookDTO);

        Guestbook guestbook = dtoToEntity(guestbookDTO);

        Guestbook result = guestbookRepository.save(guestbook);

        log.info("registered -> " + result);

        return result.getGno();

    }
}