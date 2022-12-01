package com.example.s213370lykkehjulet.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.s213370lykkehjulet.data.*

data class lykkehjulUiState(
    var word:String = "",               //ord som skal gættes
    val category:String = "",           //ordets kategori
    var points:Int = 0,                 //spillerens optjente point
    val pointsresult:Int = 0,           //ordets givende point
    var lives:Int = 0,                  //spillerens nuværende liv
    val titel:String = "",              //Spillets titel
    val answer:String = "",             //spillerens gæt
    val bankrupt:Boolean = false,       //bankerot
    val letterstried:MutableList<Char> = mutableListOf(),
    val gamestart:Boolean = false,      //er spillet startet
    var gamewon:Boolean = false,        //er spillet vundet
    val gamelost:Boolean = false,        //er spillet tabt
    var wordpoints:Int = 0,
    var RandomPoints:Int = 0,
    val rules:String = ""

)

class LykkehjulViewModel : ViewModel() {



    var uiState by mutableStateOf(lykkehjulUiState())
    init {
        uiState = lykkehjulUiState(
            word = "_ _ _",
            category = kategorier.random(),
            points = 0,
            lives = 5,
            titel = "Velkommen til Lykkehjulet!",
            answer = "indtast bogstav her..." ,
            pointsresult = 0,
            rules = "1. Indtast bogstav                   2. Klik på gæt knap "
            )

        randomword()
        randompoints()

    }

    //metode til vilkårligt ord
    fun randomword(){
        if (uiState.category == "Dyr"){
            uiState.word = Dyr.random()
    //        uiState.wordpoints = wordpoint.random()
        }

        if (uiState.category == "Bilmærker"){
            uiState.word = Bilmærker.random()
    //        uiState.wordpoints = wordpoint.random()
        }

        if (uiState.category == "Lande"){
            uiState.word = Lande.random()
    //        uiState.wordpoints = wordpoint.random()
        }

    }



    //gættemetode
    fun guess(c:Char){
        uiState.letterstried.add(c)
        if(!uiState.word.contains(c)){
            uiState.lives = uiState.lives - 1     //hvis ordet ikke indeholder bogstavet fratrækkes 1 liv
        }
        if (uiState.word.contains(c)){
                uiState.points = uiState.points + uiState.RandomPoints      //hvis bogstav er i ord, tillæges pointværdien til spillerens point
        }
    }


    //metode til vilkårlig pointværdi
    fun randompoints(){
        uiState.RandomPoints = wordpoint.random()

    }







/*
    fun isWordCorrect(): Boolean {
        for (i in uiState.word.indices) {
            if (uiState.word[i] == " * ") {
                return false
            }
        }
        return true
    }
*/
}