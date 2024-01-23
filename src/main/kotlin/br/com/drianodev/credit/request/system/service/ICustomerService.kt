package br.com.drianodev.credit.request.system.service

import br.com.drianodev.credit.request.system.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long): Customer
}