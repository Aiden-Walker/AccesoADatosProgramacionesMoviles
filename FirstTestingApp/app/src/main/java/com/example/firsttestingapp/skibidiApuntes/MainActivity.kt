package com.example.myapplication

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.descriptors.PrimitiveKind

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(

                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
                ) { top ->
                    esamenpadre(
                        modifier = Modifier.padding(top = 24.dp),
                        snackbarHostState = snackbarHostState
                    )

                    /*
                                        clicable(modifier = Modifier.padding(innerPadding))
                    */
                }
            }
        }
    }
}

@Composable
fun esamenpadre(
    modifier: Modifier,
    snackbarHostState: SnackbarHostState
) {
    esamen(
        modifier = modifier,
        snackbarHostState = snackbarHostState
    )
}








@Composable
fun esamen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState
) {
    var producto by rememberSaveable() { mutableStateOf("") }
    var cantidad by rememberSaveable() { mutableStateOf(0) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFE3F2FD),
                    shape = RoundedCornerShape(10)
                )
                .padding(vertical = 6.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "FICHA DE PEDIDO",
                color = Color(0xFF1565C0),
                fontSize = (22.sp),
                fontWeight = FontWeight.SemiBold
            )


        }
        inputProducto(texto = producto) { producto = it }


        Text(text = "Cantidad:")

        Row(verticalAlignment = Alignment.CenterVertically) {


            Button(
                onClick = {
                    if (cantidad == 0) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "la cantidad no puede ser menor que cero",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else {
                        cantidad--
                    }
                }
            ) { Text(text = "-") }

            Spacer(modifier = modifier.width(10.dp))

            Text(
                text = "$cantidad",
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = modifier.width(10.dp))

            Button(
                onClick = { cantidad++ }
            ) { Text(text = "+") }
        }

        if (cantidad != 0 && producto != "") {
            Text(text = "Resumen: $cantidad unidad(es) de '$producto'")
        }


    }
}


@Composable
fun inputProducto(texto: String, cuandoCambiaTexto: (String) -> Unit) {
    OutlinedTextField(
        value = texto,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { cuandoCambiaTexto(it) },
        label = {
            Text("Nombre producto")
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
    Spacer(modifier = Modifier.height(16.dp))

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}


@Composable
fun mybox(modifier: Modifier) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "hola hola hola hola")
        Text(text = "nigger nigger nigger nigger")
    }
}

@Composable
fun myColumn(modifier: Modifier) {
    var xd by remember { mutableIntStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "antonio",
            modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)
                .weight(2f)
                .clickable {
                    xd++
                }
        )
        Text(
            text = "hola: $xd",
            modifier = Modifier
                .background(Color.Yellow)
                .weight(2f)
                .padding(16.dp)
        )
        Text(
            text = "antonio", modifier = Modifier
                .background(Color.Green)
                .weight(2f)
                .padding(16.dp)

        )

    }
}

@Composable
fun layaouts(modifier: Modifier) {

    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .background(Color.Yellow)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Magenta)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "makako", modifier = Modifier)
        }

    }
}


//composabel es la propiedad de muestreo por pantalla por lo que e entendido
@Composable
fun clicable(modifier: Modifier) {

    //aquí tengo que usar remember para que al actualizar el mutableStateOf no reinicie el valor
    //  porque se relaza el metodo cada que hay una actualizacion asi que siempre se reiniciara a zero


//                                              se pueden poner los dos, pero mejor si se usa el
    //                                              específico de la variable
    var number by /*remember*/ rememberSaveable { /*mutableStateOf*/ mutableIntStateOf(0) }

    // IMPORTANTE, REMEMBER SE AUTODESTRUYE AL ROTAR LA PANTALLA (ESTUPIDO, NO LO ENTIENDO PERO VALE)
    // EN CASO DE ROTACION DE PANTALLA (99% DE VECES que vaya a hacer una app SUPONGO) HAY QUE PONER
    // rememberSaveable


    //al usar un remember hayq ue acceder al valor del remember porque no se guarda directamente
    //  en la variable
    //en vez de:
    /*    Text(text = "numerin; $number", modifier = modifier.clickable{
            number += 1
        })*/

    //hay que hacerlo asi, en la lectura surroundearlo con {variable.value} y con la signacion u
    //  otros usos logicos con .value solo

    /*    Text(text = "numerin; ${number.value}", modifier = modifier.clickable{
            number.value += 1
        })*/


    // (nos lo podemos ahorrar si definimos la varible con by en vez de un = ):
    Text(text = "numerin; $number", modifier = modifier.clickable {
        number += 1
    })

}


//esto seria como la main
@Composable
fun artefacto(modifier: Modifier) {

    var enEfecto by rememberSaveable() { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            xd2(modifier, enEfecto) { enEfecto -= 1 }
            xd1(modifier, enEfecto) { enEfecto += 1 }

        }
        //importate usar remember pq sino no sale na
        var testo by rememberSaveable() { mutableStateOf("") }
        campoDeTexto(testo) { testo = it }
    }
}

@Composable
fun xd1(modifier: Modifier, xd: Int, onClick: () -> Unit) {
    Text(
        "aumentar numero: $xd", modifier = modifier
            .padding(16.dp)
            .clickable() { onClick() })
}

@Composable
fun xd2(modifier: Modifier, xd: Int, onClick: () -> Unit) {
    Text(
        "disminuir numero: $xd", modifier = modifier
            .padding(16.dp)
            .clickable() { onClick() })
}

@Composable
//es un campo de texto pa escribir, la varible string es el texto que se esta introduciendo
fun campoDeTexto(texto: String, cuandoCambiaTexto: (String) -> Unit) {
    var passwordHidden by rememberSaveable() { mutableStateOf(true) }

    //OutlinedTextField: Tiene la misma API que TextField pero aplica un
    //borde delineado exterior.

    //BasicTextField: Componente de más bajo nivel sin estilos por
    //defecto. Utilizar si quieres crear diseños completamente
    //personalizados desde cero.

    /*TextField*/ OutlinedTextField(
        texto,
        onValueChange = { cuandoCambiaTexto(it) },
        placeholder = { Text("xd") },
        //true para solo lectura, se podra combinar con botones y etc para bloquear y desbloquear
        // la escriutura en el campo
        readOnly = false,

        //diferencia entre label y placeholder es que por ejemplo en el campo de texto la etiqueta
        // es cuando no esta seleccionado aparece introduce tu email y cuadno lo seleccionas aparece
        // el placeholder que seria ejemplo@correo.org
        label = {
            Text("ola caracola")
        },
        singleLine = true,
        //Le dice a Android qué teclado mostrar cuando el usuario toca el TextField.
        // Solo afecta al teclado, no a cómo se ve el texto dentro del campo.
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        //cuidao con las mayusculas y minusculas
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
fun login(modifier: Modifier) {
    var password by rememberSaveable() { mutableStateOf("") }
    var Email by rememberSaveable() { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("prueba")

        Spacer(modifier = modifier.height(10.dp))

        inputEmail(Email) { Email = it }
        inputPassword(password) { password = it }

        Row() {
            Boton()
            Boton()
        }
    }


}

