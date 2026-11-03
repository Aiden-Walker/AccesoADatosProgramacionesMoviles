package com.example.firsttestingapp.imaging
import androidx.compose.foundation.Image
import com.example.firsttestingapp.R
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
@Composable
fun MyImageContentScale() {
    Image(
        painter = painterResource(R.drawable.laggingbear),
        contentDescription = "Imagen de flor",
        modifier = Modifier
            .height(200.dp)
            .width(150.dp),
        // Opciones de ContentScale:
        // ContentScale.Crop (Rellena recortando)
        // ContentScale.FillHeight (Ajusta alto)
        // ContentScale.FillWidth (Ajusta ancho)
        contentScale = ContentScale.FillBounds //
    )
}