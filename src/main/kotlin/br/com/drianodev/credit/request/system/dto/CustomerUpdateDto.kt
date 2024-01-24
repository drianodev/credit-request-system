package br.com.drianodev.credit.request.system.dto

import br.com.drianodev.credit.request.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid input firstName") val firstName: String,
    @field:NotEmpty(message = "Invalid input lastName") val lastName: String,
    @field:NotNull(message = "Invalid input income") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input zipcode") val zipcode: String,
    @field:NotEmpty(message = "Invalid input street") val street: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipcode = this.zipcode
        customer.address.street = this.street
        return customer
    }
}
