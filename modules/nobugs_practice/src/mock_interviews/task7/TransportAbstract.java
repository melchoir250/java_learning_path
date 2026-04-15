package mock_interviews.task7;

public abstract class TransportAbstract implements Transport {
    protected String transportCompany;
    protected String movementTransport;

    public TransportAbstract(String transportCompany, String movementTransport) {
        this.transportCompany = transportCompany;
        this.movementTransport = movementTransport;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public String getMovementTransport() {
        return movementTransport;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany;
    }

    public void setMovementTransport(String movementTransport) {
        this.movementTransport = movementTransport;
    }
}