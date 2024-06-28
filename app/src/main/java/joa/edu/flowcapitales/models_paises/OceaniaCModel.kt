package joa.edu.flowcapitales.models_paises

import android.icu.text.DecimalFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import joa.edu.flowcapitales.GameStateProvider
import kotlin.random.Random

class OceaniaCModel: ViewModel() {
    //////////////////////////PERSONALIZADO//////////////////////////////
    var listado1 = GameStateProvider.oceaniaCapitales
    var listado2 = GameStateProvider.oceaniaPaises
    val TOPE = GameStateProvider.TAMANOOCEANIA
    //////////////////////////////////////////////////////////////////////

    var listadoParaPreguntas = listado1.toMutableList()
    var listadoParaOpcionVerdadera = listado2.toMutableList()

    var vidasNumero: Int = (3*listadoParaPreguntas.size)/10
    var vidasTexto: String = vidasNumero.toString()
    var contadorAciertos = 0

    var porcentajeNumero = "0"
    //var porcentajeTexto = porcentajeNumero.toString()
    var porcentajeTexto = porcentajeNumero

    var contadorPorcentajeNumero = 0
    var contadorPorcentajeTexto = contadorPorcentajeNumero.toString()

    var pregunta = MutableLiveData<String>()
    var opcion1 = MutableLiveData<String>()
    var opcion2 = MutableLiveData<String>()
    var opcion3 = MutableLiveData<String>()
    var vidas = MutableLiveData<String>()
    var porcentaje = MutableLiveData<String>()
    var contadorPorcentaje = MutableLiveData<String>()

    var indice = Random.nextInt(listado1.size)
    var listadoParaOpcionVerdaderaMezclado = crearListadoParaOpciones(indice).shuffled()
    var opcionVerdadera = crearListadoParaOpciones(indice)[0]



    init{
        iniciarApp()
    }

    fun iniciarApp(){
        listadoParaPreguntas = listado1.toMutableList()
        listadoParaOpcionVerdadera = listado2.toMutableList()
        indice = Random.nextInt(listadoParaPreguntas.size)
        listadoParaOpcionVerdaderaMezclado = crearListadoParaOpciones(indice).shuffled()
        opcionVerdadera = crearListadoParaOpciones(indice)[0]
        contadorAciertos = 0
        //contadorPreguntas = 0
        pregunta.value = listadoParaPreguntas[indice]
        opcion1.value = listadoParaOpcionVerdaderaMezclado[0]
        opcion2.value = listadoParaOpcionVerdaderaMezclado[1]
        opcion3.value = listadoParaOpcionVerdaderaMezclado[2]
        vidas.value = vidasTexto
        porcentaje.value = porcentajeTexto
        contadorPorcentaje.value = contadorPorcentajeTexto

    }

    fun crearListadoParaOpciones(indice: Int): MutableList<String>{
        var opcionVerdadera = listadoParaOpcionVerdadera.get(indice)
        var listadoParaOpciones = mutableListOf<String>(opcionVerdadera)
        var opc1 = GameStateProvider.todosPaises.get(Random.nextInt(GameStateProvider.todosPaises.size))
        while(listadoParaOpciones.contains(opc1)){
            opc1 = GameStateProvider.todosPaises.get(Random.nextInt(GameStateProvider.todosPaises.size))
        }
        listadoParaOpciones.add(opc1)
        var opc2 = GameStateProvider.todosPaises.get(Random.nextInt(GameStateProvider.todosPaises.size))
        while(listadoParaOpciones.contains(opc2)){
            opc2 = GameStateProvider.todosPaises.get(Random.nextInt(GameStateProvider.todosPaises.size))
        }
        listadoParaOpciones.add(opc2)
        return listadoParaOpciones
    }

    fun actualizarPregunta(){
        indice = Random.nextInt(listadoParaPreguntas.size)
        listadoParaOpcionVerdaderaMezclado = crearListadoParaOpciones(indice).shuffled()
        opcionVerdadera = crearListadoParaOpciones(indice)[0]
        pregunta.postValue(listadoParaPreguntas.get(indice))
        opcion1.postValue(listadoParaOpcionVerdaderaMezclado[0])
        opcion2.postValue(listadoParaOpcionVerdaderaMezclado[1])
        opcion3.postValue(listadoParaOpcionVerdaderaMezclado[2])
    }

    fun calcularPorcentaje(cont: Int): String{
        var porcent = (cont*100)/TOPE
        val dec = DecimalFormat("###.##")
        var decPorcent = dec.format(porcent)
        return decPorcent
    }
}