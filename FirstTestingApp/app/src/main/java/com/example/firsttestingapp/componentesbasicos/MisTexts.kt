package com.example.firsttestingapp.componentesbasicos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyStateHoisting(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }
    Column {
        MyState1(modifier, number) { number += 1 }
        //MyState2(modifier, number) { number += 1 }
    }
}
@Composable
fun MyState1(modifier: Modifier, number: Int, onClick: () -> Unit) {
    Text("Púlsame: $number", modifier = modifier.clickable { onClick() })
}
@Preview(showBackground = true)
@Composable
fun MyText() {
    Column {
        Text("hola")
        Text("hola rojo", color = Color.Red)
        Text("texto grande", fontSize = 25.sp)
        Text(
            "texto cursiva y negrita",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        Text("Hola con espacios", letterSpacing = 3.sp)
        Text(
            "Puede servir de link",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable {}
        )
        Text(
            "Hola con 2 decorados",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            "Texto centrado en su hueco mínimo",
            textAlign = TextAlign.Center,
            modifier = Modifier.background(Color.Red)
        )
        Text(
            "Texto centrado ocupando todo el ancho",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().background(Color.Yellow)
        )
        Text(
            "Texto largo que no cabe y ponemos puntos suspensivos",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().background(Color.Blue),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Composable
fun MyTextFieldCorrect(modifier: Modifier) {
    Column(modifier) {
        var text by rememberSaveable { mutableStateOf("") }
        Column(modifier) {
            MyTextFieldAppend(text) {text = it}
        }
        //TextField(text, onValueChange = { text = it })
    }
}
@Composable
fun MyTextFieldAppend(user: String, onUserChange: (String) -> Unit){
    TextField(
        value = user,
        onValueChange = {onUserChange(it)}
    )
}
@Composable
fun MyTextFieldParentPassword(modifier: Modifier) {
    var password by remember { mutableStateOf("") }
    Column(modifier) {
        // Sintaxis habitual en Kotlin con lambda al final
        MyPasswordTextField(password) {password = it}
    }
}
@Composable
fun MyPasswordTextField(
    password: String,
    onValueChange: (String) -> Unit
) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(
            keyboardType =
                KeyboardType.Password
        ),
        visualTransformation = if (passwordHidden)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden =
                    !passwordHidden }
            )
        }
    )
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
*/
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstTestingAppTheme {
        Greeting("Android")
    }
}
@Composable
fun GreetingTwo(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewTwo() {
    FirstTestingAppTheme {
        Greeting("Leon")
    }
}
@Preview(showBackground = true)
@Composable
fun MyColumn() {
    Column {
        Text(
            text = "Hola 1", modifier = Modifier.background(Color.Red).weight(2f)
        )
        Text(
            text = "Hola 2", modifier = Modifier.background(Color.Cyan).weight(1f)
        )
        Text(
            text = "Hola 3", modifier = Modifier.background(Color.Yellow).weight(1f)
        )
        Text(
            text = "Hola 4", modifier = Modifier.background(Color.Blue).weight(1f)
        )
    }
}
*/
