package org.example.rideapp.observer;

public final class UIObserver implements Observer {
    @Override
    public void update(ViajeEvent event) {
        System.out.println("[Observer] UI notificada: " + event.getMessage());
    }
}

