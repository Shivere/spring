package com.ics.demo.groupAspring;

import com.ics.demo.groupAspring.models.Appointment;
import com.ics.demo.groupAspring.models.Student;
import com.ics.demo.groupAspring.models.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "client", url = "http://10.51.10.111:2000")
public interface FeignStudentClient {
    /*
     *Mock CAT
     * */
    @RequestMapping(method = RequestMethod.GET, value = "students/{id}")
    Student findStudentById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value="lecturers")
    List<Teacher> getAllTeachers();

    @RequestMapping(method = RequestMethod.GET, value="appointments")
    List<Appointment> getAllAppointments();

    @RequestMapping(method = RequestMethod.POST, value ="students", consumes = "application/json")
    Student createStudent(@RequestBody Student student);

    @RequestMapping(method = RequestMethod.POST, value ="appointments", consumes = "application/json")
    Appointment createAppointment(@RequestBody Appointment appointment);

    @RequestMapping(method = RequestMethod.PATCH, value ="appointments/{appointmentId}", consumes = "application/json")
    Appointment confirmAppointment(@PathVariable(name = "appointmentId") Long id, @RequestParam(name = "studentId") Long studentId);

}
