package com.nenfal.mvndioverseer.town

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.DecimalMax

import java.math.BigDecimal
import java.util.UUID

data class TownDTO (
    val townId: UUID,
    var townMayorId: UUID,
    var townName: String,
    var townMayorName: String,

    @field:DecimalMin(value = "0.00", inclusive = true, message = "Town rate must be greater than or equal to 0.00")
    @field:DecimalMax(value = "1.00", inclusive = true, message = "Town rate must be less than or equal to 1.00")
    var townRate: BigDecimal? = null,
    )