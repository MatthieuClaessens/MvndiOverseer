package com.nenfal.mvndioverseer.town

import java.math.BigDecimal
import java.util.UUID

data class TownDTO (
    val townId: UUID,
    var townMayorId: UUID,
    var townName: String,
    var townMayorName: String,
    var townRate: BigDecimal? = null,
    )