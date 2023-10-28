package com.mbahgojol.designsystem

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes.button: Shape
  get() = RoundedCornerShape(size = 8.dp)

val Shapes.card: Shape
  get() = RoundedCornerShape(size = 8.dp)

val Shapes.textField: Shape
  get() = RoundedCornerShape(size = 8.dp)

val Shape = Shapes(
  medium = CircleShape,
)
