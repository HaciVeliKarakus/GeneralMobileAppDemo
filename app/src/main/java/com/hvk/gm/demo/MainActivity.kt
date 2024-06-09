package com.hvk.gm.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import com.hvk.gm.demo.sections.HomeScreen
import com.hvk.gm.demo.setting.SettingScreen
import com.hvk.gm.demo.ui.theme.GeneralMobileAppDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
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
                                label = {
                                    Text(text = screen.title)
                                }
                            )
                        }
                    },
                    layoutType = when (windowWithClass) {
                        WindowWidthSizeClass.EXPANDED -> {
                            NavigationSuiteType.NavigationDrawer
                        }

                        else -> {
                            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(
                                currentWindowAdaptiveInfo()
                            )
                        }
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
//                            Screen.entries.forEachIndexed { index, screen ->
//                                if (selectedItemIndex == index) {
//                                    Text(text = screen.title)
//                                }
//
//
//                            }
                        when (selectedItemIndex) {
                            0 -> MainContent()
                            2 -> SettingScreen(
                                darkTheme = darkTheme,
                                onThemeUpdated = { darkTheme = !darkTheme }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MainContent() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.height(56.dp)
                )
            }
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            HomeScreen()
            HomeScreen()
        }
    }
}

enum class Screen(val title: String, val icon: ImageVector) {
    HOME("Home", Icons.Default.Home),
    WALLET("wallet", Icons.Default.Build),
    SETTINGS("settings", Icons.Default.Settings)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GeneralMobileAppDemoTheme {
        MainContent()
    }
}