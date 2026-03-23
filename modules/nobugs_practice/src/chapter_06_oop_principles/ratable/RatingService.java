package chapter_06_oop_principles.ratable;

import java.util.List;

public class RatingService {

    public void filterTopRated(List<Ratable> ratableTop) {
        for (Ratable r : ratableTop) {
            if (r.getRating() > 9.0) {
                System.out.println(r);
            }
        }
    }
}