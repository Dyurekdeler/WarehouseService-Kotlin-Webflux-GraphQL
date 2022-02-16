package com.dyurekdeler.WarehouseService.service

import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.model.toDto
import com.dyurekdeler.WarehouseService.model.toEntity
import com.dyurekdeler.WarehouseService.repository.DeliveryRepository
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service

@Service
class DeliveryService(
    private val deliveryRepository: DeliveryRepository
) {

    suspend fun deliveries(isReceived: Boolean?): MutableList<DeliveryDto> {
        isReceived?.let {
            return deliveryRepository.findAllByIsReceived(isReceived).map { it.toDto() }.collectList().awaitFirst()
        } ?: return deliveryRepository.findAll().map { it.toDto() }.collectList().awaitFirst()
    }

    suspend fun delivery(id: Long): DeliveryDto? {
        return try {
            deliveryRepository.findById(id).awaitSingle().toDto()
        } catch (e: NoSuchElementException) {
            null
        }
    }

    suspend fun addDelivery(deliveryDto: DeliveryDto): DeliveryDto? {
        return deliveryRepository.save(deliveryDto.toEntity()).awaitSingle().toDto()
    }

    suspend fun addDeliveries(deliveryDtos: List<DeliveryDto>): List<DeliveryDto>? {
        return deliveryRepository.saveAll(deliveryDtos.map { it.toEntity() }).map { it.toDto() }.collectList().awaitSingle()
    }

    suspend fun updateDelivery(id: Long): DeliveryDto? {
        return try {
            val deliveryToUpdate = deliveryRepository.findById(id).awaitSingle()
            deliveryToUpdate.isReceived = true
            deliveryRepository.save(deliveryToUpdate).awaitSingle().toDto()
        } catch (e: NoSuchElementException) {
            null
        }
    }
}