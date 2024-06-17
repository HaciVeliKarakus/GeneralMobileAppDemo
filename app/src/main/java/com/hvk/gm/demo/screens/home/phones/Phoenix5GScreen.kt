package com.hvk.gm.demo.screens.home.phones

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.hvk.gm.demo.components.AutoBackScaffold

object Phoenix5GScreen : Screen {
    private fun readResolve(): Any = Phoenix5GScreen

    @Composable
    override fun Content() {
        AutoBackScaffold(title = "Phoenix 5G") {

        }
    }
}