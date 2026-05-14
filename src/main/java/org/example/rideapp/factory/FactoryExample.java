package org.example.rideapp.factory;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.observer.Conductor;
import org.example.rideapp.observer.Pasajero;
import org.example.rideapp.observer.UIObserver;
import org.example.rideapp.observer.ViajeEvent;
import org.example.rideapp.observer.ViajeEventType;


public final class FactoryExample {
    public static void main(String[] args) {
        System.out.println("=== RideApp - Factory Pattern Demo ===\n");

        // Crear viaje económico
        System.out.println("1. Creando viaje económico:");
        Viaje viajeEconomico = ViajeFactory.crearViaje("economico");
        viajeEconomico.addObserver(new Pasajero("Carlos"));
        viajeEconomico.addObserver(new Conductor("Juan"));
        viajeEconomico.notifyObservers(new ViajeEvent(ViajeEventType.SOLICITADO, "Viaje económico solicitado"));
        System.out.println();

        // Crear viaje premium con parámetros
        System.out.println("2. Creando viaje premium con WiFi y aire acondicionado:");
        Viaje viajePremium = ViajeFactory.crearViaje("premium", true, false, true, true, true, 2);
        viajePremium.addObserver(new Pasajero("María"));
        viajePremium.addObserver(new UIObserver());
        viajePremium.notifyObservers(new ViajeEvent(ViajeEventType.SOLICITADO, "Viaje premium solicitado"));
        System.out.println();

        // Crear viaje moto
        System.out.println("3. Creando viaje moto:");
        Viaje viajeMoto = ViajeFactory.crearViaje("moto");
        viajeMoto.addObserver(new Pasajero("Roberto"));
        viajeMoto.notifyObservers(new ViajeEvent(ViajeEventType.INICIADO, "Viaje en moto iniciado"));
        System.out.println();

        // Crear viaje compartido
        System.out.println("4. Creando viaje compartido:");
        Viaje viajeCompartido = ViajeFactory.crearViaje("compartido", false, true, true, false, false, 4);
        viajeCompartido.addObserver(new Pasajero("Sofia"));
        viajeCompartido.addObserver(new Conductor("Diego"));
        viajeCompartido.addObserver(new UIObserver());
        viajeCompartido.notifyObservers(new ViajeEvent(ViajeEventType.FINALIZADO, "Viaje compartido finalizado"));
        System.out.println();

        System.out.println("=== Demo completada ===");
    }
}

