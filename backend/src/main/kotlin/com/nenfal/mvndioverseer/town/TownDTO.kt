package com.nenfal.mvndioverseer.town

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

import java.math.BigDecimal
import java.util.UUID

data class TownDTO (
    @field:NotNull(message = "Town ID is required")
    val townId: UUID,

    @field:NotNull(message = "Town Mayor ID is required")
    var townMayorId: UUID,

    @field:NotBlank(message = "Town name cannot be blank")
    var townName: String,

    @field:NotBlank(message = "Town mayor name cannot be blank")
    var townMayorName: String,

    @field:DecimalMin(value = "0.00", inclusive = true, message = "Town rate must be greater than or equal to 0.00")
    @field:DecimalMax(value = "1.00", inclusive = true, message = "Town rate must be less than or equal to 1.00")
    var townRate: BigDecimal? = null,
    )