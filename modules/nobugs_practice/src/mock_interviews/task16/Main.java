package mock_interviews.task16;

public class Main {
    public static void main(String[] args) {
        Session session = new Session("Матрица", 10);

        session.bookSeat(1);
        session.bookSeat(2);
        session.bookSeat(3);

        System.out.println("Свободных мест: " + session.getFreeSeatsCount());

        session.bookSeat(2);

        session.cancelBooking(2);

        System.out.println("Свободных мест: " + session.getFreeSeatsCount());

        session.bookSeat(15);
    }
}