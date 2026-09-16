package com.nenfal.mvndioverseer.town

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "towns")
class TownEntity(
    @Id
    @Column(name = "town_id", updatable = false, nullable = false)
    val townId: UUID,

    @Column(name = "town_mayor_id", nullable = false)
    var townMayorId: UUID,


    @Column(name = "town_name", nullable = false)
    var townName: String,

    @Column(name = "town_mayor_name", nullable = false)
    var townMayorName: String,

    @Column(name = "town_rate", precision = 3, scale = 2)
    var townRate: BigDecimal? = null
)