package joa.edu.flowcapitales.activities_paises

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import joa.edu.flowcapitales.R
import joa.edu.flowcapitales.databinding.ActivityPreguntasActiviyBinding
import joa.edu.flowcapitales.models_paises.AmPModel
import joa.edu.flowcapitales.models_paises.EuCapModel

class AmP : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPreguntasActiviyBinding
    private lateinit var viewModel: AmPModel
    var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        binding = ActivityPreguntasActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AmPModel::class.java)

        viewModel.pregunta.observe(this, Observer { binding.txtVPreg.text = it })
        viewModel.opcion1.observe(this, Observer { binding.opcion1.text = it })
        viewModel.opcion2.observe(this, Observer { binding.opcion2.text = it })
        viewModel.opcion3.observe(this, Observer { binding.opcion3.text = it })
        viewModel.vidas.observe(this, Observer{binding.txtvVidas.text = it})
        viewModel.porcentaje.observe(this, Observer{binding.txtVTextPorcentaje.text = it})
        viewModel.contadorPorcentaje.observe(this, Observer{binding.txtVcontador.text = it})

        binding.opcion1.setOnClickListener(this)
        binding.opcion2.setOnClickListener(this)
        binding.opcion3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.opcion1 -> {
                if (binding.opcion1.text.toString() == viewModel.opcionVerdadera) {
                    viewModel.contadorAciertos++

                    viewModel.contadorPorcentajeNumero++
                    binding.txtVcontador.text = viewModel.contadorPorcentajeNumero.toString()

                    viewModel.porcentajeNumero =
                        viewModel.calcularPorcentaje(viewModel.contadorPorcentajeNumero)
                    binding.txtVTextPorcentaje.text = viewModel.porcentajeNumero.toString()

                    viewModel.listadoParaPreguntas.remove(binding.txtVPreg.text.toString())
                    viewModel.listadoParaOpcionVerdadera.remove(viewModel.opcionVerdadera)

                    if (viewModel.contadorAciertos == viewModel.TOPE) {

                        //   aplauso = MediaPlayer.create(this, R.raw.aplauso)
                        //  aplauso.start()
                        val apl = crearAudio(R.raw.aplauso)
                        apl.start()

                        val builder1 = AlertDialog.Builder(this)
                        builder1.setTitle("HALA, ACERTASTE TODAS")
                        builder1.setMessage("YA NO HAY MÁS PREGUNTAS")
                        builder1.setPositiveButton("Nueva partida") { dialogInterface, witch ->
                            finish()
                        }

                        builder1.setNegativeButton("Ir al Inicio") { dialogInterface, which ->
                            finish()
                        }
                        val alertDialog: AlertDialog = builder1.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {

                        //   correcto = MediaPlayer.create(this, R.raw.correcto)
                        //   correcto.start()

                        val acierto = crearAudio(R.raw.correcto)
                        acierto.start()

                        Toast.makeText(this, "ACERTASTE", Toast.LENGTH_SHORT).show()
                        viewModel.actualizarPregunta()
                    }

                } else {
                    viewModel.vidasNumero--
                    binding.txtvVidas.text = viewModel.vidasNumero.toString()
                    if (viewModel.vidasNumero < 0) {

                        //  muerte = MediaPlayer.create(this, R.raw.muerte)
                        //  muerte.start()
                        val muert = crearAudio(R.raw.muerte)
                        muert.start()

                        val builder2 = AlertDialog.Builder(this)
                        builder2.setTitle("OJO, FALLASTE Y NO TE QUEDAN VIDAS")
                        builder2.setMessage("ERA ${viewModel.opcionVerdadera}")
                        builder2.setPositiveButton("Nueva partida") { dialogInterface, witch ->
                            finish()
                        }

                        builder2.setNegativeButton("Cerrar app") { dialogInterface, which ->
                            finishAffinity()
                        }
                        val alertDialog: AlertDialog = builder2.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {
                        //  dobleSilbido = MediaPlayer.create(this, R.raw.doble_silbido)
                        // dobleSilbido.start()

                        val fallo = crearAudio(R.raw.doble_silbido)
                        fallo.start()

                        val builder2 = AlertDialog.Builder(this)
                        builder2.setTitle("OJO, FALLASTE")
                        builder2.setMessage("ERA ${viewModel.opcionVerdadera}")
                        builder2.setPositiveButton("Continuar") { dialogInterface, witch ->
                            viewModel.actualizarPregunta()
                        }

                        builder2.setNegativeButton("Ir al Inicio") { dialogInterface, which ->
                            finish()
                        }
                        val alertDialog: AlertDialog = builder2.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    }
                }
            }

            R.id.opcion2 -> {
                if (binding.opcion2.text.toString() == viewModel.opcionVerdadera) {
                    viewModel.contadorAciertos++

                    viewModel.contadorPorcentajeNumero++
                    binding.txtVcontador.text = viewModel.contadorPorcentajeNumero.toString()

                    viewModel.porcentajeNumero =
                        viewModel.calcularPorcentaje(viewModel.contadorPorcentajeNumero)
                    binding.txtVTextPorcentaje.text = viewModel.porcentajeNumero.toString()

                    viewModel.listadoParaPreguntas.remove(binding.txtVPreg.text.toString())
                    viewModel.listadoParaOpcionVerdadera.remove(viewModel.opcionVerdadera)

                    if (viewModel.contadorAciertos == viewModel.TOPE) {

                        //   aplauso = MediaPlayer.create(this, R.raw.aplauso)
                        //  aplauso.start()
                        val acierto = crearAudio(R.raw.correcto)
                        acierto.start()

                        val builder1 = AlertDialog.Builder(this)
                        builder1.setTitle("HALA, ACERTASTE TODAS")
                        builder1.setMessage("YA NO HAY MÁS PREGUNTAS")
                        builder1.setPositiveButton("Nueva partida") { dialogInterface, witch ->
                            finish()
                        }

                        builder1.setNegativeButton("Ir al Inicio") { dialogInterface, which ->
                            finish()
                        }
                        val alertDialog: AlertDialog = builder1.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {

                        // correcto = MediaPlayer.create(this, R.raw.correcto)
                        //correcto.start()
                        val acierto = crearAudio(R.raw.correcto)
                        acierto.start()

                        Toast.makeText(this, "ACERTASTE", Toast.LENGTH_SHORT).show()
                        viewModel.actualizarPregunta()
                    }

                } else {
                    viewModel.vidasNumero--
                    binding.txtvVidas.text = viewModel.vidasNumero.toString()
                    if (viewModel.vidasNumero < 0) {

                        //muerte = MediaPlayer.create(this, R.raw.muerte)
                        //muerte.start()
                        val muert = crearAudio(R.raw.muerte)
                        muert.start()

                        val builder2 = AlertDialog.Builder(this)
                        builder2.setTitle("OJO, FALLASTE Y NO TE QUEDAN VIDAS")
                        builder2.setMessage("ERA ${viewModel.opcionVerdadera}")
                        builder2.setPositiveButton("Nueva partida") { dialogInterface, witch ->
                            finish()
                        }

                        builder2.setNegativeButton("Cerrar app") { dialogInterface, which ->
                            finishAffinity()
                        }
                        val alertDialog: AlertDialog = builder2.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {
                        // dobleSilbido = MediaPlayer.create(this, R.raw.doble_silbido)
                        // dobleSilbido.start()
                        val fallo = crearAudio(R.raw.doble_silbido)
                        fallo.start()

                        val builder2 = AlertDialog.Builder(this)
                        builder2.setTitle("OJO, FALLASTE")
                        builder2.setMessage("ERA ${viewModel.opcionVerdadera}")
                        builder2.setPositiveButton("Continuar") { dialogInterface, witch ->
                            viewModel.actualizarPregunta()
                        }

                        builder2.setNegativeButton("Ir al Inicio") { dialogInterface, which ->
                            finish()
                        }
                        val alertDialog: AlertDialog = builder2.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    }
                }
            }

            R.id.opcion3 -> {
                if (binding.opcion3.text.toString() == viewModel.opcionVerdadera) {
                    viewModel.contadorAciertos++

                    viewModel.contadorPorcentajeNumero++
                    binding.txtVcontador.text = viewModel.contadorPorcentajeNumero.toString()

                    viewModel.porcentajeNumero =
                        viewModel.calcularPorcentaje(viewModel.contadorPorcentajeNumero)
                    binding.txtVTextPorcentaje.text = viewModel.porcentajeNumero.toString()

                    viewModel.listadoParaPreguntas.remove(binding.txtVPreg.text.toString())
                    viewModel.listadoParaOpcionVerdadera.remove(viewModel.opcionVerdadera)

                    if (viewModel.contadorAciertos == viewModel.TOPE) {

                        //aplauso = MediaPlayer.create(this, R.raw.aplauso)
                        // aplauso.start()
                        val apl = crearAudio(R.raw.aplauso)
                        apl.start()

                        val builder1 = AlertDialog.Builder(this)
                        builder1.setTitle("HALA, ACERTASTE TODAS")
                        builder1.setMessage("YA NO HAY MÁS PREGUNTAS")
                        builder1.setPositiveButton("Nueva partida") { dialogInterface, witch ->
                            finish()
                        }

                        builder1.setNegativeButton("Ir al Inicio") { dialogInterface, which ->
                            finish()
                        }
                        val alertDialog: AlertDialog = builder1.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {

                        //  correcto = MediaPlayer.create(this, R.raw.correcto)
                        //  correcto.start()
                        val acierto = crearAudio(R.raw.correcto)
                        acierto.start()

                        Toast.makeText(this, "ACERTASTE", Toast.LENGTH_SHORT).show()
                        viewModel.actualizarPregunta()
                    }

                } else {
                    viewModel.vidasNumero--
                    binding.txtvVidas.text = viewModel.vidasNumero.toString()
                    if (viewModel.vidasNumero < 0) {

                        //muerte = MediaPlayer.create(this, R.raw.muerte)
                        // muerte.start()
                        val muert = crearAudio(R.raw.muerte)
                        muert.start()

                        val builder2 = AlertDialog.Builder(this)
                        builder2.setTitle("OJO, FALLASTE Y NO TE QUEDAN VIDAS")
                        builder2.setMessage("ERA ${viewModel.opcionVerdadera}")
                        builder2.setPositiveButton("Nueva partida") { dialogInterface, witch ->
                            finish()
                        }

                        builder2.setNegativeButton("Cerrar app") { dialogInterface, which ->
                            finishAffinity()
                        }
                        val alertDialog: AlertDialog = builder2.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {
                        //   dobleSilbido = MediaPlayer.create(this, R.raw.doble_silbido)
                        //   dobleSilbido.start()
                        val fallo = crearAudio(R.raw.doble_silbido)
                        fallo.start()

                        val builder2 = AlertDialog.Builder(this)
                        builder2.setTitle("OJO, FALLASTE")
                        builder2.setMessage("ERA ${viewModel.opcionVerdadera}")
                        builder2.setPositiveButton("Continuar") { dialogInterface, witch ->
                            viewModel.actualizarPregunta()
                        }

                        builder2.setNegativeButton("Ir al Inicio") { dialogInterface, which ->
                            finish()
                        }
                        val alertDialog: AlertDialog = builder2.create()
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    }
                }
            }
        }
    }

    fun crearAudio(recurso: Int): MediaPlayer{
        if(mp != null){
            mp!!.stop()
            mp!!.release()
            mp = null
        }
        mp = MediaPlayer.create(this, recurso)
        return mp!!
    }
}
