package mock_interviews.task13;

public class Developer {
    private final String nameDeveloper;
    private String postDeveloper;
    private int gradeDeveloper;

    public Developer(String nameDeveloper, String postDeveloper, int gradeDeveloper) {
        this.nameDeveloper = nameDeveloper;
        this.postDeveloper = postDeveloper;
        this.gradeDeveloper = gradeDeveloper;
    }

    public String getNameDeveloper() {
        return nameDeveloper;
    }

    public String getPostDeveloper() {
        return postDeveloper;
    }

    public int getGradeDeveloper() {
        return gradeDeveloper;
    }

    public void setPostDeveloper(String postDeveloper) {
        this.postDeveloper = postDeveloper;
    }

    public void setGradeDeveloper(int gradeDeveloper) {
        this.gradeDeveloper = gradeDeveloper;
    }

    @Override
    public String toString() {
        return "Имя разработчика: " + getNameDeveloper() + ",\n" +
                "занимаемая должность: " + getPostDeveloper() + ",\n" +
                "заработная плата: " + getGradeDeveloper() + ".\n";
    }
}