package br.com.drianodev.credit.request.system.repository

import br.com.drianodev.credit.request.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>