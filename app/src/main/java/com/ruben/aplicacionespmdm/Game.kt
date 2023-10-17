package com.ruben.aplicacionespmdm

import com.ruben.aplicacionespmdm.BoardgamesApp.GameCategory

data class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false)