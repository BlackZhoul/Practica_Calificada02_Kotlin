package com.lluvians.alvaro.examencalificado02_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lluvians.alvaro.examencalificado02_2.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityEjercicio02Binding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        setContentView(R.layout.activity_ejercicio02)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSave.setOnClickListener {
            // Validar que todos los campos estén llenos
            if (validateInputs()) {
                // Redirigir a la segunda actividad
                val intent = Intent(this, Ejercicio02Pedidos::class.java).apply {
                    putExtra("nombreCliente", binding.edtName.text.toString())
                    putExtra("numeroCliente", binding.edtNumCliente.text.toString())
                    putExtra("productos", binding.edtProductos.text.toString())
                    putExtra("ciudad", binding.edtCiudad.text.toString())
                    putExtra("direccion", binding.edtDireccion.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Función para validar los inputs
    private fun validateInputs(): Boolean {
        return binding.edtName.text.isNotEmpty() &&
                binding.edtNumCliente.text.isNotEmpty() &&
                binding.edtProductos.text.isNotEmpty() &&
                binding.edtCiudad.text.isNotEmpty() &&
                binding.edtDireccion.text.isNotEmpty()
    }
}


