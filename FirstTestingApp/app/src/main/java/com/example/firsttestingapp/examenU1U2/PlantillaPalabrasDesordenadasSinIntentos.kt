package examenU1U2

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firsttestingapp.componentesbasicos.MyTextFieldAppend

@Composable
fun JuegoPalabrasEstados(modifier: Modifier = Modifier) {

    // TODO 1: Declara los estados persistentes ante rotación:
    // - nivel (Int)
    // - palabraUsuario (String que el usuario escribirá en el Campo de Texto, empieza vacío)
    // - mensaje (String que se mostrará en el Texto inferior, empieza vacío)
    // - juegoTerminado (Boolean)
    val nivel = rememberSaveable { mutableStateOf(0)}
    var palabraUsuario by rememberSaveable { mutableStateOf("") }
    var mensaje by rememberSaveable { mutableStateOf("") }
    val juegoTerminado = rememberSaveable { mutableStateOf(true) }

    // Datos según el nivel actual
    val varABorrar=(1..3).random()
    val palabraDesordenadaNivel = when (/* TODO: pasa aquí la variable nivel */varABorrar) {
        1 -> "L O B R A"
        2 -> "R O T A N"
        3 -> "A L E R T S E L"
        else -> ""
    }

    val palabraOrdenadaNivel = when (/* TODO: pasa aquí la variable nivel */varABorrar) {
        1 -> "ARBOL"
        2 -> "RATON"
        3 -> "ESTRELLA"
        else -> ""
    }

    JuegoPalabrasUI(
        modifier = modifier,
        nivel = /* TODO */0,
        palabraDesordenadaNivel = palabraDesordenadaNivel,
        palabraUsuario = /* TODO */"",
        mensaje = /* TODO */"",
        juegoTerminado = /* TODO */ false,
        onPalabraUsuarioChange = { /* TODO */ },
        onClickComprobar = {
            // TODO 2: Implementa la lógica al pulsar "Comprobar"
            if (palabraUsuario == ""){
                //Genuinamente estoy muy bloqueado y no se como referirme al campo de texto de "Tu respuesta" lo siento
                //Lo que si se es que dicho texto hay que cambiarlo por "Escriba una respuesta" ya que estaria vacio
            } else if (palabraUsuario == palabraOrdenadaNivel){
                if (nivel.equals(1) || nivel.equals(2)){
                    //No se como subir el nivel, cada cosa que intento me da error de compilacion, tipo, ++, nivel = 1/2/3
                }
                if(nivel.equals(3)){
                    //Al igual que antes no se como referirme al campo de texto de tu respuesta y cambiar el valor a las felicitaciones
                }
            }
        }
    )
}

@Composable
fun JuegoPalabrasUI(
    modifier: Modifier = Modifier,
    nivel: Int,
    palabraDesordenadaNivel: String,
    palabraUsuario: String,
    mensaje: String,
    juegoTerminado: Boolean,
    onPalabraUsuarioChange: (String) -> Unit,
    onClickComprobar: () -> Unit
) {
    // TODO 3: Construye la interfaz usando Column, Box, Text, OutlinedTextField, Row, Button y Spacer
    @Composable
    fun InterFazUsuario() {
        Box(modifier = Modifier.padding(18.dp)) {
            Row(modifier = Modifier.background(Color(0xFFEDE7F6))) {
                Text("ADIVINA LA PALABRA", color = Color(0xFF4527A0), fontSize = 22.sp)
            }
            Row() {
                Text("Ordena Las Letras (Nivel "+nivel+"/3)")
                Text(palabraDesordenadaNivel)
            }
            @Composable
            fun TextoDeRespuesta(
                value: String,
                onUserChange: (String) -> Unit
            ) {
                OutlinedTextField(
                    value = value,
                    onValueChange = { onUserChange(it) },
                    label = { Text("Tu Respuesta") }
                )
            }
            Row(){
                Button(onClickComprobar, shape = RoundedCornerShape(100)) {
                    Text("Comprobar", color = Color.White)
                }
                Button(onClick = ) {
                    Text("Limpiar", color = Color.White)
                }
            }
            Row(){
                Text("Escribe una palabra antes de comprobar")
            }
        }
    }

}