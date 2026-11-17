package com.example.pruebaexamenclaude

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pruebaexamenclaude.CamposTexto.inputNombre
import com.example.pruebaexamenclaude.CamposTexto.inputPin
import com.example.pruebaexamenclaude.CamposTexto.inputTLF
import com.example.pruebaexamenclaude.ui.theme.PruebaExamenClaudeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaExamenClaudeTheme {
                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { innerPadding ->
                    Body(
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState = snackbarHostState

                    )
                }
            }
        }
    }
}


@Composable

fun Body(
    modifier: Modifier,
    snackbarHostState: SnackbarHostState
) {
    val scope = rememberCoroutineScope()
    var comensales by rememberSaveable() { mutableStateOf(0) }
    val scrollState = rememberScrollState();
    var nombre by rememberSaveable() { mutableStateOf("") }
    var telefono by rememberSaveable() { mutableStateOf("") }
    var pin by rememberSaveable() { mutableStateOf("") }


    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF3E0))
                .padding(12.dp)
        ) {
            Text(
                text = "RESERVA DE MESA",
                color = Color(0xFFE65100),
                fontSize = (22.sp),
                fontWeight = FontWeight.SemiBold
            )
        }
        inputNombre(nombre) { nombre = it }
        inputTLF(telefono) { telefono = it }
        inputPin(pin) { pin = it }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Comensales:")

        Row(verticalAlignment = Alignment.CenterVertically) {


            Button(
                onClick = {
                    if (comensales == 0) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "la cantidad no puede ser menor que cero",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else {
                        comensales--
                    }
                }
            ) { Text(text = "-") }

            Spacer(modifier = modifier.width(10.dp))

            Text(
                text = "$comensales",
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = modifier.width(10.dp))

            Button(
                onClick = { comensales++ }
            ) { Text(text = "+") }
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {

            Button(
                onClick = {
                    comensales = 0
                    nombre = ""
                    telefono = ""
                    pin = ""
                }
            ) { Text(text = "Limpiar") }

            Button(

                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Reserva confirmada",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            ) { Text(text = "confirmar") }

        }

    }
}