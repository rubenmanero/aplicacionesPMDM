package com.ruben.aplicacionespmdm.ColorsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R

class ColorsActivity : AppCompatActivity() {

    private val verticalBars = mutableListOf(
        VerticalBar(871890688, "V1 (20%)"),
        VerticalBar(1509921024, "V2 (35%)"),
        VerticalBar(-2131230976, "V3 (50%)"),
        VerticalBar(-1509883935, "V4 (65%)"),
        VerticalBar(-858717953, "V5 (80%)")
    )

    private lateinit var rvHorizontal: RecyclerView
    private lateinit var horizontalAdapter: HorizontalAdapter

    private lateinit var cvH1: CardView
    private lateinit var cvH2: CardView
    private lateinit var cvH3: CardView
    private lateinit var btnChangeColor: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvHorizontal = findViewById<RecyclerView>(R.id.rvHorizontal)
        cvH1 = findViewById(R.id.cvH1)
        cvH2 = findViewById(R.id.cvH2)
        cvH3 = findViewById(R.id.cvH3)
        btnChangeColor = findViewById<CardView>(R.id.btnChangeColor)
    }

    private fun initUI() {
        horizontalAdapter = HorizontalAdapter(verticalBars)
        rvHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvHorizontal.adapter = horizontalAdapter
    }

    private fun initListeners() {
        btnChangeColor.setOnClickListener {

            val colorInt = getColor(R.color.cyan65)
            Log.i("Color","$colorInt")
        }
    }

}

