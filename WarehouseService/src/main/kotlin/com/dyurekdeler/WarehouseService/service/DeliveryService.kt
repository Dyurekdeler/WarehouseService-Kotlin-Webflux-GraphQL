package com.dyurekdeler.WarehouseService.service

import com.dyurekdeler.WarehouseService.model.DeliveryDto
import com.dyurekdeler.WarehouseService.model.toDto
import com.dyurekdeler.WarehouseService.model.toEntity
import com.dyurekdeler.WarehouseService.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactor.asFlux
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class DeliveryService(
    private val deliveryRepository: DeliveryRepository
) {

    suspend fun deliveries(isReceived: Boolean?): Flow<DeliveryDto> {
        isReceived?.let {
            return deliveryRepository.findAllByIsReceived(isReceived).map { it.toDto() }
        } ?: return deliveryRepository.findAll().map { it.toDto() }
    }

    suspend fun delivery(id: Long): DeliveryDto? {
        return try {
            deliveryRepository.findById(id)?.toDto()
        } catch (e: NoSuchElementException) {
            null
        }
    }

    suspend fun addDelivery(deliveryDto: DeliveryDto): DeliveryDto? {
        return deliveryRepository.save(deliveryDto.toEntity()).toDto()
    }

    suspend fun addDeliveries(deliveryDtos: List<DeliveryDto>): Flux<DeliveryDto>? {
        return deliveryRepository.saveAll(deliveryDtos.map { it.toEntity() }).map { it.toDto() }.asFlux()
    }

    suspend fun updateDelivery(id: Long): DeliveryDto? {
        return try {
            val deliveryToUpdate = deliveryRepository.findById(id)
            if (deliveryToUpdate != null) {
                deliveryToUpdate.isReceived = true
                deliveryRepository.save(deliveryToUpdate).toDto()
            }
            else
                throw NoSuchElementException()
        } catch (e: NoSuchElementException) {
            null
        }
    }

}