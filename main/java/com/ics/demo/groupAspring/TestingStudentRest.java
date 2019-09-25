package com.ics.demo.groupAspring;

import com.ics.demo.groupAspring.models.Appointment;
import com.ics.demo.groupAspring.models.Movie;
import com.ics.demo.groupAspring.models.Student;
import com.ics.demo.groupAspring.models.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TestingStudentRest implements CommandLineRunner {
    private final FeignStudentClient feignStudentClient;
    public TestingStudentRest(FeignStudentClient feignStudentClient){

        this.feignStudentClient = feignStudentClient;
    }
    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        Student newStudent = new Student("95625", "Shivere");
        newStudent = feignStudentClient.createStudent(newStudent);
        System.out.println("Created student: " + newStudent.toString());

//        Appointment appointment = feignStudentClient.createAppointment(new Appointment(2,newStudent.getId()));
//
//        Appointment.getid

//        Appointment newAppointment = new Appointment(8, 3);
//        feignStudentClient.createAppointment(newAppointment);
//        System.out.println("Created appointment: " + newAppointment.toString());
//
//        feignStudentClient.confirmAppointment((long)10, (long)8);

//        ResponseEntity<List<Student>> response = restTemplate.exchange(
//                "http://10.51.14.35:1000/students/95625",
//                HttpMethod.GET,
//                null,
//        new ParameterizedTypeReference<List<Student>>(){});
//        List<Student> students = response.getBody();
//        System.out.println(students.toString());
//
//        ResponseEntity<List<Teacher>> response1 = restTemplate.exchange(
//                "http://10.51.10.111:9090/teachers",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Teacher>>(){});
//        List<Teacher> teachers = response1.getBody();
//        System.out.println(teachers.toString());
//
//        Appointment newAppointment = new Appointment(7, 2);
//        feignStudentClient.createAppointment(newAppointment);
//        System.out.println("Created appointment: " + newAppointment.toString());
//
//        feignStudentClient.confirmAppointment(Long.valueOf(8));
//        feignStudentClient.updateAppointment((long)10, (long)8);

//        List<Teacher> teacher = feignStudentClient.getAllTeachers();
//        System.out.println(teacher);
    }
}
