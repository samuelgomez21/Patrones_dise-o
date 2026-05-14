package org.example.rideapp.observer;

import org.example.rideapp.mediator.ViajeMediator;
import org.example.rideapp.model.Viaje;

public final class Conductor implements Observer {
    private final String nombre;
    private ViajeMediator mediator;

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public void setMediator(ViajeMediator mediator) {
        this.mediator = mediator;
    }

    public void enviarMensaje(Viaje viaje, String mensaje) {
        if (mediator == null) {
            System.out.println("[Mediator] Conductor " + nombre + " sin mediador asignado");
            return;
        }
        mediator.enviarMensajeDeConductor(this, viaje, mensaje);
    }

    public void recibirMensaje(String mensaje) {
        System.out.println("[Mediator] Conductor " + nombre + " recibe: " + mensaje);
    }

    @Override
    public void update(ViajeEvent event) {
        System.out.println("[Observer] Conductor " + nombre + " notificado: " + event.getMessage());
    }
}

