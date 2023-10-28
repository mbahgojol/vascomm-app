package com.mbahgojol.base.navigator

interface Screen

abstract class AppScreen(val name: String) : Screen {

  open val arguments: Map<String, *>? = null
}
