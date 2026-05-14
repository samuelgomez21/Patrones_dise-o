package org.example.rideapp.factory;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.model.ViajeEconomico;
import org.example.rideapp.model.ViajePremium;
import org.example.rideapp.model.ViajeMoto;
import org.example.rideapp.model.ViajeCompartido;

/**
 * Factory Method para crear instancias de Viaje según el tipo especificado.
 * Implementa el patrón Factory Method para encapsular la lógica de creación.
 */
public final class ViajeFactory {

    private ViajeFactory() {
        // Constructor privado para evitar instanciación
    }

    /**
     * Crea una instancia de Viaje según el tipo especificado.
     *
     * @param tipo El tipo de viaje: "economico", "premium", "moto" o "compartido"
     * @return Una instancia de Viaje del tipo especificado con configuración predeterminada
     * @throws IllegalArgumentException si el tipo de viaje es inválido
     */
    public static Viaje crearViaje(String tipo) {
        return crearViaje(tipo, false, false, true, false, false, 1);
    }

    /**
     * Crea una instancia de Viaje según el tipo y características especificadas.
     *
     * @param tipo El tipo de viaje: "economico", "premium", "moto" o "compartido"
     * @param wifi Si el viaje incluye wifi
     * @param mascota Si el viaje permite mascotas
     * @param aireAcondicionado Si el viaje tiene aire acondicionado
     * @param equipaje Si el viaje permite equipaje
     * @param musica Si el viaje tiene música
     * @param numeroPasajeros Número de pasajeros
     * @return Una instancia de Viaje del tipo especificado
     * @throws IllegalArgumentException si el tipo de viaje es inválido
     */
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

