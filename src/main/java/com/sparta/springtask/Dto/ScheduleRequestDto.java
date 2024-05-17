package com.sparta.springtask.Dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String people;
    private String pw;
    private LocalDateTime date;

    public ScheduleRequestDto(String title, String content, String people, String pw, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.people = people;
        this.pw = pw;
        this.date = date;
    }
}
