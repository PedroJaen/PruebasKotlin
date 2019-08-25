package com.nagasia.pruebaskotlin.model

class CarModel(var brand: String, var id: String) : ISelectable {
    override var isSelected: Boolean = false
}