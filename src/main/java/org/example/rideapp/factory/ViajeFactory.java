package org.example.rideapp.factory;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.model.ViajeEconomico;
import org.example.rideapp.model.ViajePremium;
import org.example.rideapp.model.ViajeMoto;
import org.example.rideapp.model.ViajeCompartido;


public final class ViajeFactory {

    private ViajeFactory() {
        // Constructor privado para evitar instanciación
    }

   
    public static Viaje crearViaje(String tipo) {
        return crearViaje(tipo, false, false, true, false, false, 1);
    }

  
    public static Viaje crearViaje(
            String tipo,
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de viaje no puede ser nulo o vacío.");
        }

        String tipoNormalizado = tipo.toLowerCase().trim();

        return switch (tipoNormalizado) {
            case "economico" -> {
                System.out.println("[Factory] Creando viaje economico");
                yield new ViajeEconomico(wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
            }
            case "premium" -> {
                System.out.println("[Factory] Creando viaje premium");
                yield new ViajePremium(wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
            }
            case "moto" -> {
                System.out.println("[Factory] Creando viaje moto");
                yield new ViajeMoto(wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
            }
            case "compartido" -> {
                System.out.println("[Factory] Creando viaje compartido");
                yield new ViajeCompartido(wifi, mascota, aireAcondicionado, equipaje, musica, numeroPasajeros);
            }
            default -> throw new IllegalArgumentException(
                    "Tipo de viaje inválido: " + tipoNormalizado +
                    ". Tipos válidos: economico, premium, moto, compartido"
            );
        };
    }
}

