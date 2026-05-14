package org.example.rideapp.mediator;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.observer.Conductor;
import org.example.rideapp.observer.Pasajero;

public interface ViajeMediator {
    void registrarPasajero(Pasajero pasajero);
    void registrarConductor(Conductor conductor);
    void asignarConductor(Viaje viaje, Pasajero pasajero);
    void enviarMensajeDePasajero(Pasajero pasajero, Viaje viaje, String mensaje);
    void enviarMensajeDeConductor(Conductor conductor, Viaje viaje, String mensaje);
}
