package com.lluvians.alvaro.examencalificado02_2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lluvians.alvaro.examencalificado02_2.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout con viewBinding
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Manejar los insets del sistema de forma correcta
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar los listeners para mostrar y ocultar el LinearLayout
        binding.btnMostrar.setOnClickListener {
            binding.colorbackground.visibility = View.VISIBLE
        }

        binding.btnOcultar.setOnClickListener {
            binding.colorbackground.visibility = View.GONE
        }
    }
}