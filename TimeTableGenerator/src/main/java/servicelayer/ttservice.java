package servicelayer;

import models.*;
import ttreposi.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ttservice {
    @Autowired
    private entry timetableEntryRepository;

    @Autowired
    private coursemodel courseRepository;

    @Autowired
    private teachermodel teacherRepository;

    @Autowired
    private classr classroomRepository;

    public void generateTimetable() {
        List<coursemodel> courses = courseRepository.findAll();
        List<teachermodel> teachers = teacherRepository.findAll();
        List<Classr> classrooms = classroomRepository.findAll();

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        LocalTime startTime = LocalTime.of(9, 0);  // Start time: 9:00 AM
        LocalTime endTime = LocalTime.of(17, 0);   // End time: 5:00 PM
        int duration = 1;  // Duration of each class in hours

        int teacherIndex = 0;
        int classroomIndex = 0;

        for (coursemodel course : courses) {
            for (String day : daysOfWeek) {
                LocalTime currentTime = startTime;

                while (currentTime.plusHours(duration).isBefore(endTime) || currentTime.plusHours(duration).equals(endTime)) {
                    teachermodel teacher = teachers.get(teacherIndex % teachers.size());
                    Classr classroom = classrooms.get(classroomIndex % classrooms.size());

                    ttentry entry = new ttentry();
                    entry.setCourseId(course.getId());
                    entry.setTeacherId(teacher.getId());
                    entry.setClassroomId(classroom.getId());
                    entry.setDayOfWeek(day);
                    entry.setStartTime(currentTime);
                    entry.setEndTime(currentTime.plusHours(duration));

                    timetableEntryRepository.save(entry);

                    currentTime = currentTime.plusHours(duration);

                    // Move to the next teacher and classroom
                    teacherIndex++;
                    classroomIndex++;
                }
            }
        }
    }

    public List<ttentry> getAllTimetableEntries() {
        return timetableEntryRepository.findAll();
    }
}
