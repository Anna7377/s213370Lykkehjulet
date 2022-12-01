package com.example.s213370lykkehjulet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s213370lykkehjulet.ui.theme.LightBlue
import com.example.s213370lykkehjulet.ui.theme.Purple500
import com.example.s213370lykkehjulet.ui.theme.Purple700
import com.example.s213370lykkehjulet.ui.theme.Teal200
import com.example.s213370lykkehjulet.viewmodel.LykkehjulViewModel
import kotlinx.coroutines.launch

//UI
@Preview
@Composable
fun ScreenLayout(viewModel: LykkehjulViewModel = LykkehjulViewModel(), modifier: Modifier = Modifier, /*navController: NavController*/) {

    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {

    Column(modifier = Modifier
        .background(LightBlue)
        .padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {


        //Overskrift
        Text(
            text = viewModel.uiState.titel,
            fontSize = 50.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
        )
        Spacer(modifier.height(10.dp))

        
        Row() {

            //Point tæller tekst
            Text(
                text = stringResource(R.string.point),
                fontSize = 20.sp,
                style = MaterialTheme.typography.h6
            )
            
            Spacer(modifier = Modifier.width(120.dp))


            //Instruktion overskrift
            Text(
                text = "Instruktion:",
                fontSize = 18.sp,
                style = MaterialTheme.typography.subtitle2,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,

                      color = Teal200,
                textDecoration = TextDecoration.Underline
                )
            
        }

        Row() {

            //Point tæller tal
            Text(
                text = viewModel.uiState.points.toString(),
                fontSize = 20.sp,

            )

            Spacer(modifier = Modifier.width(162.dp))

            //Instruktion punkter
            Text(
                text = viewModel.uiState.rules,
                fontSize = 15.sp,
                color = Teal200

                )
        }
        


        Spacer(modifier.height(2.dp))


        //Liv tæller tekst
        Text(
            text = stringResource(R.string.liv),
            fontSize = 20.sp,
            style = MaterialTheme.typography.h6

        )

        //Liv tæller tal
        Text(
            text = viewModel.uiState.lives.toString(),
            fontSize = 20.sp
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp)) {

            Text(
                text = "Pointværdi:",
                fontSize = 20.sp,
                modifier = Modifier.width(110.dp),
                style = MaterialTheme.typography.h6
            )

            Text(
                text = viewModel.uiState.RandomPoints.toString(),
                fontSize = 20.sp
            )

        }


        //Kategori
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
            horizontalArrangement = Arrangement.Center) {
            
            Text(
                text = "Kategori:",
                fontSize = 20.sp,
                style = MaterialTheme.typography.h6

            )

            Spacer(modifier = Modifier.padding(5.dp))
            
            //CurrentKategori, kategori for CurrentWord
            Text(
                text = viewModel.uiState.category,
                fontSize = 20.sp,
         //       modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            
        }

        

        //Ordet som skal gættes
        var word = ""
        for(i in viewModel.uiState.word){
            if (viewModel.uiState.letterstried.contains(i)){
                word  += i              //hvis det bogstav som gættes på er rigtig bliver dette indsat istedet for stjernen
            }
            else {
                word += " * "             //hvis det bogstav som gættes på er forket, forbliver ordet
            }

        }

        //CurrentWord, ordet som skal gættes
        Text(
            text = word,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier.height(1.dp))



    // Brugte bogstaver

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center) {

            //Brugte bogstaver tekst
            Text(text = stringResource(id = R.string.brugtebogstaver),
                fontSize = 15.sp,
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier.width(5.dp))

            //Brugte bostaver
            Text(
                text = viewModel.uiState.letterstried.toString(),
                fontSize = 15.sp,
                //      modifier = Modifier.align(Alignment.CenterHorizontally)
            )

        }



        //tekstfelt og knap

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {




                TextField(
                    value = textFieldState,
                    label = {
                        Text("Indtast bogstav her...",
                            color = Color.Black)
                    },
                    onValueChange = {
                        textFieldState = it
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(16.dp))


                Row() {

                    //Spin knap
                    Button(onClick = {
                     //  viewModel.uiState.RandomPoints
                       viewModel.randompoints()


                    }, colors = ButtonDefaults.buttonColors(
                        backgroundColor = Teal200,
                        contentColor = Color.Black)) {

                        Text(text = "Spin")
                    }
                    
                    Spacer(modifier = Modifier.width(30.dp))

                    //Gæt knap
                    Button(onClick = {
                        if (textFieldState.length > 0){
                            viewModel.guess(textFieldState[0])      //tager gættet i tekstfeltet
                        }

                        // Besked
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Slet bogstavet igen for at se om det var korrekt")
                        }
                    }, colors = ButtonDefaults.buttonColors(
                        backgroundColor = Teal200,
                        contentColor = Color.Black)) {

                        Text("Gæt")
                    }

                }



            }
        }




        /*
        //Tekstfelt
        OutlinedTextField(
            value = viewModel.uiState.answer,
            onValueChange = {newText -> viewModel.uiState.answer},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier.height(1.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {

            Text(
                text = stringResource(R.string.start),
            )
 val pressable: Boolean = false - skal i viewmodel
        }
        */
    }

}

