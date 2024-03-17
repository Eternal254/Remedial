package com.example.proyecto.controlador

import android.content.Context
import com.example.proyecto.modelo.Contacto

class ContactController(private val context: Context) {

    private val contactos = mutableListOf<Contacto>()

    init {
        // Inicializar contactos o cargarlos desde una base de datos
        contactos.add(Contacto("Juan", "1234567890"))
        contactos.add(Contacto("María", "9876543210"))
        contactos.add(Contacto("Carlos", "5555555555"))
    }

    fun getContactos(): List<Contacto> {
        return contactos
    }

    fun agregarContacto(nombre: String, telefono: String) {
        contactos.add(Contacto(nombre, telefono))
        // Actualizar la vista si es necesario
    }

    // Otros métodos para modificar contactos (eliminar, editar, etc.)
}
