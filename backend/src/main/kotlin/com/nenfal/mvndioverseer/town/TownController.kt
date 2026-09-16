package com.nenfal.mvndioverseer.town

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.UUID


@RestController
@RequestMapping("/api/towns")
@Validated
class TownController(
    private val townService: TownService
) {

    @GetMapping("/{townId}/rating")
    fun readTownRating(
        @PathVariable townId: UUID
    ): ResponseEntity<BigDecimal> {
        val rating = townService.readTownRating(townId)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(rating)
    }

    @GetMapping
    fun readAllTowns(): ResponseEntity<List<TownDTO>> {
        return ResponseEntity.ok(townService.readAllTowns())
    }

    @PostMapping("/{townId}/rating")
    fun addTownRating(
        @PathVariable townId: UUID,
        @RequestParam townRate: BigDecimal
    ): ResponseEntity<TownDTO> {
        return ResponseEntity.ok(townService.addTownRating(townId, townRate))
    }

    @PatchMapping("/{townId}/rating")
    fun editTownRating(
        @PathVariable townId: UUID,
        @RequestParam townRate: BigDecimal
    ): ResponseEntity<TownDTO> {
        return ResponseEntity.ok(townService.editTownRating(townId, townRate))
    }

    @DeleteMapping("/{townId}/rating")
    fun deleteTownRating(
        @PathVariable townId: UUID
    ): ResponseEntity<TownDTO> {
        return ResponseEntity.ok(townService.deleteTownRating(townId))
    }
}