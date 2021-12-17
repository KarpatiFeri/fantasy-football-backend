package com.fantasyfootball.model;

import java.util.Set;

import javax.persistence.*;

import com.fantasyfootball.model.player.Player;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAM_GENERATOR")
    @SequenceGenerator(name = "TEAM_GENERATOR")
    private Long id;

    private String name;

    private String league;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "team", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @Singular
    private Set<Player> players;
}
