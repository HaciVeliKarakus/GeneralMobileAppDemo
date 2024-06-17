package com.hvk.gm.demo.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.hvk.gm.demo.R
import com.hvk.gm.demo.screens.home.sections.ProductSection
import com.hvk.gm.demo.screens.home.sections.SliderSection


object HomeScreen:Screen{
    @Composable
    override fun Content() {
        Scaffold(
            topBar =
            {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                    )
                }
            })
        { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                item { SliderSection() }
                item { ProductSection() }
            }
        }
    }

}