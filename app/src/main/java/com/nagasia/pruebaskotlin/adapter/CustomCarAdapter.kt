package com.nagasia.pruebaskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nagasia.pruebaskotlin.R
import com.nagasia.pruebaskotlin.model.CarModel
import kotlinx.android.synthetic.main.row_car.view.*

class CustomCarAdapter(val items:List<CarModel>,val listener: CustomListener)
    :RecyclerView.Adapter<CustomCarAdapter.CarViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.row_car, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = items.get(position)
        holder.brandLabel.text = car.brand
        holder.check.isChecked = car.isSelected

        holder.itemView.setOnClickListener {
            holder.check.performClick()
        }

        holder.itemView.setOnLongClickListener {
            listener.longClickOnCarItem(car)
            true
        }

        holder.check.setOnCheckedChangeListener { _, isChecked ->
            car.isSelected = isChecked
            listener.clickOnCarItem(car)
        }
    }

    interface CustomListener {
        fun clickOnCarItem(carModel: CarModel)
        fun longClickOnCarItem(carModel: CarModel)
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandLabel = itemView.rowCarBrandLabel
        val check = itemView.rowCarSwitch
    }


}