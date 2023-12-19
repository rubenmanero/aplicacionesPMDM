package com.ruben.aplicacionespmdm.BoardgamesApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ruben.aplicacionespmdm.BoardgamesApp.GameCategory.*
import com.ruben.aplicacionespmdm.R

class BoardgameActivity : AppCompatActivity() {

    private val categories = listOf(
        Cooperative,
        Deckbuilding,
        Euro,
        LCG,
        Legacy
    )

    private var games = mutableListOf(
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Agricola", Euro),
        Game("Arkham Horror", LCG),
        Game("Gloomhaven", Legacy)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var fabAddGame : FloatingActionButton

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardgame)

        initComponents()
        initUI()
        initListeners()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {position -> onCategorieSelected(position)}
        gamesAdapter = GamesAdapter(games) {position -> onGameSelected(position)}

        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvGames.layoutManager = LinearLayoutManager(this)

        rvCategories.adapter = categoriesAdapter
        rvGames.adapter = gamesAdapter
    }

    private fun initComponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener{ showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text){
                    getString(R.string.dialog_cooperative_category) -> Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> Deckbuilding
                    getString(R.string.dialog_euro_category) -> Euro
                    getString(R.string.dialog_lcg_category) -> LCG
                    else -> Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()

            }
        }
        dialog.show()
    }

    private fun updateGames() {
        val selectedCategories: List<GameCategory> = categories.filter { it.isSelected }
        val newGames: List<Game> = games.filter { selectedCategories.contains(it.category) }

        val gamesErased: Int = games.size - newGames.size
        Log.i("Juegos borrados", gamesErased.toString())

        for(i in newGames.indices){
            Log.i("Juego", newGames[i].toString())
        }
        Log.i("Separador", "Separador")

        gamesAdapter.games = newGames
        gamesAdapter.notifyDataSetChanged()

        for(i in gamesAdapter.games.indices){
            Log.i("Juego", i.toString())
        }
        Log.i("Fin", "Fin")
    }

    private fun onGameSelected(position:Int){
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }
    private fun onCategorieSelected(position:Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }

}