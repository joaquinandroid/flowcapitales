package joa.edu.flowcapitales.models_paises

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainModel: ViewModel() {
    val botonEuropa = MutableLiveData<View>()
    val botonAmerica = MutableLiveData<View>()
    val botonAsia = MutableLiveData<View>()
    val botonAfrica = MutableLiveData<View>()
    val botonOceania = MutableLiveData<View>()
    val botonTodos = MutableLiveData<View>()
}