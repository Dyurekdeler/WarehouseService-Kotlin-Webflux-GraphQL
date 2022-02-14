package com.dyurekdeler.WarehouseService.model

import org.springframework.data.annotation.Id

data class Delivery(
    @Id
    val id: Long? = null,
    val product: String,
)
