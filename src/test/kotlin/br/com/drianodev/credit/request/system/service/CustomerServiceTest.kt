package br.com.drianodev.credit.request.system.service

import br.com.drianodev.credit.request.system.entity.Address
import br.com.drianodev.credit.request.system.entity.Customer
import br.com.drianodev.credit.request.system.exception.BusinessException
import br.com.drianodev.credit.request.system.repository.CustomerRepository
import br.com.drianodev.credit.request.system.service.impl.CustomerService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK
    lateinit var customerRepository: CustomerRepository

    @InjectMockKs
    lateinit var customerService: CustomerService

    @Test
    fun `should create customer`() {
        // given
        val fakeCustomer: Customer = builderCustomer()
        every { customerRepository.save(any()) } returns fakeCustomer
        // when
        val actual: Customer = customerService.save(fakeCustomer)
        // then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }

    @Test
    fun `should find customer by id`() {
        // given
        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = builderCustomer(id = fakeId)
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)
        // when
        val actual: Customer = customerService.findById(fakeId)
        // then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Customer::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should not find customer by invalid id and throw BusinessException`() {
        // given
        val fakeId: Long = Random().nextLong()
        every { customerRepository.findById(fakeId) } returns Optional.empty()
        // when
        // then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
            .isThrownBy { customerService.findById(fakeId) }
            .withMessage("Id $fakeId not found")
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should delete customer by id`() {
        // given
        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = builderCustomer(id = fakeId)
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)
        every { customerRepository.delete(fakeCustomer) } just runs
        // when
        customerService.delete(fakeId)
        // then
        verify(exactly = 1) { customerRepository.findById(fakeId) }
        verify(exactly = 1) { customerRepository.delete(fakeCustomer) }
    }

    companion object {
        fun builderCustomer(
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
}