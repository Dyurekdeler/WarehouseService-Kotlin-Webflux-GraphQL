package com.dyurekdeler.WarehouseService.model

import org.springframework.data.annotation.Id
import java.time.Instant

data class Delivery(
    @Id
    val id: Long? = null,
    val product: String,
    val supplier: String,
    val quantity: Long,
    val expectedDate: Instant,
    val expectedWarehouse: String,
    var isReceived: Boolean = false
)

fun Delivery.toDto(): DeliveryDto = DeliveryDto(
    deliveryId = id,
    product = product,
    supplier = supplier,
    quantity = quantity,
    expectedDate = expectedDate,
    expectedWarehouse = expectedWarehouse,
    isReceived = isReceived
)