package edu.lion.ex.entity;

import lombok.*;
import org.springframework.boot.SpringApplication;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hello {

    public Hello(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

}
