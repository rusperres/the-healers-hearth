package com.example.thehealershearth.model

data class OrderData(val id: String, val date: String, val items: String, val total: String)

object OrderStorage {
    val mockData = mutableListOf(
        OrderData("Order #12345", "Date: 2026-05-20", "Items: 2x Elixir, 1x Frappe", "Total: Php 1200"),
        OrderData("Order #12344", "Date: 2026-05-19", "Items: 1x Healing Tea", "Total: Php 300"),
        OrderData("Order #12343", "Date: 2026-05-18", "Items: 3x Mana Potion", "Total: Php 900")
    )

    fun addOrder(items: String, total: String) {
        val nextId = 12346 + (mockData.size - 3)
        mockData.add(0, OrderData("Order #$nextId", "Date: 2026-05-20", items, total))
    }
}
