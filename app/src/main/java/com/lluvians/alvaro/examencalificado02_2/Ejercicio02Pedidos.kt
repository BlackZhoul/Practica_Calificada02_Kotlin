package com.lluvians.alvaro.examencalificado02_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lluvians.alvaro.examencalificado02_2.databinding.ActivityEjercicio02PedidosBinding

class Ejercicio02Pedidos : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02PedidosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio02PedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio02_pedidos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener los datos pasados desde la primera actividad
        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val ciudad = intent.getStringExtra("ciudad")
        val direccion = intent.getStringExtra("direccion")

        // Configurar los textos en la interfaz
        binding.tvName.text = "Nombre de Cliente: $nombreCliente"
        binding.tvPhone.text = "Número de Cliente: $numeroCliente"
        binding.tvProductos.text = "Producto: $productos"
        binding.tvCiudad.text = "Ciudad: $ciudad"
        binding.tvDireccion.text = "Dirección: $direccion"

        // Acciones para los botones
        binding.imbPhone.setOnClickListener {
            numeroCliente?.let {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$it")
                }
                startActivity(intent)
            } ?: run {
                Toast.makeText(this, "Número de cliente no disponible", Toast.LENGTH_SHORT).show()
            }
        }

        binding.imbWsp.setOnClickListener {
            nombreCliente?.let {
                val mensaje = "Hola $nombreCliente. Tus productos: $productos están en camino a la dirección: $direccion"
                val uri = Uri.parse("https://wa.me/?text=${Uri.encode(mensaje)}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setPackage("com.whatsapp")
                startActivity(intent)
            } ?: run {
                Toast.makeText(this, "No se puede enviar el mensaje", Toast.LENGTH_SHORT).show()
            }
        }

        binding.imbLocation.setOnClickListener {
            direccion?.let {
                val uri = Uri.parse("geo:0,0?q=${Uri.encode(it)}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            } ?: run {
                Toast.makeText(this, "Dirección no disponible", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

