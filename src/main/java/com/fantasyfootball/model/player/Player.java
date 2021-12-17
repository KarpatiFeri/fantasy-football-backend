package com.fantasyfootball.model.player;

import javax.persistence.*;

import com.fantasyfootball.model.Team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "team" })
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYER_GENERATOR")
    @SequenceGenerator(name = "PLAYER_GENERATOR")
    private Long id;

    private String firstName;

    private String lastName;

    @Transient
    private String fullName;

    private Integer height;

    private Integer weight;

    private String foot;

    private LocalDate birthDay;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Enumerated(EnumType.STRING)
    private Position position;

    private Integer value;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Team team;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PlayerStatistic playerStatistic;

    public int getAge() {
        return Period.between(this.birthDay, LocalDate.now()).getYears();
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
