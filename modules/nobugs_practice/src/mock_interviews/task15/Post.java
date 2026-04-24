package mock_interviews.task15;

import java.util.HashSet;
import java.util.Set;

public class Post {
    private final String id;
    private final String text;
    private final Set<String> likedUsers;

    public Post(String id, String text) {
        this.id = id;
        this.text = text;
        this.likedUsers = new HashSet<>();
        ;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void addLike(String username) {
        this.likedUsers.add(username);
    }

    public void removeLike(String username) {
        this.likedUsers.remove(username);
    }

    // проверка кол-во лайков
    public int getLikesCount() {
        return this.likedUsers.size();
    }

    // проверка поставлен лайк
    public boolean hasLiked(String username) {
        return this.likedUsers.contains(username);
    }
}