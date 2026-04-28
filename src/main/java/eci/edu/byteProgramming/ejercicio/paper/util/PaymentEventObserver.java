package eci.edu.byteProgramming.ejercicio.paper.util;

/**
 * ⚠️ DEPRECATED - Esta clase ha sido reemplazada y no debe ser utilizada.
 * 
 * Anteriormente, esta clase combinaba la lógica de todos los observadores en una sola clase.
 * Ahora, cada componente implementa directamente PaymentObserver:
 * 
 * - Inventory.java → Implementa PaymentObserver y descuenta del stock
 * - Facturation.java → Implementa PaymentObserver y genera facturas
 * - Notification.java → Implementa PaymentObserver y envía emails
 * 
 * Esta separación sigue el patrón Observer correctamente y es más mantenible.
 * 
 * @deprecated Use Inventory, Facturation, and Notification observers directly instead
 */
@Deprecated
public class PaymentEventObserver {
    // DEPRECATED - No utilizar
}
