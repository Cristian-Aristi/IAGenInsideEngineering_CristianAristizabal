package eci.edu.byteProgramming.ejercicio.paper.util;

/**
 * Abstract Factory Pattern - Factory Interface
 * 
 * Define el contrato para crear familias de objetos relacionados.
 * Cada implementación concreta es responsable de crear un PaymentMethod específico
 * con su correspondiente validación.
 */
public interface PaymentFactory {
    
    /**
     * Crea un método de pago concreto basado en los parámetros proporcionados
     * 
     * @param amount Monto a pagar
     * @param customerId ID del cliente
     * @param description Descripción del pago
     * @return PaymentMethod concreto (CreditCard, PayPal o Cryptocurrency)
     */
    PaymentMethod createPaymentMethod(double amount, String customerId, String description);
    
    /**
     * Retorna el tipo de método de pago que esta factory crea
     * @return String con el nombre del método de pago
     */
    String getPaymentMethodType();
}
