package com.example.s213370lykkehjulet

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        //Overskrift
        Text(
            text = "velkommen",
            fontSize = 50.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
                    navController.navigate(Screens.ScreenLayout.route)
        },
        modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Start spil")
        }
    }
}