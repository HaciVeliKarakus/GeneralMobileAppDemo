package com.hvk.gm.demo.screens.home.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.hvk.gm.demo.R
import com.hvk.gm.demo.screens.home.PhoneDetailScreens


@Composable
fun ProductSection() {
    val navigator = LocalNavigator.currentOrThrow

    Column {
        products.forEach {
            ProductCard(it)


        }
    }
}


val products = listOf(
    Product(
        logo = R.drawable.logo_png2,
        title = "Gücü Serbest Bırak",
        image = R.drawable.anasayfa_png4,
        screen = PhoneDetailScreens.PHOENIX_5G
    ),
    Product(
        logo = R.drawable.logo_png,
        title = "Karşı Konulmaz Performans",
        image = R.drawable.anasayfa_png,
        screen = PhoneDetailScreens.PHOENIX_5G

    ),
    Product(
        logo = R.drawable.logo_gm23,
        title = "Aramızda Bir Çekim Var!",
        image = R.drawable.gm23_anasayfa_v3_png,
        screen = PhoneDetailScreens.PHOENIX_5G

    ),
    Product(
        logo = R.drawable.logo_gm23_se,
        title = "Tasarımda İkonik Dokunuş",
        image = R.drawable.gm23se_anasayfa_v2_png,
        screen = PhoneDetailScreens.PHOENIX_5G

    )
)

data class Product(
    val logo: Int,
    val title: String,
    val image: Int,
    val screen: PhoneDetailScreens
)

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ProductSection()
}