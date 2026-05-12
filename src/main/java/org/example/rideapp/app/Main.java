package org.example.rideapp.app;

import org.example.rideapp.builder.ViajeBuilder;
import org.example.rideapp.model.Viaje;
import org.example.rideapp.observer.Conductor;
import org.example.rideapp.observer.Pasajero;
import org.example.rideapp.observer.UIObserver;
import org.example.rideapp.observer.ViajeEvent;
import org.example.rideapp.observer.ViajeEventType;

public final class Main {
    public static void main(String[] args) {
        System.out.println("[RideApp] Solicitud recibida");

        Viaje viaje = new ViajeBuilder()
                .setTipo("premium")
                .setWifi(true)
                .setMascota(false)
                .setEquipaje(true)
                .setAireAcondicionado(true)
                .setMusica(true)
                .setNumeroPasajeros(2)
                .build();

        viaje.addObserver(new Pasajero("Ana"));
        viaje.addObserver(new Conductor("Luis"));
        viaje.addObserver(new UIObserver());

        viaje.notifyObservers(new ViajeEvent(ViajeEventType.SOLICITADO, "Viaje solicitado"));
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.ASIGNADO, "Conductor asignado"));
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.INICIADO, "Viaje iniciado"));
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.FINALIZADO, "Viaje finalizado"));

        System.out.println("[State] Estado actual: Finalizado");
    }
}

