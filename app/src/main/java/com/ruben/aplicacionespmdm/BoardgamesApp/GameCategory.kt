package com.ruben.aplicacionespmdm.BoardgamesApp

sealed class GameCategory (var isSelected: Boolean = true){
    object Deckbuilding: GameCategory()
    object Euro: GameCategory()
    object LCG: GameCategory()
    object Cooperative: GameCategory()
    object Legacy: GameCategory()
}