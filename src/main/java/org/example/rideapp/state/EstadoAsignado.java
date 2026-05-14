package org.example.rideapp.state;

/**
 * Estado Asignado: El viaje tiene conductor asignado, pero aún no ha iniciado.
 * Acciones permitidas: iniciarViaje(), cancelar()
 */
public final class EstadoAsignado implements EstadoViaje {

    private static final EstadoAsignado INSTANCE = new EstadoAsignado();

    private EstadoAsignado() {
        // Singleton privado
    }

    public static EstadoAsignado getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoViaje iniciarViaje() {
        System.out.println("[State] Transición: Asignado -> EnCamino");
        return EstadoEnCamino.getInstance();
    }

    @Override
    public EstadoViaje finalizar() {
        System.out.println("[State] No se puede finalizar viaje desde estado Asignado");
        throw new IllegalStateException("No se puede finalizar viaje en estado Asignado");
    }

    @Override
    public EstadoViaje cancelar() {
        System.out.println("[State] Transición: Asignado -> Cancelado");
        return EstadoCancelado.getInstance();
    }

    @Override
    public String getNombre() {
        return "Asignado";
    }

    @Override
    public String toString() {
        return "EstadoAsignado{}";
    }
}

