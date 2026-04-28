package eci.edu.byteProgramming.ejercicio.paper.util;

import java.util.Date;

/**
 * Implementación concreta de PaymentMethod para Tarjeta de Crédito
 * 
 * Maneja la validación y procesamiento de pagos con tarjeta de crédito.
 * Propiedades específicas: número, nombre, fecha de expiración, CVV.
 */
public class CreditCard extends PaymentMethod {
    private String number;
    private String name;
    private String expirationDate;
    private String cvv;
    private String cardType;
    private String address;
    
    public CreditCard(double amount, String customerId, String description,
                     String number, String name, String expirationDate, String cvv, String address) {
        super(amount, customerId, description);
        this.number = number;
        this.name = name;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.address = address;
        this.cardType = determineCardType(number);
    }

    @Override
    public boolean validatePaymentMethod() {
        return validateCardNumber() && validateCVV() && validateExpirationDate();
    }
    
    private boolean validateCardNumber() {
        return number != null && number.length() >= 13 && number.length() <= 19;
    }
    
    private boolean validateCVV() {
        return cvv != null && cvv.length() >= 3 && cvv.length() <= 4;
    }
    
    private boolean validateExpirationDate() {
        // Formato MM/YY
        return expirationDate != null && expirationDate.matches("\\d{2}/\\d{2}");
    }
    
    @Override
    public boolean processPayment() {
        System.out.println("Processing Credit Card payment...");
        
        if (!validatePaymentMethod()) {
            System.out.println("Credit Card validation failed!");
            setStatus(PaymentStatus.FAILED);
            return false;
        }
        
        setStatus(PaymentStatus.PROCESSING);
        
        try {
            Thread.sleep(1000);
            System.out.println("Credit Card authorized for: " + name);
            System.out.println("Card Type: " + cardType);
            
            setStatus(PaymentStatus.COMPLETED);
            return true;
        } catch (Exception e) {
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "CREDIT_CARD";
    }
    
    private String determineCardType(String cardNumber) {
        if (cardNumber == null || cardNumber.length() == 0) return "UNKNOWN";
        
        char firstDigit = cardNumber.charAt(0);
        switch (firstDigit) {
            case '4': return "VISA";
            case '5': return "MASTERCARD";
            case '3': return "AMEX";
            default: return "OTHER";
        }
    }
    
    // Getters
    public String getNumber() { return number; }
    public String getName() { return name; }
    public String getExpirationDate() { return expirationDate; }
    public String getCvv() { return cvv; }
    public String getCardType() { return cardType; }
    public String getAddress() { return address; }
}
