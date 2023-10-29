package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.utils.stateOf
import com.mbahgojol.resources.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchCard(
  modifier: Modifier = Modifier,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
  var value by stateOf("")
  val focusManager = LocalFocusManager.current
  val bringIntoViewRequester = remember { BringIntoViewRequester() }
  val coroutineScope = rememberCoroutineScope()

  Card(
    modifier.fillMaxWidth().height(40.dp),
    shape = RoundedCornerShape(30.dp),
    colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
  ) {
    Box(
      Modifier.fillMaxWidth().padding(
        horizontal = 8.dp, vertical = 13.dp
      ),
    ) {
      if (value == "") {
        Text(
          stringResource(R.string.search),
          modifier.align(Alignment.CenterStart)
            .padding(start = 16.dp),
          style = appTypography.labelSmall.copy(
            lineHeight = 14.sp, fontWeight = FontWeight.W400
          ),
        )
      }

      Row(
        Modifier.fillMaxWidth()
          .padding(end = 8.dp)
      ) {
        BasicTextField(
          value,
          onValueChange = {
            if (it.length >= 16) return@BasicTextField
            value = it
          },
          enabled = true,
          readOnly = false,
          visualTransformation = VisualTransformation.None,
          keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
          keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done, keyboardType = KeyboardType.Ascii
          ),
          singleLine = true,
          interactionSource = interactionSource,
          modifier = Modifier.fillMaxWidth().bringIntoViewRequester(bringIntoViewRequester)
            .onFocusEvent { focusState ->
              if (focusState.isFocused) {
                coroutineScope.launch {
                  bringIntoViewRequester.bringIntoView()
                }
              }
            }.weight(1f).padding(horizontal = 16.dp),
          textStyle = appTypography.bodyMedium.copy(
            lineHeight = 14.sp, fontWeight = FontWeight.W400,
          ),
          maxLines = 1,
        )
        IconButton(
          onClick = {},
        ) {
          Icon(
            Icons.Filled.Search,
            contentDescription = null,
          )
        }
      }
    }
  }
}
