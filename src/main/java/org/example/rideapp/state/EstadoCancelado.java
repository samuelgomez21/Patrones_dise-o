package org.example.rideapp.state;

/**
 * Estado Cancelado: El viaje ha sido cancelado.
 * Acciones permitidas: ninguna
 */
public final class EstadoCancelado implements EstadoViaje {

    private static final EstadoCancelado INSTANCE = new EstadoCancelado();

    private EstadoCancelado() {
        // Singleton privado
    }

    public static EstadoCancelado getInstance() {
        return INSTANCE;
    }

    @Override
    public EstadoViaje iniciarViaje() {
        System.out.println("[State] No se puede iniciar viaje desde estado Cancelado");
        throw new IllegalStateException("No se puede iniciar viaje en estado Cancelado");
    }

    @Override
    public EstadoViaje finalizar() {
        System.out.println("[State] No se puede finalizar viaje desde estado Cancelado");
        throw new IllegalStateException("No se puede finalizar viaje en estado Cancelado");
    }

    @Override
    public EstadoViaje cancelar() {
        System.out.println("[State] No se puede cancelar viaje desde estado Cancelado");
        throw new IllegalStateException("No se puede cancelar viaje en estado Cancelado");
    }

    @Override
    public String getNombre() {
        return "Cancelado";
    }

    @Override
    public String toString() {
        return "EstadoCancelado{}";
    }
}

