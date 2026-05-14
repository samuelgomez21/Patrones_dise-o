package org.example.rideapp.app;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.observer.Conductor;
import org.example.rideapp.observer.Pasajero;
import org.example.rideapp.observer.UIObserver;
import org.example.rideapp.observer.ViajeEvent;
import org.example.rideapp.observer.ViajeEventType;

public final class Main {
    public static void main(String[] args) {
        // Demostración del Singleton RideApp
        System.out.println("\n========== DEMO SINGLETON ==========");
        RideApp rideApp = RideApp.getInstance();
        System.out.println(rideApp);

        // Verificar que es la misma instancia
        RideApp rideApp2 = RideApp.getInstance();
        System.out.println("¿Son la misma instancia? " + (rideApp == rideApp2));

        // Crear viaje usando el Singleton
        System.out.println("\n========== DEMO STATE + OBSERVER ==========");
        Viaje viaje = rideApp.solicitarViaje(
                "premium",
                true,
                false,
                true,
                true,
                true,
                2
        );

        // Agregar observadores
        viaje.addObserver(new Pasajero("Ana"));
        viaje.addObserver(new Conductor("Luis"));
        viaje.addObserver(new UIObserver());

        // Ciclo de vida del viaje con Observer y State
        System.out.println("\n--- Evento: Viaje Solicitado ---");
        System.out.println("[State] Estado actual: " + viaje.getEstadoNombre());
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.SOLICITADO, "Viaje solicitado en estado: " + viaje.getEstadoNombre()));

        // Transición a Asignado (asignando conductor)
        System.out.println("\n--- Evento: Viaje Asignado ---");
        viaje.asignarConductor();
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.ASIGNADO, "Conductor Luis asignado"));

        // Iniciar viaje (transición mediante State)
        System.out.println("\n--- Transición State: Asignado -> EnCamino ---");
        viaje.iniciarViaje();
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.INICIADO, "Viaje iniciado en estado: " + viaje.getEstadoNombre()));

        // Finalizar viaje (transición mediante State)
        System.out.println("\n--- Transición State: EnCamino -> Finalizado ---");
        viaje.finalizarViaje();
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.FINALIZADO, "Viaje finalizado en estado: " + viaje.getEstadoNombre()));

        // Intentar operación inválida (debe fallar)
        System.out.println("\n--- Intento inválido: iniciar viaje ya finalizado ---");
        viaje.iniciarViaje();

        // Estadísticas finales
        System.out.println("\n========== ESTADÍSTICAS FINALES ==========");
        System.out.println(rideApp);
        System.out.println("Total de viajes en sistema: " + rideApp.getTotalViajes());
    }
}

