package com.dyurekdeler.WarehouseService.mutation

import com.dyurekdeler.WarehouseService.model.Delivery
import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.service.DeliveryService
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.stereotype.Component


@Component
class DeliveryMutation(
    private val deliveryService: DeliveryService
): Mutation {

    suspend fun addDelivery(deliveryDto: DeliveryDto): Delivery? {
        return deliveryService.addDelivery(deliveryDto)
    }

    suspend fun updateDeliveryReceivedStatus(id: Long): Delivery? {
        return deliveryService.updateDelivery(id)
    }
}