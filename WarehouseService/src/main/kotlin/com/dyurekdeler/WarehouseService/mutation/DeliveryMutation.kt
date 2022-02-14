package com.dyurekdeler.WarehouseService.mutation

import com.dyurekdeler.WarehouseService.model.Delivery
import com.dyurekdeler.WarehouseService.service.DeliveryService
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.stereotype.Component


@Component
class DeliveryMutation(
    private val deliveryService: DeliveryService
): Mutation {

    suspend fun addDelivery(product: String): Delivery? {
        return deliveryService.addDelivery(product)
    }

    suspend fun updateDelivery(id: Long, product: String): Delivery? {
        return deliveryService.updateDelivery(id, product)
    }
}