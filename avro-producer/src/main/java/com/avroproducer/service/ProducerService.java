package com.avroproducer.service;

import com.avro.schema.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class ProducerService {

    @Value("${avro.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public void send(Student student) {
        for (int i = 1; i < 11; i++) {
            kafkaTemplate.send(topicName, "student-key", student);
        }
    }

    public void sendStudent(Student student) {
        boolean finished = false;
        CompletableFuture<SendResult<String, Student>> future = null;
        try {
            for (int i = 1; i < 11; i++) {
                future = kafkaTemplate.send(topicName, "latest-student-key" + i, student);
                SendResult<String, Student> futureReturn = future.get(4, TimeUnit.SECONDS);
                log.info("Student message " + i + " successfully produced.");
            }
            finished = true;
        } catch (TimeoutException e) {
            log.error("Cannot produce message", e);
        } catch (ExecutionException e) {
            log.error("Cannot produce message", e);
        } catch (InterruptedException e) {
            log.error("Cannot produce message", e);
        } finally {
            if (!finished && future != null) {
                future.cancel(false);
            }
        }
    }

}
