package br.com.drianodev.credit.request.system.dto

import br.com.drianodev.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipcode: String,
    val street: String
) {

    constructor(customer: Customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipcode = customer.address.zipcode,
        street = customer.address.street
    )
}
