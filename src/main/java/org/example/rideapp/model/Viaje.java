package org.example.rideapp.model;

import org.example.rideapp.observer.Observer;
import org.example.rideapp.observer.Subject;
import org.example.rideapp.observer.ViajeEvent;

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
}

