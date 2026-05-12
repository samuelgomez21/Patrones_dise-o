# RideApp - Builder y Observer

Este modulo implementa los patrones Builder y Observer para el proyecto RideApp. La idea es construir un viaje con configuraciones opcionales y notificar eventos a pasajeros, conductores y la UI.

## Estructura
- `src/main/java/org/example/rideapp/builder` - Builder para configurar el viaje.
- `src/main/java/org/example/rideapp/observer` - Subject/Observer y observadores concretos.
- `src/main/java/org/example/rideapp/model` - Entidad `Viaje` que publica eventos.
- `src/main/java/org/example/rideapp/app/Main.java` - Demo por consola.

## Ejecutar demo

```powershell
mvn -q test
mvn -q -DskipTests package
java -cp target\classes org.example.rideapp.app.Main
```

## Notas
- No se instancia `Viaje` directamente fuera del Builder.
- Este modulo se integra con los demas patrones en fases posteriores.

