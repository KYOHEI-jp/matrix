package com.example.matrix_rain.ui.theme

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import org.w3c.dom.Text

@Composable
fun MatrixRain() {
    MatrixChar(char = characters[5])
}

@Composable
fun MatrixChar(char: String, crawlSpeed: Long) {
    var textColor by remember { mutableStateOf(Color(0xffcefbe4)) }
    var startFade by remember { mutableStateOf(false) }
    val alpha = animateFloatAsState(
        targetValue = if (startFade) 0f else 1f,
        animationSpec = tween(
            durationMillis = 4000,
            easing = LinearEasing
        )
    )
    Text(text = char, color = textColor.copy(alpha = alpha))

    LaunchedEffect(Unit) {
        delay()
        textColor = Color(0xffcefbe4)
        startFade = true
    }
}