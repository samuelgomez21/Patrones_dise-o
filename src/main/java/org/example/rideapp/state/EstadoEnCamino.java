package org.example.rideapp.state;

/**
 * Estado EnCamino: El viaje está en curso.
 * Acciones permitidas: finalizar()
 */
public final class EstadoEnCamino implements EstadoViaje {

    private static final EstadoEnCamino INSTANCE = new EstadoEnCamino();

    private EstadoEnCamino() {
        // Singleton privado
    }

    public static EstadoEnCamino getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoViaje iniciarViaje() {
        System.out.println("[State] No se puede iniciar viaje desde estado EnCamino");
        throw new IllegalStateException("No se puede iniciar viaje en estado EnCamino");
    }

    @Override
    public EstadoViaje finalizar() {
        System.out.println("[State] Transición: EnCamino -> Finalizado");
        return EstadoFinalizado.getInstance();
    }

    @Override
    public EstadoViaje cancelar() {
        System.out.println("[State] No se puede cancelar viaje desde estado EnCamino");
        throw new IllegalStateException("No se puede cancelar viaje en estado EnCamino");
    }

    @Override
    public String getNombre() {
        return "EnCamino";
    }

    @Override
    public String toString() {
        return "EstadoEnCamino{}";
    }
}

