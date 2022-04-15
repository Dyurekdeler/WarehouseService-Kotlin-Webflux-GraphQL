package com.dyurekdeler.WarehouseService.model

import java.time.Instant

data class DeliveryDto(
    val deliveryId: Long? = null,
    val product: String,
    val supplier: String,
    val quantity: Long,
    val expectedDate: Instant,
    val expectedWarehouse: String,
    val isReceived: Boolean? = false
)

fun DeliveryDto.toEntity(): Delivery = Delivery(
    id = deliveryId,
    product = product,
    supplier = supplier,
    quantity = quantity,
    expectedDate = expectedDate,
    expectedWarehouse = expectedWarehouse,
    isReceived = isReceived!!
)