package com.nagasia.pruebaskotlin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.nagasia.pruebaskotlin.R
import com.nagasia.pruebaskotlin.extension.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fextension.*

class FExtensionActivity : AppCompatActivity() {

    var titleLabel:Lazy<TextView> = bindView(R.id.main__title_label)
    var btn:Lazy<Button> = bindView(R.id.main__btn)
    var image:Lazy<ImageView> = bindView(R.id.main__icon)

    var titleLabelList: List<Lazy<TextView>> = bindViews(intArrayOf(
        R.id.main__label_to_hide1,
        R.id.main__label_to_hide2
    ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fextension)

        //image.value.loadUrl("https://www.linuxadictos.com/wp-content/uploads/openwebinars-logo.jpg")
        image.value.setImageResource(R.drawable.ic_launcher_background)
        titleLabel.value.setTextAndHideViewIfIsNeeded("Title Label")

        btn.value.setOnClickListener{
            titleLabelList.map {
                it.value.hide()
            }
        }

        showToast("hola",500)

        button2.text="siguiente"
        button2.setOnClickListener{
            val intent= Intent(this,FExtensionActivity::class.java)
            startActivity(intent)
        }


    }
}
