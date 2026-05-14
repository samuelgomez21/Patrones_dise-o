package org.example.rideapp.mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.observer.Conductor;
import org.example.rideapp.observer.Pasajero;
import org.example.rideapp.observer.ViajeEvent;
import org.example.rideapp.observer.ViajeEventType;

public final class CentralViajesMediator implements ViajeMediator {
    private final List<Pasajero> pasajeros = new ArrayList<>();
    private final List<Conductor> conductores = new ArrayList<>();
    private final Map<Viaje, Pasajero> viajesPasajeros = new HashMap<>();
    private final Map<Viaje, Conductor> viajesConductores = new HashMap<>();
    private int indiceConductor = 0;

    @Override
    public void registrarPasajero(Pasajero pasajero) {
        if (pasajero == null) {
            return;
        }
        if (!pasajeros.contains(pasajero)) {
            pasajeros.add(pasajero);
            System.out.println("[Mediator] Pasajero registrado");
        }
    }

    @Override
    public void registrarConductor(Conductor conductor) {
        if (conductor == null) {
            return;
        }
        if (!conductores.contains(conductor)) {
            conductores.add(conductor);
            System.out.println("[Mediator] Conductor registrado");
        }
    }

    @Override
    public void asignarConductor(Viaje viaje, Pasajero pasajero) {
        if (viaje == null || pasajero == null) {
            System.out.println("[Mediator] No se puede asignar conductor sin viaje o pasajero");
            return;
        }
        if (!pasajeros.contains(pasajero)) {
            registrarPasajero(pasajero);
        }

        Conductor conductor = seleccionarConductor();
        if (conductor == null) {
            System.out.println("[Mediator] No hay conductores disponibles");
            return;
        }

        viajesPasajeros.put(viaje, pasajero);
        viajesConductores.put(viaje, conductor);

        System.out.println("[Mediator] Conductor asignado");
        viaje.asignarConductor();
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.ASIGNADO, "Conductor asignado"));
    }

    @Override
    public void enviarMensajeDePasajero(Pasajero pasajero, Viaje viaje, String mensaje) {
        if (pasajero == null || viaje == null || mensaje == null || mensaje.isEmpty()) {
            System.out.println("[Mediator] Mensaje invalido o datos faltantes");
            return;
        }
        Conductor receptor = viajesConductores.get(viaje);
        if (receptor == null) {
            System.out.println("[Mediator] No hay conductor asignado para el viaje");
            return;
        }
        System.out.println("[Mediator] Enrutando mensaje de pasajero a conductor");
        receptor.recibirMensaje("Pasajero: " + mensaje);
    }

    @Override
    public void enviarMensajeDeConductor(Conductor conductor, Viaje viaje, String mensaje) {
        if (conductor == null || viaje == null || mensaje == null || mensaje.isEmpty()) {
            System.out.println("[Mediator] Mensaje invalido o datos faltantes");
            return;
        }
        Pasajero receptor = viajesPasajeros.get(viaje);
        if (receptor == null) {
            System.out.println("[Mediator] No hay pasajero asignado para el viaje");
            return;
        }
        System.out.println("[Mediator] Enrutando mensaje de conductor a pasajero");
        receptor.recibirMensaje("Conductor: " + mensaje);
    }

    private Conductor seleccionarConductor() {
        if (conductores.isEmpty()) {
            return null;
        }
        if (indiceConductor >= conductores.size()) {
            indiceConductor = 0;
        }
        Conductor conductor = conductores.get(indiceConductor);
        indiceConductor = (indiceConductor + 1) % conductores.size();
        return conductor;
    }
}
