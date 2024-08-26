import org.junit.Test

import org.junit.Assert.*
import ru.netolohy.commission

class MainKtTest {

    @Test
    fun commissionVK_pay() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 10000
        val cntDay = 10000
        val cntMonth = 25000
        val cardType ="VK Pay"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(0, result)
    }
    @Test
    fun commissionVK_payOverlimit() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 10000
        val cntDay = 10000
        val cntMonth = 50000
        val cardType ="VK Pay"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun commissionVisaOverlimit() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 200000
        val cntDay = 250000
        val cntMonth = 425000
        val cardType ="Visa"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun commissionVisa() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 10000
        val cntDay = 10000
        val cntMonth = 40000
        val cardType ="Visa"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(75, result)
    }
    @Test
    fun commissionMastercardOverlimit() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 200000
        val cntDay = 250000
        val cntMonth = 425000
        val cardType ="Mastercard"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun commissionMastercard() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 10000
        val cntDay = 10000
        val cntMonth = 40000
        val cardType ="Mastercard"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(0, result)
    }

    @Test
    fun commissionMastercardTransfer1() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 80000
        val cntDay = 80000
        val cntMonth = 140000
        val cardType ="Mastercard"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(410, result)
    }

    @Test
    fun commissionBadCardtype() {
        val ERROR_LIMIT = -100
        val ERROR_CARD_TYPE = -200
        val amount = 10000
        val cntDay = 10000
        val cntMonth = 40000
        val cardType ="Union"
        val result = commission(amount, cntDay, cntMonth, cardType)
        assertEquals(ERROR_CARD_TYPE, result)
    }
}