package simone.front.model;

public enum VehicleType {
    CAR("Voiture"),
    TWO_WHEELED("deux roues"),
    COMMERCIAL_VEHICLE("Utilitaire");



    private final String displayValue;

    private VehicleType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
