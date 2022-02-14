package com.dyurekdeler.WarehouseService.service

import com.dyurekdeler.WarehouseService.model.Delivery
import com.dyurekdeler.WarehouseService.repository.DeliveryRepository
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service

@Service
class DeliveryService(
    private val deliveryRepository: DeliveryRepository
) {
    suspend fun deliveries(): MutableList<Delivery> {
        return deliveryRepository.findAll().collectList().awaitFirst()
    }

    suspend fun delivery(id: Long): Delivery? {
        return deliveryRepository.findById(id).awaitSingle()
    }

    suspend fun addDelivery(product: String): Delivery? {
        return deliveryRepository.save(Delivery(
            product = product
        )).awaitSingle()
    }

    suspend fun updateDelivery(id: Long, product: String): Delivery? {
        return deliveryRepository.save(Delivery(
            id = id,
            product = product
        )).awaitSingle()
    }
}