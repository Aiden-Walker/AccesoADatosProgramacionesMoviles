package com.example.myapplication

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
public fun inputEmail(texto: String, cuandoCambiaTexto: (String) -> Unit) {
    OutlinedTextField(
        value = texto,
        onValueChange = { cuandoCambiaTexto(it) },
        label = {
            Text("Email")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
public fun inputPassword(texto: String, cuandoCambiaTexto: (String) -> Unit) {
    var passwordHidden by rememberSaveable() { mutableStateOf(true) }
    OutlinedTextField(
        value = texto,
        onValueChange = { cuandoCambiaTexto(it) },
        label = {
            Text("Contraseña")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        visualTransformation = if (passwordHidden)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,

        //manue si no eres bobo entiendes esto
        trailingIcon = {
            Text(
                if (passwordHidden) "mostrar" else "ocultar",
                modifier = Modifier
                    .clickable() { passwordHidden = !passwordHidden }
                    .padding(10.dp)
            )
        }
    )
}

@Composable
fun Boton() {

    Button(
        modifier = Modifier.padding(15.dp),
        onClick = {
            //
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White),
        elevation = ButtonDefaults.buttonElevation(pressedElevation = 20.dp)




        ////onClick: () -> Unit,
        //onClick = { println("pulsado") }

        ////modifier: Modifier = Modifier,
        //modifier = Modifier.fillMaxWidth().padding(8.dp)

        ////enabled: Boolean = true,
        //enabled = false                      // ignora clics y se ve atenuado

        ////shape: Shape = ButtonDefaults.shape,
        //shape = RoundedCornerShape(10.dp)    // 10.dp = radio fijo | (100) sin unidad = píldora

        ////colors: ButtonColors = ButtonDefaults.buttonColors(),
        //colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red)

        ////elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
        //elevation = ButtonDefaults.buttonElevation(pressedElevation = 20.dp)

        ////border: BorderStroke? = null,
        //border = BorderStroke(2.dp, Color.Red)

        ////contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
        //contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)

        ////interactionSource: MutableInteractionSource? = null,
        //interactionSource = remember { MutableInteractionSource() }

        ////content: @Composable RowScope.() -> Unit
        //{ Text("Púlsame") }                  // trailing lambda, va fuera de los ( )
    ) {
        Text("Púlsame")
    }
}

