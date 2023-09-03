package com.example.primeraapp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.primeraapp.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MainveiwModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edittext1 = findViewById<TextInputEditText>(R.id.edit_text1)
        val edittext2 = findViewById<TextInputEditText>(R.id.edit_text2)
        val boton1 = findViewById<AppCompatButton>(R.id.boton1)
        val boton2 = findViewById<AppCompatButton>(R.id.boton2)
        val resultado = findViewById<TextView>(R.id.texto2)
        val fondo = findViewById<ConstraintLayout>(R.id.Fondo)

        myViewModel = ViewModelProvider(this).get(MainveiwModel::class.java)
        myViewModel.result.observe(this, Observer { valor ->
           resultado.text = valor.toString()
        })
        boton1.setOnClickListener {
             val texto = edittext1.text.toString()
             val texto1 = edittext2.text.toString()
             esconderTeclado(fondo)
            myViewModel.iguales(texto,texto1)
             }
         boton2.setOnClickListener {
             esconderTeclado(fondo)
             edittext1.setText("")
             edittext2.setText("")
             resultado.text=""
           }
        fondo.setOnClickListener{
            esconderTeclado(fondo)
        }
       }


    @SuppressLint("SuspiciousIndentation")
    fun esconderTeclado(view:View){
        val inputMethodManager : InputMethodManager= getSystemService(Activity.INPUT_METHOD_SERVICE) as
                InputMethodManager
                        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)

    }
    }


