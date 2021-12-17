package com.fantasyfootball.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "player" })
public class PlayerStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYER_STATISTIC_GENERATOR")
    @SequenceGenerator(name = "PLAYER_STATISTIC_GENERATOR")
    private Long id;

    private int goal = 0;

    private int assist = 0;

    private int cleanSheet = 0;

    private int save = 0;

    private int block = 0;

    private int yellowCard = 0;

    private int redCard = 0;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "playerStatistic")
    private Player player;
}
