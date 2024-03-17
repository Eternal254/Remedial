package com.example.proyect

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyect.R
import com.example.proyecto.controlador.ContactController
import com.example.proyecto.modelo.Contacto
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<Contacto>
    private lateinit var contactController: ContactController

    private lateinit var etNombre: EditText
    private lateinit var etTelefono: EditText
    private lateinit var btnAgregarContacto: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        contactController = ContactController(this)

        etNombre = findViewById(R.id.etNombre)
        etTelefono = findViewById(R.id.etTelefono)
        btnAgregarContacto = findViewById(R.id.btnAgregarContacto)

        // Obtener la lista de contactos del controlador
        val contactos = contactController.getContactos()

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactos)
        listView.adapter = adapter

        btnAgregarContacto.setOnClickListener {
            val nombre = etNombre.text.toString()
            val telefono = etTelefono.text.toString()

            if (nombre.isNotEmpty() && telefono.isNotEmpty()) {
                contactController.agregarContacto(nombre, telefono)
                adapter.notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
                etNombre.text.clear()
                etTelefono.text.clear()
            } else {
                Toast.makeText(this, "Ingrese el nombre y teléfono del contacto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
