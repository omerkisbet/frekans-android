package com.nexrelay.relqoruimock

import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.model.DeliveryStageUi
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MockContractTest {

    @Test
    fun relayed_does_not_mean_server_delivered() {
        val state = MockData.delivery

        assertTrue(state.relayed)
        assertFalse(state.serverConfirmed)
        assertTrue(state.stage == DeliveryStageUi.RELAYED)
    }
}
