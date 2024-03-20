package com.example.myapplication

// Parent class
open class Item(val name: String, val price: Double) {
    // Method to calculate the cost
    open fun calculateCost(): Double {
        return price
    }
}

// Subclass for products
class Product(name: String, price: Double, val weight: Double) : Item(name, price) {
    // Overridden method to calculate the cost
    override fun calculateCost(): Double {
        return price * weight
    }
}

// Subclass for electronics
class Electronics(name: String, price: Double, val warranty: Int) : Item(name, price)

// Subclass for clothing
class Clothing(name: String, price: Double, val size: String) : Item(name, price)

fun main() {
    val product = Product("Apples", 2.5, 1.5)
    println("Cost of product: ${product.calculateCost()}")

    val electronics = Electronics("Smartphone", 1000.0, 12)
    println("Cost of electronics: ${electronics.calculateCost()}")

    val clothing = Clothing("T-shirt", 20.0, "M")
    println("Cost of clothing: ${clothing.calculateCost()}")
}