package com.nenfal.mvndioverseer.town

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TownRepository : JpaRepository<TownEntity, UUID> {

}
