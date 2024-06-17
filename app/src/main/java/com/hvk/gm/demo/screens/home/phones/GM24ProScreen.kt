package com.hvk.gm.demo.screens.home.phones

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.hvk.gm.demo.R
import com.hvk.gm.demo.components.AutoBackScaffold

object GM24ProScreen : Screen {
    private fun readResolve(): Any = GM24ProScreen

    @Composable
    override fun Content() {
        ContentUI()
    }


}

@Composable
private fun ContentUI() {
    AutoBackScaffold(title = "GM 24 Pro") {
        TopSection()
        Section2()
    }
}

@Composable
fun Section2() {

}

@Composable
fun TopSection() {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(List(100) { it }) { index, item ->
//            AnimatedItem {
            val animatableAlpha = remember { Animatable(0f) }
            val isVisible = remember {
                derivedStateOf {
                    scrollState.firstVisibleItemIndex <= index
                }
            }

            LaunchedEffect(isVisible.value) {
                if (isVisible.value) {
                    animatableAlpha.animateTo(
                        1f, animationSpec = tween(durationMillis = 1000)
                    )
                }
            }

            Row(modifier = Modifier.alpha( animatableAlpha.value)) {
                Image(
                    painterResource(id = R.drawable.gm24pro_top),
                    contentDescription = null,
                )
            }

//        it                }em {
//                      }  AnimatedItem {
//                Image(
//                    painterResource(id = R.drawable.gm24_logo_black),
//                    contentDescription = "logo"
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//            }
//        }
//        item {
//            AnimatedItem {
//                Text(
//                    text = "Karşı Konulmaz Performans",
//                    fontSize = 24.sp,
//                    fontFamily = font
//                )
//                Spacer(modifier = Modifier.height(24.dp))
//            }
//        }
//        item {
//            AnimatedItem {
//                Image(
//                    painterResource(id = R.drawable.gm24pro_top),
//                    contentDescription = null,
//                )
//                Spacer(modifier = Modifier.height(24.dp))
//            }
//        }
//        item {
//            AnimatedItem {
//                Text(
//                    text = "Gücün İncelikle Buluşması",
//                    fontFamily = font,
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Spacer(modifier = Modifier.height(24.dp))
//            }
//        }
//        item {
//            AnimatedItem {
//                Text(
//                    text = "Beyaz Kuğu ve Gri Gölge renkleriyle GM 24 Pro, zarafet ve gücün mükemmel uyumunu ultra ince gövdesinde bir araya getiriyor",
//                    textAlign = TextAlign.Center,
//                    fontSize = 16.sp
//                )
//                Image(
//                    painterResource(id = R.drawable.gm24_pro_white),
//                    contentDescription = null,
//                )
//            }
//        }


        }
    }
}