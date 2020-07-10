package com.example.kotlin_test

import java.math.BigDecimal
import org.jetbrains.annotations.TestOnly as TestOnly

fun main(args: Array<String>) {

//    print("Komiljon")

//    do {
//        val command = readLine()
//        println("command : $command")
//    } while (command != "quit" )
//
//    val words = "Java".."Yaml"
//    for (arg in words.toString()) {
//        print(arg)
//
//    }

//    print(japaneseSalary((22.07).toBigDecimal(), 1997))
//@TestOnly
//
//    assert
}

fun japaneseSalary(base: BigDecimal, year: Int): BigDecimal {
    require(base > BigDecimal.ZERO) { "Base salary can't be negative" }
    return base + 10_000.toBigDecimal() * year.toBigDecimal()
}
