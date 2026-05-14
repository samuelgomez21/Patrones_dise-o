package org.example.rideapp.state;

/**
 * Interfaz que define el contrato para todos los estados posibles de un viaje.
 * Cada estado encapsula su propio comportamiento y transiciones.
 */
public interface EstadoViaje {

    /**
     * Inicia el viaje. Solo disponible en estado Asignado.
     * @return nuevo estado después de la transición
     */
    EstadoViaje iniciarViaje();

    /**
     * Finaliza el viaje. Solo disponible en estado EnCamino.
     * @return nuevo estado después de la transición
     */
    EstadoViaje finalizar();

    /**
     * Cancela el viaje. Disponible en estados Solicitado y Asignado.
     * @return nuevo estado después de la transición
     */
    EstadoViaje cancelar();

    /**
     * Retorna el nombre descriptivo del estado.
     * @return nombre del estado
     */
    String getNombre();
}

