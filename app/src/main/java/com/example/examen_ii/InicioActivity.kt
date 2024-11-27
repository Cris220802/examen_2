package com.example.examen_ii

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        // Configuración de padding para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuración de los botones
        val btnUsuarios: Button = findViewById(R.id.btnUsuarios)
        val btnCreditos: Button = findViewById(R.id.btnCreditos)
        val btnSalir: Button = findViewById(R.id.btnSalir)

        // Al hacer clic en el botón "Usuarios", va a MainActivity
        btnUsuarios.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Al hacer clic en el botón "Créditos", va a CreditosActivity
        btnCreditos.setOnClickListener {
            val intent = Intent(this, CreditosActivity::class.java)
            startActivity(intent)
        }

        // Al hacer clic en el botón "Salir", cierra la aplicación
        btnSalir.setOnClickListener {
            finishAffinity() // Cierra todas las actividades y sale de la app
        }
    }
}
