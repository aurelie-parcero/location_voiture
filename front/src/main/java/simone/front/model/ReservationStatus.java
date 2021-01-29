package simone.front.model;

public enum ReservationStatus {
    WAITING_CONFIRM("attente validation"),
    ON_GOING("en cours"),
    CLOSED("cloturé");

    ReservationStatus(String reservationStatus) {

    }
}
