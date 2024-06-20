package com.hvk.gm.demo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hvk.gm.demo.ui.theme.font

@Composable
fun HeaderText(text: String, textColor: Color) {
    Text(
        text = text.ifEmpty { return },
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = font,
        color = textColor,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    )
}