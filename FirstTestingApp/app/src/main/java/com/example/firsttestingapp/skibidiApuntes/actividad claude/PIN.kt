package com.example.pruebaexamenclaude.CamposTexto

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun inputPin(pin: String, cuandoCambiaTexto: (String) -> Unit) {
    var pinVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = pin,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {
            cuandoCambiaTexto(it)
        },
        label = { Text("Contraseña") },
        singleLine = true,
        visualTransformation = if (pinVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val textButton = if (pinVisible) "Ocultar" else "Mostrar"
            Text(
                text = textButton,
                modifier = Modifier
                    .clickable { pinVisible = !pinVisible }
                    .padding(end = 12.dp)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
    Spacer(modifier = Modifier.height(16.dp))
}