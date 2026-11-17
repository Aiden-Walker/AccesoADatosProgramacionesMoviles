package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch
import tema3.MyLinearProgressIndicator
import tema3.MyProgressIndicatorsWorkshop

class MainActivity_2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    floatingActionButton = { MyFAB() },
                    floatingActionButtonPosition = FabPosition.Start,
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Esta es mi screen",
                            modifier = Modifier.clickable {
                                scope.launch {
                                    val result: SnackbarResult = snackbarHostState.showSnackbar(
                                        message = "Ejemplo",
                                        actionLabel = "Deshacer",
                                        duration = SnackbarDuration.Long
                                    )
                                    if (result == SnackbarResult.ActionPerformed) {
// El usuario hizo clic en "Deshacer"
                                    } else {
// El Snackbar se cerró solo o se descartó
                                    }
                                }
                            }
                        )
                    }
/* Contenido central */
                }
            }

/*                    Column(modifier = Modifier.padding(innerPadding)){
                        MyProgressIndicatorsWorkshop(modifier = Modifier.padding(innerPadding))

                    }*/




                }
            }
        }


@Composable
fun PasswordTextFieldSample(modifier: Modifier = Modifier) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val textButton = if (passwordVisible) "Ocultar" else "Mostrar"
            Text(
                text = textButton,
                modifier = Modifier
                    .clickable { passwordVisible = !passwordVisible }
                    .padding(end = 12.dp)
            )
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    MyApplicationTheme {
        PasswordTextFieldSample()
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
)*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text("My app") },
        navigationIcon = {
/*
            Icon(painterResource(R.drawable._4kkkkkk), contentDescription = null)
*/
        },
        actions = {
/*            Icon(painterResource(R.drawable.ico_info), contentDescription = null)
            Icon(painterResource(R.drawable.ico_info), contentDescription = null, tint = Color.Blue)
            Icon(painterResource(R.drawable.ico_info), contentDescription = null)*/
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Yellow,
            actionIconContentColor = Color.Green
        )
    )
}


@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = RoundedCornerShape(100),
        containerColor = Color.Green,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(12.dp)
    ) {
/*
        Icon(painterResource(R.drawable.juasa), contentDescription = null)
*/
    }
}

