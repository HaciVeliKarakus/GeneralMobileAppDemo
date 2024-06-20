package com.hvk.gm.demo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hvk.gm.demo.R


@Composable
fun ProductSection() {
    val navigator = LocalNavigator.currentOrThrow

    Column {
        products.forEach {
            ProductCard(it) {
                navigator.push(PhoneDetail(it.header, it.filename))
            }
        }
    }
}


val products = listOf(
    Product(
        logo = R.drawable.logo_png2,
        title = "Gücü Serbest Bırak",
        image = R.drawable.anasayfa_png4,
        header = "Phoenix 5G",
        filename = "gm_phoenix_5g.json"
    ),
    Product(
        logo = R.drawable.gm24_logo_black,
        title = "Karşı Konulmaz Performans",
        image = R.drawable.anasayfa_png,
        header = "GM 24 Pro",
        filename = "gm_24_pro.json"
    ),
    Product(
        logo = R.drawable.logo_gm23,
        title = "Aramızda Bir Çekim Var!",
        image = R.drawable.gm23_anasayfa_v3_png,
        header = "GM 23",
        filename = "gm_23.json"
    ),
    Product(
        logo = R.drawable.logo_gm23_se,
        title = "Tasarımda İkonik Dokunuş",
        image = R.drawable.gm23se_anasayfa_v2_png,
        header = "GM 23 SE",
        filename = "gm_23_se.json"
    )
)

data class Product(
    val logo: Int,
    val title: String,
    val image: Int,
    val header: String,
    val filename: String
)

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ProductSection()
}