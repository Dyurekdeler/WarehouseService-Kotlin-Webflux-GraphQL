package com.dyurekdeler.WarehouseService.mutation

import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.service.DeliveryService
import com.expediagroup.graphql.server.operations.Mutation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactor.asFlux
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux


@Component
class DeliveryMutation(
    private val deliveryService: DeliveryService
): Mutation {

    suspend fun addDelivery(deliveryDto: DeliveryDto): DeliveryDto? {
        return deliveryService.addDelivery(deliveryDto)
    }

    suspend fun addDeliveries(deliveryDtos: List<DeliveryDto>): Flux<DeliveryDto>? {
        return deliveryService.addDeliveries(deliveryDtos)
    }

    suspend fun markDeliveryAsReceived(deliveryId: Long): DeliveryDto? {
        return deliveryService.updateDelivery(deliveryId)
    }

}