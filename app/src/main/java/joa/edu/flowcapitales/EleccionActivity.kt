package joa.edu.flowcapitales

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import joa.edu.flowcapitales.activities_paises.AfricaC
import joa.edu.flowcapitales.activities_paises.AfricaP
import joa.edu.flowcapitales.activities_paises.AmCap
import joa.edu.flowcapitales.activities_paises.AmP
import joa.edu.flowcapitales.activities_paises.AsiaC
import joa.edu.flowcapitales.activities_paises.AsiaP
import joa.edu.flowcapitales.activities_paises.EuCap
import joa.edu.flowcapitales.activities_paises.OceaniaC
import joa.edu.flowcapitales.activities_paises.OceaniaP
import joa.edu.flowcapitales.activities_paises.TodosC
import joa.edu.flowcapitales.activities_paises.TodosP

class EleccionActivity : AppCompatActivity() {
    lateinit var rbPais: RadioButton
    lateinit var rbCapital: RadioButton
    lateinit var radiogroup2: RadioGroup
    lateinit var txtVenunciadoEleccion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        rbPais = findViewById(R.id.rbtnSegunPais)
        rbCapital = findViewById(R.id.rbtnSegunCapital)
        radiogroup2 = findViewById(R.id.radiogroup2)
        txtVenunciadoEleccion = findViewById(R.id.txtVEnunciadoEleccion)

    }

    fun obtenerContinente(view: View) {
        val continenteSeleccionado = intent.getStringExtra("CONTINENTE")

        when (continenteSeleccionado) {
            "Europa" -> if (rbPais.isChecked == true) {
                val intentSeleccion: Intent = Intent(this, PreguntasActivityEuropaP::class.java)
                startActivity(intentSeleccion)
                finish()
            } else {
                val intentSeleccion: Intent = Intent(this, EuCap::class.java)
                startActivity(intentSeleccion)
                finish()
            }
            "America" -> if (rbPais.isChecked == true) {
                val intentSeleccion: Intent = Intent(this, AmP::class.java)
                startActivity(intentSeleccion)
                finish()
            } else {
                val intentSeleccion: Intent = Intent(this, AmCap::class.java)
                startActivity(intentSeleccion)
                finish()
            }
            "Asia" -> if (rbPais.isChecked == true) {
                val intentSeleccion: Intent = Intent(this, AsiaP::class.java)
                startActivity(intentSeleccion)
                finish()
            } else {
                val intentSeleccion: Intent = Intent(this, AsiaC::class.java)
                startActivity(intentSeleccion)
                finish()
            }
            "Africa" -> if (rbPais.isChecked == true) {
                val intentSeleccion: Intent = Intent(this, AfricaP::class.java)
                startActivity(intentSeleccion)
                finish()
            } else {
                val intentSeleccion: Intent = Intent(this, AfricaC::class.java)
                startActivity(intentSeleccion)
                finish()
            }
            "Oceania" -> if (rbPais.isChecked == true) {
                val intentSeleccion: Intent = Intent(this, OceaniaP::class.java)
                startActivity(intentSeleccion)
                finish()
            } else {
                val intentSeleccion: Intent = Intent(this, OceaniaC::class.java)
                startActivity(intentSeleccion)
                finish()
            }
            "Todos" -> if (rbPais.isChecked == true) {
                val intentSeleccion: Intent = Intent(this, TodosP::class.java)
                startActivity(intentSeleccion)
                finish()
            } else {
                val intentSeleccion: Intent = Intent(this, TodosC::class.java)
                startActivity(intentSeleccion)
                finish()
            }
        }


    }
}