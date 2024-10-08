package com.hvk.gm.demo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hvk.gm.demo.R
import com.hvk.gm.demo.ui.theme.font
import com.hvk.gm.demo.ui.theme.orange

@Composable
fun ProductCard(product: Product, onclick: () -> Unit) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp

    Card(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .size(width - 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = orange,
        ),
    ) {
        Image(
            painter = painterResource(id = product.logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        )
        Text(
            text = product.title,
            fontSize = 18.sp,
            fontFamily = font,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = onclick) {
                Text(
                    text = "İncele >", color = orange,
                    fontWeight = FontWeight.Bold,
                    fontFamily = font
                )
            }

            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Hemen Satın Al >", color = orange,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                )
            }
        }
        Image(
            painterResource(id = product.image),
            contentDescription = "product",
            modifier = Modifier
                .fillMaxWidth()
                .height(width)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    ProductCard(products.first()) {

    }
}