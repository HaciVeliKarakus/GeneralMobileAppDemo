package com.hvk.gm.demo

//import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
//import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
//import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
//import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
//import androidx.window.core.layout.WindowWidthSizeClass
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.hvk.gm.demo.screens.home.HomeTab
import com.hvk.gm.demo.screens.setting.SettingScreen
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

        TabNavigator(HomeTab) { navigator ->
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(SettingScreen)
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { },
        label = { Text(text = tab.options.title) }
    )
}

@Composable
fun NavigateToDetailOf(screen: Screen) {
    Navigator(screen) {
        SlideTransition(navigator = it)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MainContent()
}
