package com.nagasia.pruebaskotlin.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nagasia.pruebaskotlin.R
import kotlinx.android.synthetic.main.activity_lambdas.*
import java.util.*

class Lambdas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambdas)


        btn.setOnClickListener {
            val text = textInput.text.toString()
            val number = if (text.count() > 0) text.toInt() else 0
            processNumber(number, {
                textInput.setTextColor(Color.RED)
            }, {
                textInput.setTextColor(Color.GREEN)
            })
        }

        executeIfIsNougatOrAbove {
            Toast.makeText(this@Lambdas,"Ejecutar código",Toast.LENGTH_SHORT).show()
            //- Usamos una lamba para que el factorial se ejecute en segundo plano
            executeInBackground { factorial(90000000) }
        }


        button3.text="siguiente"
        button3.setOnClickListener{
            val intent= Intent(this,Lambdas::class.java)
            startActivity(intent)
        }
    }

    private inline fun executeInBackground(crossinline function: () -> Unit) {
        val hilo=Thread({ function() }).start()
    }

    private inline fun executeIfIsNougatOrAbove(function: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            function()
        }
    }

    private inline fun processNumber(number: Int, executeIfIsPair: () -> Unit,
                                     executeIfNot: () -> Unit) {
        if (number % 2 == 0) executeIfIsPair() else executeIfNot()
    }

    private fun factorial(number: Int): Long {
        val init = Calendar.getInstance().timeInMillis
        var result: Long = 1
        for (i in 1..number) {
            result *= i.toLong()
        }
        val end = Calendar.getInstance().timeInMillis
        Log.d("Factorial", "Tiempo de cálculo: " + (end - init))
        return result
    }
}
