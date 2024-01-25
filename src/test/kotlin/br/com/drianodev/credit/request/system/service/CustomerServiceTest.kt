package br.com.drianodev.credit.request.system.service

import br.com.drianodev.credit.request.system.dto.CustomerDto
import br.com.drianodev.credit.request.system.dto.CustomerUpdateDto
import br.com.drianodev.credit.request.system.entity.Address
import br.com.drianodev.credit.request.system.entity.Customer
import br.com.drianodev.credit.request.system.repository.CustomerRepository
import br.com.drianodev.credit.request.system.service.impl.CustomerService
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK lateinit var customerRepository: CustomerRepository
    @InjectMockKs lateinit var customerService: CustomerService

    @Test


    private fun builderCustomer(
        id: Long = 1L,
        firstName: String = "Adriano",
        lastName: String = "Lima",
        cpf: String = "28475934625",
        email: String = "adriano@email.com",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        password: String = "1234",
        zipcode: String = "000000",
        street: String = "Rua um, 123",
    ) = Customer(
        id = id,
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        email = email,
        income = income,
        password = password,
        address = Address(
            zipcode = zipcode,
            street = street
        )
    )
}