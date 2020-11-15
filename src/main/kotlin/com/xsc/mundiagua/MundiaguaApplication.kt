package com.xsc.mundiagua

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class MundiaguaApplication {
	// silence console logging
	@Value("\${logging.level.root:OFF}")
	var message = ""
}

fun main(args: Array<String>) {
	runApplication<MundiaguaApplication>(*args)
}

