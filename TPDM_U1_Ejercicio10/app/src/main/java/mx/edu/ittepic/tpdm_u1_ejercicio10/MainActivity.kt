package mx.edu.ittepic.tpdm_u1_ejercicio10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    var img : ImageView ?= null
    var usuario : EditText ?= null
    var contraseña : EditText ?= null
    var btn : Button ?= null
    var usua = Vector<String>()
    var contra = Vector<String>()
    var int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuarios("policia","123")
        usuarios("niña","1234")
        usuarios("detective","12345")
        usuarios("doctora","123456")
        usuarios("señor","1234567")

        img = findViewById(R.id.img)
        usuario = findViewById(R.id.nomusuario)
        contraseña = findViewById(R.id.contra)
        btn = findViewById(R.id.btn)

        img?.setBackgroundResource(R.drawable.usuario)

        btn?.setOnClickListener {
            var usin = usuario?.text.toString()
            var coin = contraseña?.text.toString()
            var autenticacion = false
            (0..usua.size-1).forEach {
                var u = usua.get(it)
                var c = contra.get(it)
                if (usin.equals(u)&&coin.equals(c)){
                    var mensaje = AlertDialog.Builder(this)
                    mensaje.setTitle("ACEPTADO").setMessage("Los datos ingresados son CORRECTOS").show()
                    autenticacion=true
                    when(it){
                        0 -> img?.setBackgroundResource(R.drawable.u1)
                        1 -> img?.setBackgroundResource(R.drawable.u2)
                        2 -> img?.setBackgroundResource(R.drawable.u3)
                        3 -> img?.setBackgroundResource(R.drawable.u4)
                        4 -> img?.setBackgroundResource(R.drawable.u5)

                    }
                }
            }
            if(!autenticacion){
                var mensaje = AlertDialog.Builder(this)
                mensaje.setTitle("RECHAZADO").setMessage("Los datos ingresados son INCORRECTOS").show()
                img?.setBackgroundResource(R.drawable.usuario)
                int++
                if (int==3){
                    finish()
                }
            }
            autenticacion = false
        }

    }

    fun usuarios(u: String, c : String){
        usua.add(u)
        contra.add(c)
    }
}
