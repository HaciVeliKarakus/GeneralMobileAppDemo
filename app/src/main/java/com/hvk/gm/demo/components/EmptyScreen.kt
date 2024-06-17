package com.hvk.gm.demo.components

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object EmptyScreen : Screen {
    private fun readResolve(): Any = EmptyScreen

    @Composable
    override fun Content() {

    }

}
