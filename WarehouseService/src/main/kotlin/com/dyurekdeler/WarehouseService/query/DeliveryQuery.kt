package com.dyurekdeler.WarehouseService.query

import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.service.DeliveryService
import com.expediagroup.graphql.server.operations.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.reactor.asFlux
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux


@Component
class DeliveryQuery(
    private val deliveryService: DeliveryService
): Query {

    suspend fun deliveries(isReceived: Boolean? = null): Flux<DeliveryDto> {
        return deliveryService.deliveries(isReceived).asFlux()
    }

    suspend fun delivery(deliveryId: Long): DeliveryDto? {
        return deliveryService.delivery(deliveryId)
    }

}