package br.com.drianodev.credit.request.system.dto

import br.com.drianodev.credit.request.system.entity.Address
import br.com.drianodev.credit.request.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid input firstName") val firstName: String,
    @field:NotEmpty(message = "Invalid input lastName") val lastName: String,
    @field:NotEmpty(message = "Invalid input CPF")
    @field:CPF(message = "Invalid input CPF") val cpf: String,
    @field:NotNull(message = "Invalid input income") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input email") val email: String,
    @field:NotEmpty(message = "Invalid input password") val password: String,
    @field:NotEmpty(message = "Invalid input zipcode") val zipcode: String,
    @field:NotEmpty(message = "Invalid input street") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipcode = this.zipcode,
            street = this.street
        )
    )
}
