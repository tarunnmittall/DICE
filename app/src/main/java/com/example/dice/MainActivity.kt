package com.example.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dice.ui.theme.DICETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DICETheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}


@Composable
fun DiceWithButtonAndImage() {
    val result by remember{ mutableStateOf(1) }
    val imageResource= when(result){
        1-> R.drawable.one
        2-> R.drawable.two
        3-> R.drawable.three
        4-> R.drawable.four
        5-> R.drawable.five
        6-> R.drawable.six
        else-> R.drawable.start
    }
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter= painterResource( imageResource),contentDescription=result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { (1..6).random() }) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}