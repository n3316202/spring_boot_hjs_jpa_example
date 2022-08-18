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
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
}
