package com.dyurekdeler.WarehouseService.repository

import com.dyurekdeler.WarehouseService.model.Delivery
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface DeliveryRepository: CoroutineCrudRepository<Delivery, Long> {
     fun findAllByIsReceived(@Param("isReceived") isReceived: Boolean): Flow<Delivery>
}