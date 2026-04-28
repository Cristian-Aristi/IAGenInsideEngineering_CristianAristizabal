package eci.edu.byteProgramming.ejercicio.paper.util;

/**
 * Implementación concreta de PaymentFactory para Tarjeta de Crédito
 * 
 * Responsable de crear instancias de CreditCard con sus parámetros específicos.
 * Encapsula la lógica de creación del método de pago de tarjeta de crédito.
 */
public class CreditCardPaymentFactory implements PaymentFactory {
    private String cardNumber;
    private String cardholderName;
    private String expirationDate;
    private String cvv;
    private String address;
    
    /**
     * Constructor que configura los detalles de la tarjeta de crédito
     */
    public CreditCardPaymentFactory(String cardNumber, String cardholderName, 
                                   String expirationDate, String cvv, String address) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.address = address;
    }
    
    @Override
    public PaymentMethod createPaymentMethod(double amount, String customerId, String description) {
        return new CreditCard(amount, customerId, description, 
                             cardNumber, cardholderName, expirationDate, cvv, address);
    }
    
    @Override
    public String getPaymentMethodType() {
        return "CREDIT_CARD";
    }
}
