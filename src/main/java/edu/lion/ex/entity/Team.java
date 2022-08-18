package edu.lion.ex.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
}
