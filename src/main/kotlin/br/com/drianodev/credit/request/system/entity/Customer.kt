package br.com.drianodev.credit.request.system.entity

data class Customer(
    val id: Long? = null,
    var firstName: String = "",
    var lastName: String = "",
    val cpf: String,
    var email: String = "",
    var password: String = "",
    var address: Address = Address(),
    var credits: List<Credit> = mutableListOf()
)
