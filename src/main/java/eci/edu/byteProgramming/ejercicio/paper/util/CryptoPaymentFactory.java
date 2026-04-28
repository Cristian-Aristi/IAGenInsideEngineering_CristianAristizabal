package eci.edu.byteProgramming.ejercicio.paper.util;

/**
 * Implementación concreta de PaymentFactory para Criptomonedas
 * 
 * Responsable de crear instancias de Cryptocurrency con sus parámetros específicos.
 * Encapsula la lógica de creación del método de pago con criptomonedas.
 */
public class CryptoPaymentFactory implements PaymentFactory {
    private String walletAddress;
    private String cryptoType;
    private double walletBalance;
    
    /**
     * Constructor que configura los detalles de la billetera de criptomonedas
     */
    public CryptoPaymentFactory(String walletAddress, String cryptoType, double walletBalance) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
        this.walletBalance = walletBalance;
    }
    
    @Override
    public PaymentMethod createPaymentMethod(double amount, String customerId, String description) {
        return new Cryptocurrency(amount, customerId, description, 
                                 walletAddress, cryptoType, walletBalance);
    }
    
    @Override
    public String getPaymentMethodType() {
        return "CRYPTOCURRENCY";
    }
}
