package com.nenfal.mvndioverseer.town

import org.springframework.stereotype.Component

@Component
class TownMapper {
    fun toEntity(dto: TownDTO): TownEntity {
        return TownEntity(
            townId = dto.townId,
            townMayorId = dto.townMayorId,
            townName = dto.townName,
            townMayorName = dto.townMayorName,
            townRate = dto.townRate
        )
    }

    fun toDTO(entity: TownEntity): TownDTO {
        return TownDTO(
            townId = entity.townId,
            townMayorId = entity.townMayorId,
            townName = entity.townName,
            townMayorName = entity.townMayorName,
            townRate = entity.townRate
        )
    }
}