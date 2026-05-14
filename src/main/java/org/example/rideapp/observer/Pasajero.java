package org.example.rideapp.observer;

import org.example.rideapp.mediator.ViajeMediator;
import org.example.rideapp.model.Viaje;

public final class Pasajero implements Observer {
    private final String nombre;
    private ViajeMediator mediator;

    public Pasajero(String nombre) {
        this.nombre = nombre;
    }

    public void setMediator(ViajeMediator mediator) {
        this.mediator = mediator;
    }

    public void solicitarConductor(Viaje viaje) {
        if (mediator == null) {
            System.out.println("[Mediator] Pasajero " + nombre + " sin mediador asignado");
            return;
        }
        mediator.asignarConductor(viaje, this);
    }

    public void enviarMensaje(Viaje viaje, String mensaje) {
        if (mediator == null) {
            System.out.println("[Mediator] Pasajero " + nombre + " sin mediador asignado");
            return;
        }
        mediator.enviarMensajeDePasajero(this, viaje, mensaje);
    }

    public void recibirMensaje(String mensaje) {
        System.out.println("[Mediator] Pasajero " + nombre + " recibe: " + mensaje);
    }

    @Override
    public void update(ViajeEvent event) {
        System.out.println("[Observer] Pasajero " + nombre + " notificado: " + event.getMessage());
    }
}

