package task_10_miles_km_adapter;

public class MilesToKilometersAdapter implements Distance {
    private static final double MILES_TO_KM = 1.60934;

    private final Miles miles;

    public MilesToKilometersAdapter(Miles miles) {
        this.miles = miles;
    }

    @Override
    public double getValue() {
        return miles.getValue() * MILES_TO_KM;
    }

    @Override
    public String getUnit() {
        return "km";
    }
}
