package org.example.rideapp.model;

public final class ViajePremium extends Viaje {
    public ViajePremium(
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        super("premium", wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
    }

    @Override
    public String toString() {
        return "ViajePremium{" +
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

