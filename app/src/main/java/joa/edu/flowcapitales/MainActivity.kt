package joa.edu.flowcapitales

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import joa.edu.flowcapitales.databinding.ActivityMainBinding
import joa.edu.flowcapitales.databinding.ActivityPreguntasActiviyBinding
import joa.edu.flowcapitales.models_paises.MainModel
import joa.edu.flowcapitales.models_paises.TodosPModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainModel

   /* lateinit var radioButtonEuropa: RadioButton
    lateinit var radioButtonAmerica: RadioButton
    lateinit var radioButtonAsia: RadioButton
    lateinit var radioButtonAfrica: RadioButton
    lateinit var radioButtonOceania: RadioButton
    lateinit var radioButtonTodos: RadioButton
    lateinit var radioGroup: RadioGroup
    lateinit var botonCerrar: Button*/

    var continente: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainModel::class.java)

        viewModel.botonEuropa.observe(this, Observer{binding.rbtnEuropa.selectionEnd})
        viewModel.botonAmerica.observe(this, Observer{binding.rbtnAmerica})
        viewModel.botonAsia.observe(this, Observer{binding.rbtnAsia})
        viewModel.botonAfrica.observe(this, Observer{binding.rbtnAfrica})
        viewModel.botonOceania.observe(this, Observer{binding.rbtnOceania})
        viewModel.botonTodos.observe(this, Observer{binding.rbtnTodos})

       // setContentView(R.layout.activity_main)

    /*    radioButtonEuropa = findViewById(R.id.rbtnEuropa)
        radioButtonAmerica = findViewById(R.id.rbtnAmerica)
        radioButtonAsia = findViewById(R.id.rbtnAsia)
        radioButtonAfrica = findViewById(R.id.rbtnAfrica)
        radioButtonOceania = findViewById(R.id.rbtnOceania)
        radioButtonTodos = findViewById(R.id.rbtnTodos)
        radioGroup = findViewById(R.id.radiogroup)
        botonCerrar = findViewById(R.id.btnCerrarApp)*/

    }

    fun obtenerSeleccion(view: View){

       /* if (radioButtonEuropa.isChecked){
            continente = "Europa"
        }else if (radioButtonAmerica.isChecked){
            continente = "America"
        }else if (radioButtonAsia.isChecked){
            continente = "Asia"
        }else if (radioButtonAfrica.isChecked){
            continente = "Africa"
        }else if (radioButtonOceania.isChecked){
            continente = "Oceania"
        }else{
            continente = "Todos"
        }*/

        if (binding.rbtnEuropa .isChecked){
            continente = "Europa"
        }else if (binding.rbtnAmerica.isChecked){
            continente = "America"
        }else if (binding.rbtnAsia.isChecked){
            continente = "Asia"
        }else if (binding.rbtnAfrica.isChecked){
            continente = "Africa"
        }else if (binding.rbtnOceania.isChecked){
            continente = "Oceania"
        }else{
            continente = "Todos"
        }

        val intentEleccion: Intent = Intent(this, EleccionActivity::class.java)
        intentEleccion.putExtra("CONTINENTE",continente)
        startActivity(intentEleccion)
    }

    fun cerrarApp(view: View) {
        finish()
    }

}