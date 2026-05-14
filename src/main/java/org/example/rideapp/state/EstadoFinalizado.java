package org.example.rideapp.state;

/**
 * Estado Finalizado: El viaje ha terminado correctamente.
 * Acciones permitidas: ninguna
 */
public final class EstadoFinalizado implements EstadoViaje {

    private static final EstadoFinalizado INSTANCE = new EstadoFinalizado();

    private EstadoFinalizado() {
        // Singleton privado
    }

    public static EstadoFinalizado getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoViaje iniciarViaje() {
        System.out.println("[State] No se puede iniciar viaje desde estado Finalizado");
        throw new IllegalStateException("No se puede iniciar viaje en estado Finalizado");
    }

    @Override
    public EstadoViaje finalizar() {
        System.out.println("[State] No se puede finalizar viaje desde estado Finalizado");
        throw new IllegalStateException("No se puede finalizar viaje en estado Finalizado");
    }

    @Override
    public EstadoViaje cancelar() {
        System.out.println("[State] No se puede cancelar viaje desde estado Finalizado");
        throw new IllegalStateException("No se puede cancelar viaje en estado Finalizado");
    }

    @Override
    public String getNombre() {
        return "Finalizado";
    }

    @Override
    public String toString() {
        return "EstadoFinalizado{}";
    }
}

