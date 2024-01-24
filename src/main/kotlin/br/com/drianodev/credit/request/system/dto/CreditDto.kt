package br.com.drianodev.credit.request.system.dto

import br.com.drianodev.credit.request.system.entity.Credit
import br.com.drianodev.credit.request.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid input creditValue") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    @field:Max(value = 48, message = "Number of installments cannot be greater than 48")
    val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid input customerId") val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
