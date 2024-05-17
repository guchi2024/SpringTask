package com.sparta.springtask.Dto;

import lombok.Getter;
import schedule.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDTO {
    private int id;
    private String title;
    private String content;
    private String people;
    private String pw;
    private LocalDateTime date;

    public ScheduleResponseDTO(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.people = schedule.getPeople();
        this.pw = schedule.getPw();
        this.date = schedule.getDate();
    }
}
