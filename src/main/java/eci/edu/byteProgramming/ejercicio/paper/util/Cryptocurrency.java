package eci.edu.byteProgramming.ejercicio.paper.util;

import java.util.Date;

/**
 * Implementación concreta de PaymentMethod para Criptomonedas
 * 
 * Maneja la validación y procesamiento de pagos con criptomonedas.
 * Propiedades específicas: dirección de billetera, tipo de cripto, saldo.
 */
public class Cryptocurrency extends PaymentMethod {
    private String walletAddress;
    private String cryptoType;
    private String token;
    private double walletBalance;
    private String blockchainHash;
    
    public Cryptocurrency(double amount, String customerId, String description,
                         String walletAddress, String cryptoType, double walletBalance) {
        super(amount, customerId, description);
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
        this.token = token;
        this.walletBalance = walletBalance;
    }
    
    @Override
    public boolean validatePaymentMethod() {
        return validateWalletAddress() && validateBalance();
    }
    
    private boolean validateWalletAddress() {
        return walletAddress != null && walletAddress.length() >= 26;
    }
    
    private boolean validateBalance() {
        return walletBalance >= amount;
    }
    
    @Override
    public boolean processPayment() {
        System.out.println("Processing Cryptocurrency payment...");
        
        if (!validatePaymentMethod()) {
            System.out.println("Crypto validation failed!");
            setStatus(PaymentStatus.FAILED);
            return false;
        }
        
        setStatus(PaymentStatus.PROCESSING);
        
        try {
            Thread.sleep(3000);
            this.blockchainHash = generateBlockchainHash();
            System.out.println("Transaction broadcasted to blockchain");
            System.out.println("Blockchain hash: " + blockchainHash);
            
            setStatus(PaymentStatus.COMPLETED);
            return true;
        } catch (Exception e) {
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "CRYPTOCURRENCY";
    }
    
    private String generateBlockchainHash() {
        return "0x" + Integer.toHexString((int)(Math.random() * Integer.MAX_VALUE));
    }
    
    // Getters
    public String getWalletAddress() { return walletAddress; }
    public String getCryptoType() { return cryptoType; }
    public String getBlockchainHash() { return blockchainHash; }
    public double getWalletBalance() { return walletBalance; }
}
