package com.dyurekdeler.WarehouseService.service

import com.dyurekdeler.WarehouseService.model.Delivery
import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.model.toEntity
import com.dyurekdeler.WarehouseService.repository.DeliveryRepository
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service

@Service
class DeliveryService(
    private val deliveryRepository: DeliveryRepository
) {

    suspend fun deliveries(isReceived: Boolean?): MutableList<Delivery> {
        isReceived?.let {
            return deliveryRepository.findAllByIsReceived(isReceived).collectList().awaitFirst()
        } ?: return deliveryRepository.findAll().collectList().awaitFirst()
    }

    suspend fun delivery(id: Long): Delivery? {
        return deliveryRepository.findById(id).awaitSingle()
    }

    suspend fun addDelivery(deliveryDto: DeliveryDto): Delivery? {
        return deliveryRepository.save(deliveryDto.toEntity()).awaitSingle()
    }

    suspend fun updateDelivery(id: Long): Delivery? {
        val deliveryToUpdate = deliveryRepository.findById(id).awaitSingle()
        deliveryToUpdate?.let {
            deliveryToUpdate.isReceived = true
            return deliveryRepository.save(deliveryToUpdate).awaitSingle()
        } ?: return null

    }
}