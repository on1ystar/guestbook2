package com.example.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResponseDTO<DTO, EN> {
    
    private List<DTO> dtoList;
    private int page;                   // 현재 페이지
    private int start;                  // 시작 페이지
    private int end;                    // 끝 페이지
    private boolean prev;               // 이전 페이지 목록 여부
    private boolean next;               // 다음 페이지 목록 여부
    private List<Integer> pageList;     // 페이지 목록

    public PageResponseDTO(Page<EN> pageList, Function<EN, DTO> fn) {

        this.dtoList = pageList.stream().map(fn).collect(Collectors.toList());

        Pageable pageable = pageList.getPageable();

        this.page = pageable.getPageNumber();
        this.start = page - (page % pageable.getPageSize()) + 1;
        this.end = this.start + pageable.getPageSize() - 1;  // 다시 계산
    }

}
