package me.saechimdaeki.redissession

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisSessionApplication

fun main(args: Array<String>) {
    runApplication<RedisSessionApplication>(*args)
}
