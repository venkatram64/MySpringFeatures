package com.venkat.gneric.second;

interface Player {

}

record BaseBallPlayer(String name, String position) implements Player{

}

record FootballPlayer(String name, String position) implements Player{

}

public class BaseballDriver {

    public static void main(String[] args) {

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros = new SportsTeam("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseBallPlayer("B Harper", "Right Fielder");
        var marsh = new BaseBallPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        SportsTeam afc = new SportsTeam("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre of half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();
        //there is an issue in this implementation, I can add baseball player into SportsTeam
        var guthrie = new BaseBallPlayer("D Guthrie", "Center Fielder");
        afc.addTeamMember(guthrie);
        afc.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam team1, int t1Score, BaseballTeam team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1Score, SportsTeam team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
