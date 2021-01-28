package simone.billings.enums;

public enum PaymentType {
    CB("Visa/Mastercard"),
    PAYPAL("Paypal"),
    BANKTRANSFER("Virement bancaire");

    PaymentType(String billingType) {

    }
}
