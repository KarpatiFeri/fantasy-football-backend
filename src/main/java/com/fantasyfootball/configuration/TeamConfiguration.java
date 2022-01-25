package com.fantasyfootball.configuration;

import com.fantasyfootball.dao.TeamRepository;
import com.fantasyfootball.model.team.Team;

import com.fantasyfootball.model.player.Nationality;
import com.fantasyfootball.model.player.Player;
import com.fantasyfootball.model.player.PlayerStatistic;
import com.fantasyfootball.model.player.Position;
import com.fantasyfootball.model.team.TeamStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class TeamConfiguration {

    private final Random random = new Random();

    private final TeamRepository teamRepository;

    @Autowired
    public TeamConfiguration(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Bean
    @Profile("development")
    public CommandLineRunner initTeams() {
        return args -> {
            int teamSize = 20;
            List<String> teams = Arrays.asList("Arsenal", "Chelsea", "Liverpool", "Manchester United",
                    "Manchester City", "Newcastle", "West Ham", "Leicester", "Aston Villa", "Wolves", "Brentford",
                    "Brighton", "Leeds", "Watford", "Crystal Palace", "Everton", "Burnley", "Southampton",
                    "Norwich", "Tottenham");

            for (int i = 0; i < teamSize; i++) {
                List<Player> players = new ArrayList<>();

                for (int j = 0; j < teamSize; j++) {
                    Player player = Player.builder()
                            .firstName(getRandomFirstName())
                            .lastName(getRandomLastName())
                            .birthDay(getRandomBirthday())
                            .playerStatistic(PlayerStatistic.builder().build())
                            .position(getRandomPosition(j))
                            .nationality(getRandomNationality())
                            .height(getRandomHeight())
                            .weight(getRandomWeight())
                            .foot(getRandomFoot())
                            .value(getRandomValue())
                            .build();
                    players.add(player);
                }

                Team premierLeagueTeam = Team.builder()
                        .league("Premier League")
                        .name(teams.get(i))
                        .position(i + 1)
                        .players(players)
                        .teamStatistic(TeamStatistic.builder().build())
                        .build();

                for (Player player : players) {
                    player.setTeam(premierLeagueTeam);
                }
                teamRepository.save(premierLeagueTeam);
            }
        };
    }

    public String getRandomFirstName() {
        List<String> englishFirstNames = Arrays.asList("Aaron", "Bukayo", "Alex", "Harry", "Ben", "Kalvin", "John",
                "Phil", "Conor", "Reece", "Kyle", "Emile", "Mason", "Jadon", "Kieran", "Andrew", "Theo", "Mark",
                "Brandon", "Tyler", "Jesse", "Luke", "James", "Jordan", "Callum", "Shane", "Will", "Adam", "Troy");
        return englishFirstNames.get(random.nextInt(englishFirstNames.size()));
    }

    public String getRandomLastName() {
        List<String> englishLastNames = Arrays.asList("Saka", "Kane", "Smith Rowe", "Maguire", "White", "Ramsdale",
                "Sterling", "Grealish", "Foden", "Rice", "James", "Mount", "Phillips", "Robertson", "Duff",
                "Tierney", "Abraham", "Walcott", "Roberts", "Stones", "Lingard", "Shaw", "Henderson", "Chillwell",
                "Coleman", "Robinson", "Wilson", "Idah", "Callen", "McGregor", "McCarthey", "Sullivan", "Duffy");
        return englishLastNames.get(random.nextInt(englishLastNames.size()));
    }

    public LocalDate getRandomBirthday() {
        int minYear = 1985;
        int maxYear = LocalDate.now().getYear() - 16;
        int year = random.nextInt(maxYear - minYear) + minYear;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(27) + 1;
        return LocalDate.of(year, month, day);
    }

    public Nationality getRandomNationality() {
        return Nationality.values()[random.nextInt(Nationality.values().length)];
    }

    public String getRandomFoot() {
        int randomPercent = random.nextInt(100);
        return randomPercent < 60 ? "Right" : "Left";
    }

    public Integer getRandomHeight() {
        int minHeight = 160;
        int maxHeight = 220;
        return random.nextInt(maxHeight - minHeight) + minHeight;
    }

    public Integer getRandomWeight() {
        int minWeight = 50;
        int maxWeight = 120;
        return random.nextInt(maxWeight - minWeight) + minWeight;
    }

    public Integer getRandomValue() {
        int cheap = 60;
        int expensive = 150;
        return random.nextBoolean() ? random.nextInt(expensive - cheap) + cheap : random.nextInt(cheap) + 1;
    }

    public Position getRandomPosition(int index) {
        int numberOfGoalkeepers = 2;
        int numberOfDefenders = numberOfGoalkeepers + 7;
        int numberOfMidfielders = numberOfDefenders + 7;

        List<Position> defenders = Arrays.asList(Position.LB, Position.LWB, Position.CB, Position.RB, Position.RWB);
        List<Position> midfielders = Arrays.asList(Position.LM, Position.CM, Position.CDM, Position.CAM, Position.RM);
        List<Position> strikers = Arrays.asList(Position.LW, Position.CF, Position.ST, Position.RW);

        if (index < numberOfGoalkeepers)
            return Position.GK;
        else if (index < numberOfDefenders)
            return defenders.get(random.nextInt(defenders.size()));
        else if (index < numberOfMidfielders)
            return midfielders.get(random.nextInt(midfielders.size()));

        return strikers.get(random.nextInt(strikers.size()));
    }
}
