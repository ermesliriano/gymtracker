package com.hadash.gymtracker.databases

import java.util.Date

data class GymSeries(
    val fecha: Date,
    val tipoEjercicio: String,
    val series: List<Serie>
) {
    data class Serie(
        val peso: Double, // Peso en kilogramos
        val repeticiones: Int,
        val anotaciones: String, // Observaciones o notas sobre la serie
        val tiempo: Int,
        val distancia: Int
    )
}
