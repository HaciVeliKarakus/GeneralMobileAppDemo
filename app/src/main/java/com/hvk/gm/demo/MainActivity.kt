package com.hvk.gm.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Monitor
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.window.core.layout.WindowWidthSizeClass
import com.hvk.gm.demo.screens.home.HomeScreen
import com.hvk.gm.demo.screens.setting.SettingScreen
import com.hvk.gm.demo.ui.theme.GeneralMobileAppDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            MainContent()
        }
    }
}

@Composable
private fun MainContent() {
    var darkTheme by remember { mutableStateOf(false) }

    GeneralMobileAppDemoTheme(darkTheme = darkTheme) {
        var selectedItemIndex by remember {
            mutableIntStateOf(0)
        }
        val windowWithClass =
            currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                Screen.entries.forEachIndexed { index, screen ->
                    item(
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title
                            )
                        },
//                        label = {
//                            Text(
//                                text = screen.title,
//                                textAlign = TextAlign.Center
//                            )
//                        }
                    )
                }
            },
//            layoutType = when (windowWithClass) {
//                WindowWidthSizeClass.EXPANDED -> {
//                    NavigationSuiteType.NavigationDrawer
//                }
//
//                else -> {
//                    NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(
//                        currentWindowAdaptiveInfo()
//                    )
//                }
//            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (selectedItemIndex) {
                    0 -> HomeScreen()
                    1 -> HomeScreen()
                    2 -> HomeScreen()
                    3 -> SettingScreen(
                        darkTheme = darkTheme,
                        onThemeUpdated = { darkTheme = !darkTheme }
                    )
                }
            }
        }
    }
}

enum class Screen(val title: String, val icon: ImageVector) {
    SMART_PHONES("Akıllı Telefonlar", Icons.Default.Smartphone),
    SMART_DEVICES("Akıllı Cihazlar", Icons.Default.Monitor),
    REPAIRED_DEVICES("Yenilenmiş Ürünler", Icons.Default.Recycling),
    SETTINGS("Ayarlar", Icons.Default.Settings)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MainContent()
}