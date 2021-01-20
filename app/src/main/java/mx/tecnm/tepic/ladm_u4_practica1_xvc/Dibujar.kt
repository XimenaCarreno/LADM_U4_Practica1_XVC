package mx.tecnm.tepic.ladm_u4_practica1_xvc

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View

class Dibujar (p:MainActivity, d: SensorManager, v: SensorManager): View(p), SensorEventListener {
    var pintura1 = BitmapFactory.decodeResource(resources,R.drawable.pintura1)
    var pintura2 = BitmapFactory.decodeResource(resources,R.drawable.pintura2)
    var pincel = BitmapFactory.decodeResource(resources, R.drawable.brush)
    var paint1 = Movimientos(0,0,pintura1)
    var paint2 = Movimientos(0,0,pintura2)
    var brush = Movimientos(0,100,pincel)
    var sensorX : Float = 0f
    var sensorY : Float = 0f
    var sensorZ : Float = 0f
    var prox = 100f
    var oyente = d
    var oyente2 = v
    var pinturas = false


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var paint = Paint()

        oyente.registerListener(this,oyente.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME)
        oyente2.registerListener(this,oyente.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)


        paint2.pintar(c,0f,0f,paint)
        paint1.pintar(c,0f,0f,paint)
        brush.pintar(c,sensorX*75,sensorZ*150,paint)

        if(pinturas==false) {
            c.drawBitmap(pintura1, 0f, 0f, paint)
        }
        else {
            c.drawBitmap(pintura2, 0f, 0f, paint)
        }
        c.drawBitmap(pincel,sensorX*75,sensorZ*150,paint)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(Sensor.TYPE_ACCELEROMETER == event!!.sensor.type){
            sensorX  = event!!.values[0]
            sensorY  = event!!.values[1]
            sensorZ  = event!!.values[2]
            invalidate()
        }
        if(Sensor.TYPE_PROXIMITY == event!!.sensor.type){

            if(event!!.values[0]<5)
            {
                pinturas = false
            }
            else
            {
                pinturas = true
            }
            prox=event.values[0]*1000
            invalidate()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}