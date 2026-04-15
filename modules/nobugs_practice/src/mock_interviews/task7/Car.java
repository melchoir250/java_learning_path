package mock_interviews.task7;

public class Car extends TransportAbstract {
    public Car(String transportCompany, String movementTransport) {
        super(transportCompany, movementTransport);
    }

    @Override
    public String movement() {
        return "Машина " + transportCompany + " " + movementTransport;
    }
}