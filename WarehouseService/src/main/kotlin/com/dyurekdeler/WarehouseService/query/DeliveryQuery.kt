package com.dyurekdeler.WarehouseService.query

import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.service.DeliveryService
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component


@Component
class DeliveryQuery(
    private val deliveryService: DeliveryService
): Query {


    suspend fun deliveries(isReceived: Boolean? = null): MutableList<DeliveryDto> {
        return deliveryService.deliveries(isReceived)
    }

    suspend fun delivery(deliveryId: Long): DeliveryDto? {
        return deliveryService.delivery(deliveryId)
    }

}