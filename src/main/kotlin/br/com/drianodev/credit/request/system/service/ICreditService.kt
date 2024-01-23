package br.com.drianodev.credit.request.system.service

import br.com.drianodev.credit.request.system.entity.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit
    fun findAllByCustomer(CustomerId: Long): List<Credit>
    fun findByCreditCode(creditCode: UUID): Credit
}