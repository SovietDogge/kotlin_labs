package com.example.myapplication

open class Item(val name: String, val price: Double) {
    open fun calculateCost(): Double {
        return price
    }
}

class Product(name: String, price: Double, val weight: Double) : Item(name, price) {
    override fun calculateCost(): Double {
        return price * weight
    }
}

class Electronics(name: String, price: Double, val warranty: Int) : Item(name, price)

class Clothing(name: String, price: Double, val size: String) : Item(name, price)

fun main() {
    val product = Product("Apples", 2.5, 1.5)
    println("Cost of product: ${product.calculateCost()}")

    val electronics = Electronics("Smartphone", 1000.0, 12)
    println("Cost of electronics: ${electronics.calculateCost()}")

    val clothing = Clothing("T-shirt", 20.0, "M")
    println("Cost of clothing: ${clothing.calculateCost()}")
}
