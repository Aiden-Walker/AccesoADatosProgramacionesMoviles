package com.example.firsttestingapp.progressindicators

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun MyLinearProgressIndicator(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(140.dp),
            color = Color.Green,
            strokeWidth = 20.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Square
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Indicador lineal horizontal
        LinearProgressIndicator(
            color = Color.Red,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
    }
}