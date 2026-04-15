package mock_interviews.task7;

public class Airplane extends TransportAbstract {
    public Airplane(String transportCompany, String movementTransport) {
        super(transportCompany, movementTransport);
    }

    @Override
    public String movement() {
        return "Самолёт " + transportCompany + " " + movementTransport;
    }
}