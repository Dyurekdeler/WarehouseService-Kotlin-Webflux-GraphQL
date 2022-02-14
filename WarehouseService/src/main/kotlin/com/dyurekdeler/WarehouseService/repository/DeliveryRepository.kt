package com.dyurekdeler.WarehouseService.repository

import com.dyurekdeler.WarehouseService.model.Delivery
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface DeliveryRepository: ReactiveCrudRepository<Delivery, Long> {
     fun findAllByIsReceived(@Param("isReceived") isReceived: Boolean): Flux<Delivery>
}