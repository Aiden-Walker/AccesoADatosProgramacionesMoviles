package com.example.pruebaexamenclaude.CamposTexto

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun inputNombre(texto: String, cuandoCambiaTexto: (String) -> Unit) {
    OutlinedTextField(
        value = texto,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { cuandoCambiaTexto(it) },
        label = {
            Text("Nombre")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
    Spacer(modifier = Modifier.height(16.dp))
}