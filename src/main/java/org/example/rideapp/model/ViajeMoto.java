package org.example.rideapp.model;

public final class ViajeMoto extends Viaje {
    public ViajeMoto(
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        super("moto", wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
    }

    @Override
    public String toString() {
        return "ViajeMoto{" +
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

