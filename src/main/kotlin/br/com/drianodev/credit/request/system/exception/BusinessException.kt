package br.com.drianodev.credit.request.system.exception

data class BusinessException(override val message: String?): RuntimeException(message)