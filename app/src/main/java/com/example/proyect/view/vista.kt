package com.example.vista.proyect

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyect.R
import com.example.proyecto.controlador.ContactController
import com.example.proyecto.modelo.Contacto

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<Contacto>
    private lateinit var contactController: ContactController
    private lateinit var btnAgregarContacto: Button
    private lateinit var etNombre: EditText
    private lateinit var etTelefono: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        btnAgregarContacto = findViewById(R.id.btnAgregarContacto)
        etNombre = findViewById(R.id.etNombre)
        etTelefono = findViewById(R.id.etTelefono)
        contactController = ContactController(this)

        // Obtener la lista de contactos del controlador
        val contactos = contactController.getContactos()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactos)
        listView.adapter = adapter

        btnAgregarContacto.setOnClickListener {
            val nombre = etNombre.text.toString()
            val telefono = etTelefono.text.toString()
            contactController.agregarContacto(nombre, telefono)
            actualizarLista()
        }
    }

    private fun actualizarLista() {
        val nuevosContactos = contactController.getContactos()
        adapter.clear()
        adapter.addAll(nuevosContactos)
        adapter.notifyDataSetChanged()
    }
}
