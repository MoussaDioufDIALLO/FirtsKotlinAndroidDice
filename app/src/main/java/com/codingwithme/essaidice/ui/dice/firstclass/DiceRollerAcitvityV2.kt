package com.codingwithme.essaidice.ui.dice.firstclass

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.codingwithme.essaidice.ui.theme.EssaiDiceTheme


class DiceRollerActivityV2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EssaiDiceTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    DiceRollerApp(DiceRollerViewModel())
                }
            }
        }
    } 
}

@Composable
fun DiceRollerApp(diceRollerViewModel: DiceRollerViewModel = DiceRollerViewModel()) {
    val uiState by diceRollerViewModel.uiState.collectAsState()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = uiState.imageToShow),
            contentDescription = stringResource(id = uiState.contentDescription)
        )
        Button(onClick = {
            diceRollerViewModel.handleUiEvent(DiceRollerViewModel.UiEvent.OnRollClicked)
        }) {
            Text(text = stringResource(id = uiState.buttonLabel))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    EssaiDiceTheme(){
        DiceRollerApp()
    }
}