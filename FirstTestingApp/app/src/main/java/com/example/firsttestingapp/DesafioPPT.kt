package com.example.firsttestingapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyRetoPPT(){
}
/*
@Composable
fun MyState(modifier: Modifier) {
    // Se declara con val porque el objeto MutableState no cambia,
    // solo cambia su propiedad interna .value
    val number = rememberSaveable { mutableStateOf(0) }
    Column {
        Text(a
                text = "Púlsame: ${number.value}",
            modifier = modifier.clickable { number.value += 1 }
        )
    }
}
*/