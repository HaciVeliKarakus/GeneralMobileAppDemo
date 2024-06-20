package com.hvk.gm.demo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.hvk.gm.demo.screens.HomeScreen
import com.hvk.gm.demo.ui.theme.GeneralMobileAppDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun MainContent() {
    GeneralMobileAppDemoTheme() {
        Navigator(HomeScreen) {
            SlideTransition(navigator = it)
        }
    }
}
