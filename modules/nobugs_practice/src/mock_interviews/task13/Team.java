package mock_interviews.task13;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nameTeam;
    private List<Developer> developersList;

    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
        this.developersList = new ArrayList<>();
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public List<Developer> getDevelopersList() {
        return developersList;
    }

    public void addDeveloperTeam(Developer developer) {
        developersList.add(developer);
    }

    public void removeDeveloperTeam(Developer developer) {
        developersList.remove(developer);
    }

    public void searchDeveloperTeam(Developer developer) {
        for (Developer item : developersList) {
            if (item.equals(developer)) {
                System.out.println("Разаработчик найден, он в команде: " + getNameTeam());
            }
        }
    }

    public int allGradesDeveloperTeam() {
        int sum = 0;
        for (Developer item : developersList) {
            sum += item.getGradeDeveloper();
        }
        return sum;
    }

    public List<Developer> allDeveloperTeam() {
        return developersList;
    }
}