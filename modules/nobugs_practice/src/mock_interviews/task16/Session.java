package mock_interviews.task16;

import java.util.HashSet;
import java.util.Set;

public class Session {
    private final String movieTitle;
    private final int totalSets;
    private final Set<Integer> occupiedSeats;

    public Session(String movieTitle, int totalSets) {
        this.movieTitle = movieTitle;
        this.totalSets = totalSets;
        this.occupiedSeats = new HashSet<>();
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    private boolean isValidSeat(int seatNumber) {
        return seatNumber > 0 && seatNumber <= totalSets;
    }

    public void bookSeat(int seatNumber) {
        if (!isValidSeat(seatNumber)) {
            System.out.println(seatNumber + " данного места не существует в зале");
            return;
        }
        if (this.occupiedSeats.add(seatNumber)) {
            System.out.println("Место " + seatNumber + " забронировано");
        } else {
            System.out.println("Место " + seatNumber + " занято");
        }
    }

    public void cancelBooking(int seatNumber) {
        if (!isValidSeat(seatNumber)) {
            System.out.println(seatNumber + "данного места не существует в зале");
            return;
        }
        if (this.occupiedSeats.remove(seatNumber)) {
            System.out.println("Бронирование места " + seatNumber + " отменено");
        } else {
            System.out.println("Место " + seatNumber + " не было забронировано");
        }
    }

    public boolean isSeatOccupited(int seatNumber) {
        if (!isValidSeat(seatNumber)) {
            System.out.println(seatNumber + "данного места не существует в зале");
            return false;
        }
        return this.occupiedSeats.contains(seatNumber);
    }

    public int getFreeSeatsCount() {
        return totalSets - this.occupiedSeats.size();
    }
}