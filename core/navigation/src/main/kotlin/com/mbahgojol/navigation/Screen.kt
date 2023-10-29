package com.mbahgojol.navigation

interface Screen

abstract class AppScreen(val name: String) : Screen {

  open val arguments: Map<String, *>? = null
}
