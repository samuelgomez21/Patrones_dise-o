package org.example.rideapp.observer;

public final class Conductor implements Observer {
    private final String nombre;

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(ViajeEvent event) {
        System.out.println("[Observer] Conductor " + nombre + " notificado: " + event.getMessage());
    }
}

