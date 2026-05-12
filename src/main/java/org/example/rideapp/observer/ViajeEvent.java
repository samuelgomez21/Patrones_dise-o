package org.example.rideapp.observer;

public final class ViajeEvent {
    private final ViajeEventType type;
    private final String message;

    public ViajeEvent(ViajeEventType type, String message) {
        this.type = type;
        this.message = message;
    }

    public ViajeEventType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}

