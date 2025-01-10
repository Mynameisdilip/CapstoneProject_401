package ttcontrol;

import models.ttentry;
import servicelayer.ttservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class mainpage {
    @Autowired
    private ttservice timetableService;

    @GetMapping("/generate")
    public ResponseEntity<String> generateTimetable() {
        timetableService.generateTimetable();
        return new ResponseEntity<>("Timetable generated successfully!", HttpStatus.OK);
    }

    @GetMapping("/entries")
    public ResponseEntity<List<ttentry>> getAllTimetableEntries() {
        List<ttentry> entries = timetableService.getAllTimetableEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }
}
