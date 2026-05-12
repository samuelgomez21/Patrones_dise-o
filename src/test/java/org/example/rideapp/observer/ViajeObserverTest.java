package org.example.rideapp.observer;

import org.example.rideapp.builder.ViajeBuilder;
import org.example.rideapp.model.Viaje;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViajeObserverTest {
    @Test
    void notificaATodosLosObservadores() {
        Viaje viaje = new ViajeBuilder().setTipo("economico").build();
        AtomicInteger contador = new AtomicInteger();

        Observer observer = event -> contador.incrementAndGet();
        viaje.addObserver(observer);
        viaje.addObserver(observer); // Debe ignorar duplicados.

        viaje.notifyObservers(new ViajeEvent(ViajeEventType.SOLICITADO, "Viaje solicitado"));
        viaje.notifyObservers(new ViajeEvent(ViajeEventType.FINALIZADO, "Viaje finalizado"));

        assertEquals(2, contador.get());
    }
}

