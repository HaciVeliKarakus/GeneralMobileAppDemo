package com.hvk.gm.demo.data

import kotlinx.serialization.Serializable

@Serializable
data class Phone(
    val logo: String?,
    val image: String?,
    val text: String?,
    val title: String?,
    val backgroundImage: String?,
    val isReversed: Boolean = false,
    val video: String?
)