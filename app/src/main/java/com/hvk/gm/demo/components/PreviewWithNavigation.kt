package com.hvk.gm.demo.components

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator


@Composable
fun PreviewWithNavigation(content: @Composable () -> Unit) {
    Navigator(EmptyScreen) {
        content.invoke()
    }
}