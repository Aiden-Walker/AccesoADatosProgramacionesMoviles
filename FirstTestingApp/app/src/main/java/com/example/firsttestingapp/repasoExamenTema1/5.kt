package repasoExamenTema1

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
/*
import coil3.compose.AsyncImage
*/
//import com.example.myapplication.R



/*
@Composable

fun MyNetworkImage(modifier: Modifier = Modifier) {
    AsyncImage(
        model = "https://cdn.pixabay.com/photo/2017/09/26/23/04/monkey-2790452_1280.jpg",
        contentDescription = "Imagen desde red",
        modifier = modifier.size(250.dp),
        contentScale = ContentScale.Crop,
        onError = { errorState ->
            Log.e("Image", "Ha ocurrido un error: ${errorState.result.throwable.message}")
        }
    )
}
*/


//@Preview(showBackground = true)
//@Composable
//fun MyImageWorkshop() {
//    Column(
//        modifier = Modifier.padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Imagen Local con Borde Degradado
//        Image(
//            painter = painterResource(R.drawable.floripondio),
//            contentDescription = "Flor local",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(180.dp)
//                .clip(RoundedCornerShape(topEnd = 30.dp, bottomStart = 50.dp))
//                .border(
//                    width = 4.dp,
//                    brush = Brush.linearGradient(listOf(Color.Green, Color.Blue,
//                        Color.Cyan)),
//                    shape = RoundedCornerShape(topEnd = 30.dp, bottomStart =
//                        50.dp)
//                )
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Icono Vectorial
//        Icon(
//            painter = painterResource(R.drawable.alien_svgrepo_com),
//            contentDescription = "Icono",
//            tint = Color(0xFF3500FD),
//            modifier = Modifier.size(60.dp)
//        )
//    }
//}

@Preview(showBackground = true)
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


@Composable
fun MyProgressIndicatorsWorkshop(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(true) }
    val animatedProgress by animateFloatAsState(targetValue = progress)
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.size(120.dp),
                color = Color.Green,
                strokeWidth = 12.dp,
                trackColor = Color.LightGray,
                strokeCap = StrokeCap.Round
            )
            Spacer(modifier = Modifier.height(20.dp))
            LinearProgressIndicator(
                progress = { animatedProgress },
                color = Color.Red,
                trackColor = Color.LightGray,
                strokeCap = StrokeCap.Round
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = { if (progress > 0f) progress -= 0.1f }) { Text("-10%") }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { if (progress < 1f) progress += 0.1f }) { Text("+10%") }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { isLoading = !isLoading }) {
            Text(if (isLoading) "Ocultar Carga" else "Mostrar Carga")
        }
    }
}