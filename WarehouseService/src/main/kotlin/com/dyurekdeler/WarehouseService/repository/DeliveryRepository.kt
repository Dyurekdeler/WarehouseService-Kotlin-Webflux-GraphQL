package com.dyurekdeler.WarehouseService.repository

import com.dyurekdeler.WarehouseService.model.Delivery
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DeliveryRepository: ReactiveCrudRepository<Delivery, Long> {
}