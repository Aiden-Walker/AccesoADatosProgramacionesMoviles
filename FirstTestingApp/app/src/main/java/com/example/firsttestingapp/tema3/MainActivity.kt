package com.example.firsttestingapp.tema3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firsttestingapp.componentesbasicos.MyPasswordTextField
import com.example.firsttestingapp.componentesbasicos.MyStateHoisting
import com.example.firsttestingapp.componentesbasicos.MyTextFieldCorrect
import com.example.firsttestingapp.componentesbasicos.MyTextFieldParentPassword
import com.example.firsttestingapp.progressindicators.MyLinearProgressIndicator
import com.example.firsttestingapp.tema3.MyTopAppBar
import com.example.firsttestingapp.ui.theme.FirstTestingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstTestingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MyText(modifier=Modifier.padding( paddingValues = innerPadding))
                    //MyStateHoisting(modifier=Modifier.padding( paddingValues = innerPadding))
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    //MyTextFieldCorrect(modifier = Modifier.padding( paddingValues = innerPadding))
                    //MyTextFieldParentPassword(modifier = Modifier.padding(paddingValues = innerPadding))
                    MyLinearProgressIndicator(modifier = Modifier.padding(paddingValues = innerPadding))
                }
            }
        }
    }
}