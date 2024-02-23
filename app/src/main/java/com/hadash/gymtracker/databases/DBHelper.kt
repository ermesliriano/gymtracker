package com.hadash.gymtracker.databases

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.hadash.gymtracker.activities.SessionActivity

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        fun getInstance(context: Context) {

            }
        }

        private const val DATABASE_NAME = "GymTracker.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createGymSeriesTable = """
            CREATE TABLE GymSeries (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                fecha TEXT,
                tipoEjercicio TEXT
            );
        """.trimIndent()
        db.execSQL(createGymSeriesTable)

        val createSerieTable = """
            CREATE TABLE Serie (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                gymSeriesId INTEGER,
                peso REAL,
                repeticiones INTEGER,
                anotaciones TEXT,
                tiempo INTEGER,
                distancia INTEGER,
                FOREIGN KEY(gymSeriesId) REFERENCES GymSeries(id)
            );
        """.trimIndent()
        db.execSQL(createSerieTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Aquí gestionar actualizaciones de esquema
    }

    // Métodos para insertar y consultar datos
    fun insertGymSeries(gymSeries: GymSeries): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("fecha", gymSeries.fecha.time) // Almacenamos la fecha como timestamp
            put("tipoEjercicio", gymSeries.tipoEjercicio)
        }
        val gymSeriesId = db.insert("GymSeries", null, values)

        gymSeries.series.forEach { serie ->
            insertSerie(serie, gymSeriesId, db)
        }

        return gymSeriesId
    }

    private fun insertSerie(serie: GymSeries.Serie, gymSeriesId: Long, db: SQLiteDatabase) {
        val values = ContentValues().apply {
            put("gymSeriesId", gymSeriesId)
            put("peso", serie.peso)
            put("repeticiones", serie.repeticiones)
            put("anotaciones", serie.anotaciones)
        }
        db.insert("Serie", null, values)
    }

}
