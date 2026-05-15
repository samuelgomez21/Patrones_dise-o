package org.example.rideapp.app;

import org.example.rideapp.mediator.CentralViajesMediator;
import org.example.rideapp.model.Viaje;
import org.example.rideapp.observer.Conductor;
import org.example.rideapp.observer.Pasajero;
import org.example.rideapp.observer.UIObserver;
import org.example.rideapp.observer.ViajeEvent;
import org.example.rideapp.observer.ViajeEventType;

public final class Main {
    public static void main(String[] args) {
        System.out.println("\n========== FLUJO OBLIGATORIO: RideApp - Factory - Builder - Mediator - Observer - State ==========\n");

        // Paso 1: Pasajero solicita viaje
        System.out.println("PASO 1: Pasajero solicita viaje");
        Pasajero pasajero = new Pasajero("Ana");
        System.out.println();

        // Paso 2: RideApp recibe solicitud
        System.out.println("PASO 2: RideApp recibe solicitud");
        RideApp rideApp = RideApp.getInstance();
        System.out.println();

        // Paso 3: Factory crea el tipo de viaje
        // Paso 4: Builder configura opciones
        System.out.println("PASO 3: Factory crea el tipo de viaje");
        System.out.println("PASO 4: Builder configura opciones");
        Viaje viaje = rideApp.solicitarViaje(
                "premium",
                true,      // wifi
                true,      // mascota
                true,      // aireAcondicionado
                true,      // equipaje
                true,      // musica
                2          // numeroPasajeros
        );
        System.out.println();

        // Configurar Mediator
        CentralViajesMediator mediator = new CentralViajesMediator();
        pasajero.setMediator(mediator);
        mediator.registrarPasajero(pasajero);

        // Crear conductor
        Conductor conductor = new Conductor("Luis");
        conductor.setMediator(mediator);
        mediator.registrarConductor(conductor);

        // Registrar observadores
        viaje.addObserver(pasajero);
        viaje.addObserver(conductor);
        viaje.addObserver(new UIObserver());

        // Paso 5: Mediator asigna conductor
        System.out.println("PASO 5: Mediator asigna conductor");
        pasajero.solicitarConductor(viaje);
        System.out.println();

        // Paso 6: Observer notifica asignación
        System.out.println("PASO 6: Observer notifica asignación");
        System.out.println();

        // Paso 7: Viaje cambia a estado Asignado
        System.out.println("PASO 7: Viaje cambia a estado Asignado - Estado: " + viaje.getEstadoNombre());
        System.out.println();

        // Comunicación entre pasajero y conductor
        pasajero.enviarMensaje(viaje, "Estoy en la entrada del edificio");
        conductor.enviarMensaje(viaje, "Ya estoy cerca, 2 minutos");
        System.out.println();

        // Paso 8: Viaje inicia
        System.out.println("PASO 8: Viaje inicia");
        viaje.iniciarViaje();

        // Paso 9: Observer notifica inicio
        System.out.println("PASO 9: Observer notifica inicio");
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.INICIADO, "Viaje iniciado - Conductor Luis en camino"));
        System.out.println();

        // Paso 10: Viaje cambia a EnCamino (via State Pattern)
        System.out.println("PASO 10: Viaje cambia a EnCamino - Estado: " + viaje.getEstadoNombre());
        System.out.println();

        // Paso 11: Viaje finaliza
        System.out.println("PASO 11: Viaje finaliza");
        viaje.finalizarViaje();

        // Paso 12: Observer notifica finalización
        System.out.println("PASO 12: Observer notifica finalización");
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.FINALIZADO, "Viaje completado exitosamente"));
        System.out.println();

        // Paso 13: Estado final = Finalizado
        System.out.println("PASO 13: Estado final = Finalizado - Estado: " + viaje.getEstadoNombre());
        System.out.println();

        System.out.println("========== RESUMEN FINAL ==========");
        System.out.println("Tipo de viaje: " + viaje.getTipo());
        System.out.println("Estado: " + viaje.getEstadoNombre());
        System.out.println("Total de viajes en sistema: " + rideApp.getTotalViajes());
        System.out.println("=====================================\n");
    }
}

