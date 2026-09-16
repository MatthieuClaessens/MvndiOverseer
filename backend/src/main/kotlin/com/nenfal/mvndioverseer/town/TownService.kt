package com.nenfal.mvndioverseer.town

import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.UUID

@Service
@Transactional
class TownService(
    private val townRepository: TownRepository,
    private val townMapper: TownMapper
) {

    private fun ensureTownExists(townId: UUID): TownEntity {
        return townRepository.findById(townId)
            .orElseThrow {
                EntityNotFoundException("Town with id $townId not found")
            }
    }

    fun addTownRating(townId: UUID, townRate: BigDecimal): TownDTO {
        val town = ensureTownExists(townId)
        town.townRate = townRate
        return townMapper.toDTO(townRepository.save(town))
    }

    fun readTownRating(townId: UUID): BigDecimal? {
        val town = ensureTownExists(townId)
        return town.townRate
    }

    fun readAllTowns(): List<TownDTO> {
        return townRepository.findAll().map { townMapper.toDTO(it) }
    }

    fun editTownRating(townId: UUID, townRate: BigDecimal): TownDTO {
        val town = ensureTownExists(townId)
        town.townRate = (town.townRate ?: BigDecimal.ZERO) + townRate
        return townMapper.toDTO(townRepository.save(town));
    }

    fun deleteTownRating(townId: UUID): TownDTO {
        val town = ensureTownExists(townId)
        town.townRate = null
        return townMapper.toDTO(townRepository.save(town))
    }
}