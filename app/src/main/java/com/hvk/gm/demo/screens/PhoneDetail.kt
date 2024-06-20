package com.hvk.gm.demo.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.rememberAsyncImagePainter
import com.hvk.gm.demo.components.AutoBackScaffold
import com.hvk.gm.demo.components.BodyText
import com.hvk.gm.demo.components.HeaderText
import com.hvk.gm.demo.components.Image
import com.hvk.gm.demo.components.VideoPlayer
import com.hvk.gm.demo.data.Phone
import com.hvk.gm.demo.loadJsonFromAssets
import com.hvk.gm.demo.parseJson

data class PhoneDetail(
    val title: String,
    val filename: String
) : Screen {

    @Composable
    override fun Content() {
        AutoBackScaffold(title = title) {
            val context = LocalContext.current
            var items by remember { mutableStateOf(emptyList<Phone>()) }

            LaunchedEffect(Unit) {
                val jsonString = loadJsonFromAssets(context, filename)
                if (jsonString != null) {
                    items = parseJson<List<Phone>>(jsonString)
                }
            }

            val scrollState = rememberLazyListState()

            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item { Spacer(modifier = Modifier.height(24.dp)) }
                itemsIndexed(items) { index, phone ->
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
                    val backColor = if (phone.isReversed) Color.Black else Color.White
                    val textColor = if (phone.isReversed) Color.White else Color.Black
                    Column(
                        modifier = Modifier
                            .alpha(animatableAlpha.value)
                            .background(backColor)
                            .wrapContentHeight()
                            .paint(
                                rememberAsyncImagePainter(
                                    model = phone.backgroundImage,
                                    contentScale = ContentScale.FillBounds
                                )
                            )
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {

                        phone.logo?.let { it1 -> Image(it1) }
                        phone.title?.let { it1 -> HeaderText(it1, textColor) }
                        phone.image?.let { it1 -> Image(it1) }
                        phone.video?.let { it1 -> VideoPlayer(it1) }
                        phone.text?.let { it1 -> BodyText(it1, textColor) }
                    }
                }
            }
        }
    }
}