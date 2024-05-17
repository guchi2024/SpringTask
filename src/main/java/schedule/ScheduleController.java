package schedule;

import org.springframework.web.bind.annotation.*;
import schedule.Schedule;
import com.sparta.springtask.Dto.ScheduleResponseDTO;
import com.sparta.springtask.Dto.ScheduleRequestDto;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final Map<Integer, Schedule> scheduleList = new HashMap<>();

    @PostMapping("/schedules")
    public ScheduleResponseDTO createMemo(@RequestBody ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        // Schedule Max ID Check - schedule에 Max ID 찾기 ))id값으로 일정을 구분해야함
        Integer maxID = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) + 1 : 1;
        schedule.setId(maxID);

        // DB 저장
        scheduleList.put(schedule.getId(), schedule);

        // Entity -> ResponseDto
        ScheduleResponseDTO scheduleResponseDto = new ScheduleResponseDTO(schedule);

        return scheduleResponseDto;
    }
    // 2. 선택한 일정 조회
    @GetMapping("/schedules/{id}")
    public ScheduleResponseDTO getSchedule(@PathVariable Integer id) {
        Schedule schedule = scheduleList.get(id);
        ScheduleResponseDTO scheduleResponseDto = new ScheduleResponseDTO(schedule);
        return scheduleResponseDto;
    }

    // 3. 등록된 일정 전체 조회
    @GetMapping("/schedules")
    public List<ScheduleResponseDTO> getAllMemos() {
        // Map to List
        List<ScheduleResponseDTO> responseDtos = scheduleList.values().stream().map(ScheduleResponseDTO::new).toList();

        return responseDtos;
    }

    // 4, 선택한 일정의 내용 수정
    @PutMapping("/schedule/{id}")
    public Integer updateMemo(@PathVariable Integer id, @RequestBody ScheduleRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        if (scheduleList.containsKey(id)) {
            // 해당 메모 가져오기
            Schedule schedule = scheduleList.get(id);

            // 메모 수정하기
            schedule.update(requestDto);
            return id;
        } else {
            return null;
        }
    }

    // 5. 선택한 일정 삭제하기
    @DeleteMapping("schedule/{id}")
    public Long deletMemo(@PathVariable Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        if (scheduleList.containsKey(id)){
            // 해당 메모를 삭제
            scheduleList.remove(id);
            return id;
        } else{
            return null;
        }
    }
}

