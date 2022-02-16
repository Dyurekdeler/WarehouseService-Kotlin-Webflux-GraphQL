package com.dyurekdeler.WarehouseService.query

import com.dyurekdeler.WarehouseService.model.Delivery
import com.dyurekdeler.WarehouseService.service.DeliveryService
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component


@Component
class DeliveryQuery(
    private val deliveryService: DeliveryService
): Query {


    suspend fun deliveries(isReceived: Boolean? = null): MutableList<Delivery> {
        return deliveryService.deliveries(isReceived)
    }

    suspend fun delivery(id: Long): Delivery? {
        return deliveryService.delivery(id)
    }

}