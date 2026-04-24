package mock_interviews.task15;

public class Main {
    public static void main(String[] args) {
        Post post = new Post("1", "Всем привет, это мой первый пост!");
        ;
        post.addLike("Alex");
        post.addLike("Maria");

        System.out.println("Количество лайков: " + post.getLikesCount());

        post.addLike("Alex"); // Лайк второй раз
        System.out.println("Количество лайков: " + post.getLikesCount());

        post.removeLike("Alex");
        System.out.println("Количество лайков: " + post.getLikesCount());

        System.out.println("Поставила ли лайк Maria? " + post.hasLiked("Maria"));
        System.out.println("Поставил ли лайк Alex? " + post.hasLiked("Alex"));
    }
}