package com.hvk.gm.demo.screens.home.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hvk.gm.demo.R


@Composable
fun ProductSection() {
    Column {
        products.forEach{
            ProductCard(it)
        }
    }
}


val products = listOf(
    Product(
        logo = R.drawable.logo_png2,
        title = "Gücü Serbest Bırak",
        image = R.drawable.anasayfa_png4
    ),
    Product(
        logo = R.drawable.logo_png,
        title = "Karşı Konulmaz Performans",
        image = R.drawable.anasayfa_png
    ),
    Product(
        logo = R.drawable.logo_gm23,
        title = "Aramızda Bir Çekim Var!",
        image = R.drawable.gm23_anasayfa_v3_png
    ),
    Product(
        logo = R.drawable.logo_gm23_se,
        title = "Tasarımda İkonik Dokunuş",
        image = R.drawable.gm23se_anasayfa_v2_png
    )
)

data class Product(
    val logo: Int,
    val title: String,
    val image: Int
)

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ProductSection()
}