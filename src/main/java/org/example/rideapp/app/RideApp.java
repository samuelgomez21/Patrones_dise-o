package org.example.rideapp.app;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.builder.ViajeBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton que centraliza la administración de viajes y usuarios en la aplicación RideApp.
 * Garantiza que existe una única instancia de RideApp en toda la aplicación.
 */
public final class RideApp {

    /**
     * Instancia única y estática del Singleton.
     */
    private static final RideApp INSTANCE = new RideApp();

    /**
     * Lista de viajes activos en la aplicación.
     */
    private final List<Viaje> viajes = new ArrayList<>();

    /**
     * Contador de viajes creados.
     */
    private int contadorViajes = 0;

    /**
     * Constructor privado para evitar instanciación desde fuera.
     */
    private RideApp() {
        System.out.println("[RideApp] Instancia Singleton inicializada");
    }

    /**
     * Obtiene la única instancia de RideApp.
     * @return instancia única de RideApp
     */
    public static RideApp getInstance() {
        return INSTANCE;
    }

    /**
     * Solicita un nuevo viaje.
     * @param tipo tipo de viaje (economico, premium, moto, compartido)
     * @param wifi si incluye wifi
     * @param mascota si acepta mascotas
     * @param aireAcondicionado si tiene aire acondicionado
     * @param equipaje si permite equipaje
     * @param musica si tiene música
     * @param numeroPasajeros número de pasajeros
     * @return viaje creado
     */
    public Viaje solicitarViaje(
            String tipo,
            boolean wifi,
            boolean mascota,
            boolean aireAcondicionado,
            boolean equipaje,
            boolean musica,
            int numeroPasajeros
    ) {
        System.out.println("[RideApp] Solicitud recibida para viaje: " + tipo);

        Viaje nuevoViaje = new ViajeBuilder()
                .setTipo(tipo)
                .setWifi(wifi)
                .setMascota(mascota)
                .setAireAcondicionado(aireAcondicionado)
                .setEquipaje(equipaje)
                .setMusica(musica)
                .setNumeroPasajeros(numeroPasajeros)
                .build();

        viajes.add(nuevoViaje);
        contadorViajes++;
        System.out.println("[RideApp] Viaje #" + contadorViajes + " agregado al sistema");

        return nuevoViaje;
    }

    /**
     * Obtiene la lista de viajes activos (inmutable).
     * @return lista de viajes
     */
    public List<Viaje> getViajes() {
        return Collections.unmodifiableList(viajes);
    }

    /**
     * Obtiene el número total de viajes creados.
     * @return total de viajes
     */
    public int getTotalViajes() {
        return contadorViajes;
    }

    /**
     * Elimina un viaje del sistema.
     * @param viaje viaje a eliminar
     * @return true si se eliminó correctamente, false si no estaba en la lista
     */
    public boolean eliminarViaje(Viaje viaje) {
        boolean eliminado = viajes.remove(viaje);
        if (eliminado) {
            System.out.println("[RideApp] Viaje eliminado del sistema");
        }
        return eliminado;
    }

    /**
     * Limpia todos los viajes del sistema.
     */
    public void limpiarViajes() {
        viajes.clear();
        System.out.println("[RideApp] Todos los viajes han sido eliminados");
    }

    @Override
    public String toString() {
        return "RideApp{" +
                "totalViajes=" + contadorViajes +
                ", viajosActivos=" + viajes.size() +
                '}';
    }
}

