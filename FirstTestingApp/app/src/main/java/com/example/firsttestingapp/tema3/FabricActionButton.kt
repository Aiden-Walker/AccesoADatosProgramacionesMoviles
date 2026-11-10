package com.example.firsttestingapp.tema3

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firsttestingapp.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = RoundedCornerShape(20),
        containerColor = Color.Red,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(12.dp)
    ) {
        Icon(painterResource(R.drawable.ic_add), contentDescription = null)
    }
}