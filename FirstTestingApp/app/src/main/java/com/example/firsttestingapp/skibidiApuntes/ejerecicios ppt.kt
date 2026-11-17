package xd

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyState(modifier: Modifier = Modifier) {
    // Se preserva el valor a través de las recomposiciones
    var number = remember { mutableStateOf(0) }
    Column {
        Text(
            text = "Púlsame: ${number.value}",
            modifier = modifier.clickable { number.value += 1 }
        )
        Text(
            text = "Contador actual: ${number.value}"
        )
        Text(
            "Puede servir de link",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable {}
        )


    }
}

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("") }
    Column(modifier) {
        // Sintaxis habitual en Kotlin con lambda al final
        MyTextField(user) { user = it }
    }
}
// Composable Hijo (Stateless - Recibe valor y evento)
@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(
        value = user,
        onValueChange = { onUserChange(it) }
    )
}