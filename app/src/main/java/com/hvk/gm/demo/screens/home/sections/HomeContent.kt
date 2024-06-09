package com.hvk.gm.demo.screens.home.sections

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hvk.gm.demo.data.sliderImages
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent() {
    val pagerState = rememberPagerState(
        initialPage = 0
    ) {
        sliderImages.size
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            scope.launch {
                pagerState.animateScrollToPage(
                    page = if (pagerState.currentPage < pagerState.pageCount - 1) {
                        pagerState.currentPage + 1
                    } else {
                        0
                    }
                )
            }
        }
    }

    Box(modifier = Modifier.height(560.dp)) {

        HorizontalPager(state = pagerState) {
            Image(
                painterResource(id = sliderImages[it]),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize()
            )
        }
        Row(modifier = Modifier.align(Alignment.Center)) {
            SliderArrowIcon(Icons.Default.KeyboardArrowLeft) {
                scope.launch {
                    pagerState.animateScrollToPage(
                        page = (pagerState.currentPage - 1 + pagerState.pageCount) % pagerState.pageCount
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            SliderArrowIcon(Icons.Default.KeyboardArrowRight) {
                scope.launch {
                    pagerState.animateScrollToPage(
                        page = (pagerState.currentPage + 1) % pagerState.pageCount
                    )
                }
            }
        }
        LazyRow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(sliderImages.size) { iteration ->
                val color = if (pagerState.currentPage == iteration)
                    Color.DarkGray
                else Color.LightGray
                val size = if (pagerState.currentPage == iteration) 12.dp else 8.dp
                item(key = "item$iteration") {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(color, CircleShape)
                            .size(size)
                    )
                }
            }
        }
    }
}

@Composable
private fun SliderArrowIcon(icon: ImageVector, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier
                .shadow(1.dp, shape = CircleShape)
                .size(40.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    HomeContent()
}
