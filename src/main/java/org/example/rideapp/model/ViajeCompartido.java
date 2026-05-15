package org.example.rideapp.model;

public final class ViajeCompartido extends Viaje {
    public ViajeCompartido(
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        super("compartido", wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
    }

    @Override
    public String toString() {
        return "ViajeCompartido{" +
                "tipo='" + getTipo() + '\'' +
                ", wifi=" + hasWifi() +
                ", mascota=" + hasMascota() +
                ", aireAcondicionado=" + hasAireAcondicionado() +
                ", equipaje=" + hasEquipaje() +
                ", musica=" + hasMusica() +
                ", numeroPasajeros=" + getNumeroPasajeros() +
                '}';
    }
}

