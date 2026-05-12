package org.example.rideapp.builder;

import org.example.rideapp.model.Viaje;

public final class ViajeBuilder {
    private String tipo;
    private boolean wifi;
    private boolean mascota;
    private boolean aireAcondicionado;
    private boolean equipaje;
    private boolean musica;
    private int numeroPasajeros = 1;

    public ViajeBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ViajeBuilder setWifi(boolean wifi) {
        this.wifi = wifi;
        return this;
    }

    public ViajeBuilder setMascota(boolean mascota) {
        this.mascota = mascota;
        return this;
    }

    public ViajeBuilder setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
        return this;
    }

    public ViajeBuilder setEquipaje(boolean equipaje) {
        this.equipaje = equipaje;
        return this;
    }

    public ViajeBuilder setMusica(boolean musica) {
        this.musica = musica;
        return this;
    }

    public ViajeBuilder setNumeroPasajeros(int numeroPasajeros) {
        if (numeroPasajeros <= 0) {
            throw new IllegalArgumentException("El numero de pasajeros debe ser mayor a cero.");
        }
        this.numeroPasajeros = numeroPasajeros;
        return this;
    }

    public Viaje build() {
        System.out.println("[Builder] Configurando viaje");
        String tipoFinal = tipo == null ? "economico" : tipo;
        return Viaje.create(tipoFinal, wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
    }
}

