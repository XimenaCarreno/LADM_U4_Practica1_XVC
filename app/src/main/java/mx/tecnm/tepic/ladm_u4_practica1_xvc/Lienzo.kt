package mx.tecnm.tepic.ladm_u4_practica1_xvc

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Lienzo(p:MainActivity): View(p){
    var pintura1 = BitmapFactory.decodeResource(resources,R.drawable.pintura1)
    var pintura2 = BitmapFactory.decodeResource(resources,R.drawable.pintura2)
    var pincel = BitmapFactory.decodeResource(resources, R.drawable.brush)


    var calx1=200f
    var caly1=300f
    var incrementoY = 0.5f
    var incrementoX = 0.5f
    var brush = Movimientos(0,100,pincel)
    var paint1 = Movimientos(0,0,pintura1)
    var paint2 = Movimientos(0,0,pintura2)


    /*val timer = object :CountDownTimer(2000,1000){
        override fun onTick(millisUntilFinished: Long) {
            caly1 += incrementoY
            calx1 += incrementoX
            if(p.sensorX < 0|| calx1<=-200 || calx1>=1580){
                calx1 +=0.5f
            }
            else{
                calx1 -=0.5f
            }
            if(p.sensorY>0 || caly1<=-200 || caly1>=1580){
                caly1 += 0.5f
            }
            else{
                caly1 -= 0.5f
            }

            /*caly1 += incrementoY
            if(caly1<=-200 || caly1>=1580)
            {
                incrementoY *=-1
            }*/
            invalidate()
        }

        override fun onFinish() {
            start()
        }

    }*/

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var paint = Paint()

        paint2.pintar(c,0f,0f,paint)
        paint1.pintar(c,0f,0f,paint)
        brush.pintar(c,calx1,caly1,paint)
    }
}
