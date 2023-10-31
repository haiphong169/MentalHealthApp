package com.haiphong.mentalhealthapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haiphong.mentalhealthapp.UserAuthentication

@Composable
fun IntroScreen(modifier: Modifier = Modifier, onNextButtonClicked: () -> Unit) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Intro Screen")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onNextButtonClicked) {
            Text(text = "To Sign In Screen")
        }
    }
}
