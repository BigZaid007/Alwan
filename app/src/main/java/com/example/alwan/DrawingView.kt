package com.example.alwan

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.core.graphics.toColor
import java.util.jar.Attributes

class DrawingView(context: Context, attrs:AttributeSet):View(context,attrs) {


    private var mDrawingPath:CustomPath?=null
    private var mCanvasBitmap:Bitmap?=null
    private var mDrawPaint:Paint?=null
    private var mCanvasPaint:Paint?=null
    private var mBrushSize:Float=0.toFloat()
    private var color=Color.BLACK
    private var canvas:Canvas?=null
    private val mPath=ArrayList<CustomPath>()

    init {
        setUpDrawing()
    }

    private fun setUpDrawing()
    {

        mDrawPaint= Paint()
        mDrawingPath=CustomPath(color,mBrushSize)
        mDrawPaint!!.color=color
        mDrawPaint!!.style=Paint.Style.STROKE
        mDrawPaint!!.strokeJoin=Paint.Join.ROUND
        mDrawPaint!!.strokeCap=Paint.Cap.ROUND
        mCanvasPaint= Paint(Paint.DITHER_FLAG)
        mBrushSize=20.toFloat()




    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCanvasBitmap= Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        canvas= Canvas(mCanvasBitmap!!)
    }
//get ripped of the ? mark in the parameter
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(mCanvasBitmap!!,0f,0f,mCanvasPaint)

    for (path in mPath)
    {

        mDrawPaint!!.strokeWidth=path.brushThickness
        mDrawPaint!!.color=path.color
        canvas.drawPath(path,mDrawPaint!!)
    }


if (!mDrawingPath!!.isEmpty)
{
    mDrawPaint!!.strokeWidth=mDrawingPath!!.brushThickness
    mDrawPaint!!.color=mDrawingPath!!.color
    canvas.drawPath(mDrawingPath!!,mDrawPaint!!)

}


    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val touchx=event?.x
        val touchy=event?.y


        when(event?.action)
        {
            MotionEvent.ACTION_DOWN->
            {

                mDrawingPath!!.color=color
                mDrawingPath!!.brushThickness=mBrushSize

                mDrawingPath!!.reset()
                mDrawingPath!!.moveTo(touchx!!,touchy!!)
            }

            MotionEvent.ACTION_MOVE ->
            {

                mDrawingPath!!.lineTo(touchx!!,touchy!!)
            }

            MotionEvent.ACTION_UP ->
            {
                mPath.add(mDrawingPath!!)
                mDrawingPath=CustomPath(color,mBrushSize)


            }
            else -> return false




        }

        invalidate()



        return true
    }


 fun brushSize(newSize:Float)
{
mBrushSize=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,newSize,resources.displayMetrics)
    mDrawPaint!!.strokeWidth=mBrushSize


}

fun brushColor(newColor:String)
{

    color=Color.parseColor(newColor)
    mDrawPaint!!.color=color

}

    fun eraseColor(newColor: String)
    {
        color=Color.parseColor(newColor)
        mDrawPaint!!.color=color


    }





   internal inner class CustomPath(var color:Int,var brushThickness :Float):Path() {

    }


}