package org.example.rideapp.state;

/**
 * Estado Solicitado: El viaje ha sido solicitado pero aún no tiene conductor asignado.
 * Acciones permitidas: cancelar()
 */
public final class EstadoSolicitado implements EstadoViaje {

    private static final EstadoSolicitado INSTANCE = new EstadoSolicitado();

    private EstadoSolicitado() {
        // Singleton privado
    }

    public static EstadoSolicitado getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoViaje iniciarViaje() {
        System.out.println("[State] No se puede iniciar viaje desde estado Solicitado");
        throw new IllegalStateException("No se puede iniciar viaje en estado Solicitado");
    }

    @Override
    public EstadoViaje finalizar() {
        System.out.println("[State] No se puede finalizar viaje desde estado Solicitado");
        throw new IllegalStateException("No se puede finalizar viaje en estado Solicitado");
    }

    @Override
    public EstadoViaje cancelar() {
        System.out.println("[State] Transición: Solicitado -> Cancelado");
        return EstadoCancelado.getInstance();
    }

    @Override
    public String getNombre() {
        return "Solicitado";
    }

    @Override
    public String toString() {
        return "EstadoSolicitado{}";
    }
}

