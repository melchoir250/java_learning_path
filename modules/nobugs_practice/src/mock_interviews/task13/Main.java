package mock_interviews.task13;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Developer developer1 = new Developer("Petr", "Developer", 100000);
        Developer developer2 = new Developer("Anna", "Senior Developer", 145000);
        Developer developer3 = new Developer("Mike", "Tech Lead", 180000);
        Developer developer4 = new Developer("Elena", "Junior Developer", 65000);
        Developer developer5 = new Developer("Alex", "Backend Developer", 120000);
        Developer developer6 = new Developer("Olga", "Full Stack Developer", 135000);


        List<Developer> developers = List.of(developer1, developer2, developer3, developer4, developer5, developer6);

        Team team = new Team("StarsTeam");

        for (Developer item : developers) {
            team.addDeveloperTeam(item);
        }

        System.out.println(team.getNameTeam());
        System.out.println(team.allDeveloperTeam());
        System.out.println(team.allGradesDeveloperTeam());
    }
}