package com.avroproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class StudentDto {

    private Integer id;
    private String name;
    private Integer score;

}
