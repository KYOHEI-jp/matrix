package com.example.matrix_rain.ui.theme

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import org.w3c.dom.Text

private val characters = listOf(
    "ジ",
    "ェ",
    "ッ",
    "ト",
    "パ",
    "Z",
    "A",
    "R",
    "Q",
    "ッ",
    "ク",
    "構",
    "成",
    "I",
    "L",
    "N",
    "K",
    "8",
    "7",
    "C",
    "6"
)

@Composable
fun MatrixRain() {
    MatrixColumn(1000)
}

@Composable
fun MatrixColumn(crawlSpeed: Long) {

    val matrixStrip = remember {
        Array(20) {
            characters.random()
        }
    }

    var lettersToDraw by remember { mutableStateOf(0) }

    repeat(lettersToDraw) {
        MatrixChar(char = matrixStrip[it], crawlSpeed = 1000)
    }

    LaunchedEffect(Unit) {
        while (lettersToDraw < matrixStrip.size) {
            lettersToDraw += 1
        }
    }
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
    Text(text = char, color = textColor.copy(alpha = alpha.value))

    LaunchedEffect(Unit) {
        delay(crawlSpeed)
        textColor = Color(0xffcefbe4)
        startFade = true
    }
}