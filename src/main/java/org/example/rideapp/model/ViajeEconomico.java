package org.example.rideapp.model;

public final class ViajeEconomico extends Viaje {
    public ViajeEconomico(
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        super("economico", wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
    }

    @Override
    public String toString() {
        return "ViajeEconomico{" +
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

