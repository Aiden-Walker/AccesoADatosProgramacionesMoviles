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
import androidx.core.text.isDigitsOnly

@Composable
fun inputTLF(texto: String, cuandoCambiaTexto: (String) -> Unit) {
    OutlinedTextField(
        value = texto,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {

            if (it.isEmpty()) {
                cuandoCambiaTexto(it)
            } else {
                if (it.isDigitsOnly()) {
                    if (it.length <= 9) {
                        cuandoCambiaTexto(it)
                    }
                }
            }
        },
        label = {
            Text("Telefono")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
    Spacer(modifier = Modifier.height(16.dp))

}