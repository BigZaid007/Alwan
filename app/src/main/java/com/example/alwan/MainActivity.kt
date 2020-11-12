package com.example.alwan

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.brush_colors.*
import kotlinx.android.synthetic.main.brush_size.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        draw_view.brushSize(20.toFloat())

        ib_brush.setOnClickListener {


            brushSizeDialog()

        }

        color.setOnClickListener {

            choseColor()
        }

        eraser.setOnClickListener {

            eraseColor()

        }






    }


    private fun eraseColor()
    {


        draw_view.brushColor("#FFFFFF")

    }




    private fun brushSizeDialog()
    {

        var brushDialog =Dialog(this)
        brushDialog.setContentView(R.layout.brush_size)
        brushDialog.setTitle("The Brush Size")

        val btnSmall = brushDialog.ib_small_brush
        val btnMed=brushDialog.ib_med_brush
        val btnLarge=brushDialog.ib_large_brush

        btnSmall.setOnClickListener {

            draw_view.brushSize(10.toFloat())
            brushDialog.dismiss()

        }
        btnMed.setOnClickListener {

            draw_view.brushSize(20.toFloat())
            brushDialog.dismiss()

        }
        btnLarge.setOnClickListener {

            draw_view.brushSize(30.toFloat())
            brushDialog.dismiss()

        }


        brushDialog.show()


    }





    private fun choseColor()
    {
        var colorDialog=Dialog(this)
        colorDialog.setContentView(R.layout.brush_colors)
        colorDialog.setTitle("Chose Brush Color")

        val btnRed =colorDialog.red
        val btnBlue=colorDialog.blue
        val btnBlack=colorDialog.black
        val btnPink=colorDialog.pink
        val btnPurple=colorDialog.purple
        val btnGreen=colorDialog.green
        val btnNavy=colorDialog.navy
        val btnYellow=colorDialog.yellow




        btnPink.setOnClickListener {

            draw_view.brushColor("#ff6eb4")
            colorDialog.dismiss()

        }

        btnPurple.setOnClickListener {

            draw_view.brushColor("#8a2be2")
            colorDialog.dismiss()

        }
        btnRed.setOnClickListener {

            draw_view.brushColor("#ff2500")
            colorDialog.dismiss()

        }

        btnBlack.setOnClickListener {

            draw_view.brushColor("#000000")
            colorDialog.dismiss()
        }

        btnBlue.setOnClickListener {
            draw_view.brushColor("#009acd")
            colorDialog.dismiss()
        }

        btnGreen.setOnClickListener {
            draw_view.brushColor("#66cd00")
            colorDialog.dismiss()
        }

        btnYellow.setOnClickListener {
            draw_view.brushColor("#ffb90f")
            colorDialog.dismiss()

        }

        btnNavy.setOnClickListener {
            draw_view.brushColor("#1A4876")
            colorDialog.dismiss()

        }




        colorDialog.show()



    }
}
