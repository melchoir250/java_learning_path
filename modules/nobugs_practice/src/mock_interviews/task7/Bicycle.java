package mock_interviews.task7;

public class Bicycle extends TransportAbstract {
    public Bicycle(String transportCompany, String movementTransport) {
        super(transportCompany, movementTransport);
    }

    @Override
    public String movement() {
        return "Велосипед " + transportCompany + " " + movementTransport;
    }
}