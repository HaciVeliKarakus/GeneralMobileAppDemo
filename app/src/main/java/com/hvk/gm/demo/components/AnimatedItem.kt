package com.hvk.gm.demo.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun AnimatedItem(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    var visiblity by remember {
        mutableStateOf(false)
    }

    AnimatedVisibility(
        visible = visiblity,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column {
            content()
        }

    }

    LaunchedEffect(Unit) {
        visiblity = true
    }
}
