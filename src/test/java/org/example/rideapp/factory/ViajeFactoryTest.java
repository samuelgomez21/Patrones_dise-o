package org.example.rideapp.factory;

import org.example.rideapp.model.Viaje;
import org.example.rideapp.model.ViajeEconomico;
import org.example.rideapp.model.ViajePremium;
import org.example.rideapp.model.ViajeMoto;
import org.example.rideapp.model.ViajeCompartido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViajeFactoryTest {

    @Test
    void crearViajeEconomico() {
        Viaje viaje = ViajeFactory.crearViaje("economico");
        assertNotNull(viaje);
        assertInstanceOf(ViajeEconomico.class, viaje);
        assertEquals("economico", viaje.getTipo());
    }

    @Test
    void crearViajePremium() {
        Viaje viaje = ViajeFactory.crearViaje("premium");
        assertNotNull(viaje);
        assertInstanceOf(ViajePremium.class, viaje);
        assertEquals("premium", viaje.getTipo());
    }

    @Test
    void crearViajeMoto() {
        Viaje viaje = ViajeFactory.crearViaje("moto");
        assertNotNull(viaje);
        assertInstanceOf(ViajeMoto.class, viaje);
        assertEquals("moto", viaje.getTipo());
    }

    @Test
    void crearViajeCompartido() {
        Viaje viaje = ViajeFactory.crearViaje("compartido");
        assertNotNull(viaje);
        assertInstanceOf(ViajeCompartido.class, viaje);
        assertEquals("compartido", viaje.getTipo());
    }

    @Test
    void crearViajeConParametros() {
        Viaje viaje = ViajeFactory.crearViaje("premium", true, false, true, true, false, 2);
        assertNotNull(viaje);
        assertInstanceOf(ViajePremium.class, viaje);
        assertEquals("premium", viaje.getTipo());
        assertTrue(viaje.hasWifi());
        assertFalse(viaje.hasMascota());
        assertTrue(viaje.hasAireAcondicionado());
        assertTrue(viaje.hasEquipaje());
        assertFalse(viaje.hasMusica());
        assertEquals(2, viaje.getNumeroPasajeros());
    }

    @Test
    void crearViajeConTipoEnMayusculas() {
        Viaje viaje = ViajeFactory.crearViaje("ECONOMICO");
        assertNotNull(viaje);
        assertInstanceOf(ViajeEconomico.class, viaje);
        assertEquals("economico", viaje.getTipo());
    }

    @Test
    void crearViajeConTipoEnMayusculasYEspacios() {
        Viaje viaje = ViajeFactory.crearViaje("  PREMIUM  ");
        assertNotNull(viaje);
        assertInstanceOf(ViajePremium.class, viaje);
        assertEquals("premium", viaje.getTipo());
    }

    @Test
    void crearViajeConTipoNuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> ViajeFactory.crearViaje(null));
    }

    @Test
    void crearViajeConTipoVacioLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> ViajeFactory.crearViaje(""));
    }

    @Test
    void crearViajeConTipoInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> ViajeFactory.crearViaje("invalido"));
    }
}

