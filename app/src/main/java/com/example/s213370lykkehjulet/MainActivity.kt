package com.example.s213370lykkehjulet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s213370lykkehjulet.ui.theme.S213370LykkehjuletTheme
import com.example.s213370lykkehjulet.viewmodel.LykkehjulViewModel
import com.example.s213370lykkehjulet.viewmodel.lykkehjulUiState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val viewModel = LykkehjulViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S213370LykkehjuletTheme {
                ScreenLayout()
             //   Navigation()


            }
        }
    }
}















/*
@Composable
fun keyBoardButton(onClick: (Char) -> Unit, enabled:Boolean, text: Char){
    Button(
            onClick = {onClick(text)},
            enabled = enabled,
            modifier = Modifier.width(35.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {

        Text(text = text.toString(), textAlign = TextAlign.Center)

    }
}


@Composable
fun KeyBoard(onClick: (Char) -> Unit, state: lykkehjulUiState){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.Center) {
            keyBoardButton(onClick = onClick, enabled = state.pressable, text = 'A')

        }

    }
}






////////////////////////////////


class MainActivity : ComponentActivity() {
    val viewModel = LykkehjulViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S213370LykkehjuletTheme {
                LykkehjuletApp()
            }
        }
    }
}

@Preview
@Composable
fun LykkehjuletApp(viewModel: LykkehjulViewModel = LykkehjulViewModel()) {
    StartButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
    ScreenLayout(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
    Field()

    Text(text = viewModel.uiState.points.toString())
}

// painterResource: Painter, contentDescription: String, modifier: Modifier
/*
    Box {
        Image(
            painterResource(id = R.drawable.baggrundapp),
            contentDescription = "baggrund",
            modfifier = Modifier
                .fillMaxHeight()
                .scale(3f, 4f))

ScreenLayout(modifier = Modifier)

    }

}

*/
// Layout
@Composable
fun ScreenLayout(modifier: Modifier = Modifier){

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {

        //  Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = stringResource(R.string.overskrift),
            fontSize = 57.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier.height(16.dp))
    }
}



// Start knap
@Composable
fun StartButton(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(400.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.start))

        }

    }
}

// Felt
@Composable
fun Field(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        var text by remember { mutableStateOf("Skriv et bogstav") }
        OutlinedTextField(value = text, onValueChange = {newText -> text = newText})

    }
}
*/
