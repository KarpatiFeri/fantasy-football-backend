package com.fantasyfootball.model.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "team" })
public class TeamStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_STATISTIC_GENERATOR")
    @SequenceGenerator(name = "TEAM_STATISTIC_GENERATOR")
    private Long id;

    private int points = 0;

    private int win = 0;

    private int draw = 0;

    private int loose = 0;

    private int goalsFor = 0;

    private int goalsAgainst = 0;

    private int playedMatches = 0;

    @Transient
    private int goalDifference;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "teamStatistic")
    private Team team;

    public int getGoalDifference() {
        return this.goalsFor - this.goalsAgainst;
    }

}
