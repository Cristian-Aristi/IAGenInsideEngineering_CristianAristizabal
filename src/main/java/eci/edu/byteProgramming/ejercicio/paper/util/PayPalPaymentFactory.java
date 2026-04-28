package eci.edu.byteProgramming.ejercicio.paper.util;

/**
 * Implementación concreta de PaymentFactory para PayPal
 * 
 * Responsable de crear instancias de PayPal con sus parámetros específicos.
 * Encapsula la lógica de creación del método de pago de PayPal.
 */
public class PayPalPaymentFactory implements PaymentFactory {
    private String email;
    private String authToken;
    
    /**
     * Constructor que configura los detalles de la cuenta PayPal
     */
    public PayPalPaymentFactory(String email, String authToken) {
        this.email = email;
        this.authToken = authToken;
    }
    
    @Override
    public PaymentMethod createPaymentMethod(double amount, String customerId, String description) {
        return new PayPal(amount, customerId, description, email, authToken);
    }
    
    @Override
    public String getPaymentMethodType() {
        return "PAYPAL";
    }
}
