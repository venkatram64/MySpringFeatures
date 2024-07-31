package com.venkat.gneric;

interface Player {
    String name();
}

record BaseBallPlayer(String name, String position) implements Player{

}

record FootballPlayer(String name, String position) implements Player{

}

record VolleyballPlayer(String name, String position) implements Player{

}

public class BaseballDriver {

    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, PA", "US");
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2, 3, astros2, 5);

        Team<BaseBallPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseBallPlayer, Affiliation> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseBallPlayer("B Harper", "Right Fielder");
        var marsh = new BaseBallPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseBallPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        //below is possible b/c of there is no upperbound for Affiliation
        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows",
                "City of Adelaide, South Australia, in AU");
        var tex = new FootballPlayer("Tex Walker", "Centre of half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();
        /*//there is an issue in this implementation, I can add baseball player into SportsTeam
        var guthrie = new BaseBallPlayer("D Guthrie", "Center Fielder");
        afc.addTeamMember(guthrie);*/
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts","Setter"));
        adelaide.listTeamMembers();

        Team<VolleyballPlayer, Affiliation> canberra = new Team<>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black","Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);
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

    public static void scoreResult(Team team1, int t1Score, Team team2, int t2Score){
        String message = team1.setScore(t1Score, t2Score);
        team2.setScore(t2Score, t1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
