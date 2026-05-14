package org.example.rideapp.model;

import org.example.rideapp.observer.Observer;
import org.example.rideapp.observer.Subject;
import org.example.rideapp.observer.ViajeEvent;
import org.example.rideapp.state.EstadoViaje;
import org.example.rideapp.state.EstadoSolicitado;
import org.example.rideapp.state.EstadoAsignado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Viaje implements Subject {
    private final String tipo;
    private final boolean wifi;
    private final boolean mascota;
    private final boolean aireAcondicionado;
    private final boolean equipaje;
    private final boolean musica;
    private final int numeroPasajeros;

    private final List<Observer> observers = new ArrayList<>();

    /**
     * Estado actual del viaje. Inicializa en Solicitado.
     * Gestiona el ciclo de vida del viaje usando State Pattern.
     */
    private EstadoViaje estadoActual;

    private Viaje(
            String tipo,
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        this.tipo = tipo;
        this.wifi = wifi;
        this.mascota = mascota;
        this.aireAcondicionado = aireAcondicionado;
        this.equipaje = equipaje;
        this.musica = musica;
        this.numeroPasajeros = numeroPasajeros;
        this.estadoActual = EstadoSolicitado.getInstance();
        System.out.println("[State] Estado actual: " + estadoActual.getNombre());
    }

    public static Viaje create(
            String tipo,
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        return new Viaje(tipo, wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
    }

    public String getTipo() {
        return tipo;
    }

    public boolean hasWifi() {
        return wifi;
    }

    public boolean hasMascota() {
        return mascota;
    }

    public boolean hasAireAcondicionado() {
        return aireAcondicionado;
    }

    public boolean hasEquipaje() {
        return equipaje;
    }

    public boolean hasMusica() {
        return musica;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(ViajeEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    // ========== MÉTODOS PARA GESTIONAR EL CICLO DE VIDA DEL VIAJE (STATE PATTERN) ==========

    /**
     * Obtiene el estado actual del viaje.
     * @return estado actual
     */
    public EstadoViaje getEstadoActual() {
        return estadoActual;
    }

    /**
     * Obtiene el nombre del estado actual.
     * @return nombre del estado
     */
    public String getEstadoNombre() {
        return estadoActual.getNombre();
    }

    /**
     * Asigna el viaje a un conductor (transición a estado Asignado).
     * Solo permitido si está en estado Solicitado.
     */
    public void asignarConductor() {
        System.out.println("[State] Intento de asignación de conductor en estado: " + estadoActual.getNombre());
        if ("Solicitado".equals(estadoActual.getNombre())) {
            estadoActual = EstadoAsignado.getInstance();
            System.out.println("[State] Transición: Solicitado -> Asignado");
            System.out.println("[State] Estado actual: " + estadoActual.getNombre());
        } else {
            System.out.println("[State] No se puede asignar conductor en estado: " + estadoActual.getNombre());
        }
    }

    /**
     * Inicia el viaje (transición a estado EnCamino).
     * Solo permitido si está en estado Asignado.
     */
    public void iniciarViaje() {
        System.out.println("[State] Intento de iniciar viaje en estado: " + estadoActual.getNombre());
        try {
            estadoActual = estadoActual.iniciarViaje();
            System.out.println("[State] Estado actual: " + estadoActual.getNombre());
        } catch (IllegalStateException e) {
            System.out.println("[State] Error: " + e.getMessage());
        }
    }

    /**
     * Finaliza el viaje (transición a estado Finalizado).
     * Solo permitido si está en estado EnCamino.
     */
    public void finalizarViaje() {
        System.out.println("[State] Intento de finalizar viaje en estado: " + estadoActual.getNombre());
        try {
            estadoActual = estadoActual.finalizar();
            System.out.println("[State] Estado actual: " + estadoActual.getNombre());
        } catch (IllegalStateException e) {
            System.out.println("[State] Error: " + e.getMessage());
        }
    }

    /**
     * Cancela el viaje (transición a estado Cancelado).
     * Permitido en estados Solicitado y Asignado.
     */
    public void cancelarViaje() {
        System.out.println("[State] Intento de cancelar viaje en estado: " + estadoActual.getNombre());
        try {
            estadoActual = estadoActual.cancelar();
            System.out.println("[State] Estado actual: " + estadoActual.getNombre());
        } catch (IllegalStateException e) {
            System.out.println("[State] Error: " + e.getMessage());
        }
    }
}

