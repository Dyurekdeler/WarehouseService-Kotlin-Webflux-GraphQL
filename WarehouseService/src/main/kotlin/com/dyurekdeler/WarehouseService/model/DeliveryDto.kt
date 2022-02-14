package com.dyurekdeler.WarehouseService.model

data class DeliveryDto(
    val id: Long? = null,
    val product: String,
    val supplier: String,
    val quantity: Long,
    val expectedDate: String,
    val expectedWarehouse: String,
)

fun DeliveryDto.toEntity(): Delivery = Delivery(
    id = id,
    product = product,
    supplier = supplier,
    quantity = quantity,
    expectedDate = expectedDate,
    expectedWarehouse = expectedWarehouse,
    isReceived = true
)