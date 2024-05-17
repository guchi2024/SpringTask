package schedule;

import com.sparta.springtask.Dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Schedule {
    private int id;
    private String title;
    private String content;
    private String people;
    private String pw;
    private LocalDateTime date;


    public Schedule(int id, String title, String content, String people, String pw, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.people = people;
        this.pw = pw;
        this.date = date;
    }

    public Schedule(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.people = requestDto.getPeople();
        this.pw = requestDto.getPw();
        this.date = requestDto.getDate();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.people = requestDto.getPeople();
    }

}
