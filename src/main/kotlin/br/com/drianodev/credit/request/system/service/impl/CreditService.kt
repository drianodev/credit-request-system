package br.com.drianodev.credit.request.system.service.impl

import br.com.drianodev.credit.request.system.entity.Credit
import br.com.drianodev.credit.request.system.repository.CreditRepository
import br.com.drianodev.credit.request.system.service.ICreditService
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}