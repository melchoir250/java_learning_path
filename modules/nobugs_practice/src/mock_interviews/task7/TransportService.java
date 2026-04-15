package mock_interviews.task7;

import java.util.List;

public class TransportService {
    public List<Transport> transports;

    public TransportService(List<Transport> transports) {
        this.transports = transports;
    }

    public void addTransport() {
        for (Transport item : transports) {
            System.out.println(item.movement());
        }
    }
}