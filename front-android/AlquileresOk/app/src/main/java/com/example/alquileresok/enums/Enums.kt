package com.example.alquileresok.enums

object Enums {enum class HorasAlquiladas(val label: String) {
    PLAZO_CORTO("5 horas"),
    PLAZO_MEDIO("7 horas"),
    PLAZO_LARGO("10 horas");

    override fun toString() = label
}

    enum class TipoVehiculo(val label: String) {
        COCHE("Volkswagen Polo"),
        BICI("Bianchi Alivio"),
        SCOOTER("Bongo V70");

        override fun toString() = label
    }

    enum class ColorVehiculo {
        ROJO, AZUL, NEGRO;

        override fun toString() = name.lowercase().replaceFirstChar { it.uppercase() }
    }

    // Métodos de ayuda si quieres listas de labels
    fun horasLabels() = HorasAlquiladas.values().map { it.label }
    fun tipoVehiculoLabels() = TipoVehiculo.values().map { it.label }
    fun coloresLabels() = ColorVehiculo.values().map { it.toString() }
}