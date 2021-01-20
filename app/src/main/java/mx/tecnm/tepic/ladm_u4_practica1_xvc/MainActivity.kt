package mx.tecnm.tepic.ladm_u4_practica1_xvc

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display

class MainActivity : AppCompatActivity(), SensorEventListener {
    var l : Lienzo ? =null
    lateinit var sensorManagerMov : SensorManager
    lateinit var sensorManagerProx : SensorManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //l = Lienzo(this)

        sensorManagerMov = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManagerProx = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        setContentView(Dibujar(this,sensorManagerMov,sensorManagerProx))

        /*sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)*/
    }

    override fun onSensorChanged(event: SensorEvent?) {

        var movimientos = Intent(this,Dibujar::class.java)
        movimientos.putExtra("X",event!!.values[0])
        movimientos.putExtra("Y",event!!.values[1])
        movimientos.putExtra("Z",event!!.values[2])

        /*if(event!!.sensor.type == Sensor.TYPE_ACCELEROMETER){
            sensorX = event!!.values[0]
            sensorY = event!!.values[1]
            sensorZ = event!!.values[2]
            //sensorA = event!!.values[3]
        }
        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]<3){
                l!!.paint1.invisible()
                l!!.paint2.visible()
            }
            if(event.values[0]>=3){
                l!!.paint2.invisible()
                l!!.paint1.visible()
            }
        }*/
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}

