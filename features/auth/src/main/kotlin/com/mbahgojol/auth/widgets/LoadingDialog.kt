package com.mbahgojol.auth.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun LoadingDialog() {
  Dialog(onDismissRequest = {}) {
    Card(shape = CircleShape) {
      Box(modifier = Modifier.padding(5.dp)) {
        CircularProgressIndicator(
          Modifier.align(Alignment.Center)
        )
      }
    }
  }
}
