package task_10_miles_km_adapter;

public class Miles implements Distance {
    private final double value;

    public Miles(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getUnit() {
        return "miles";
    }
}
