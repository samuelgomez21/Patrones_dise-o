package org.example.rideapp.observer;

public final class Pasajero implements Observer {
    private final String nombre;

    public Pasajero(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(ViajeEvent event) {
        System.out.println("[Observer] Pasajero " + nombre + " notificado: " + event.getMessage());
    }
}

