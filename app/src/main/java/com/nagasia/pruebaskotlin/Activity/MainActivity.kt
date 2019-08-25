package com.nagasia.pruebaskotlin.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nagasia.pruebaskotlin.model.CarModel
import com.nagasia.pruebaskotlin.R
import com.nagasia.pruebaskotlin.adapter.CarAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var carList: MutableList<CarModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label.text="hola mundo 2!"
        button.text="Boton de prueba"

        initCarList()

        mainList.layoutManager=LinearLayoutManager(this)
        mainList.adapter=CarAdapter(carList,{
            Toast.makeText(this,it.brand,Toast.LENGTH_SHORT).show()
        })
    }

    private fun initCarList(){
        carList=(1..100).map{
            CarModel(
                brand = "Marca " + it.toString(),
                id = it.toString()
            )
        }.toMutableList()
    }
}
