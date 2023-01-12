package com.avroproducer.controller;

import com.avro.schema.Student;
import com.avroproducer.dto.StudentDto;
import com.avroproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/send")
    public ResponseEntity<?> sendStudent(@RequestBody StudentDto studentDto) {

        System.out.println("JAVA VERSION: " + System.getProperty("java.version"));

        Student student = Student.newBuilder().build();

        student.setId(new Random(1000).nextInt());
        student.setName(studentDto.getName());
        student.setScore(studentDto.getScore());

        producerService.send(student);

        return ResponseEntity.ok("Student with name " + studentDto.getName() + " has been successfully inserted.");
    }

}
