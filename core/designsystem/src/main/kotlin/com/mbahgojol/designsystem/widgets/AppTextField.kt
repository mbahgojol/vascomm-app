package com.mbahgojol.designsystem.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.GilroyFamily
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.utils.stateOf
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppTextField(
  modifier: Modifier = Modifier,
  visualTransformation: VisualTransformation = VisualTransformation.None,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  isError: Boolean = false,
  enable: Boolean = true,
  readOnly: Boolean = false,
  placeholder: String,
  label: String,
  initialValue: String = "",
  elevation: Dp = 50.dp,
  onValueChange: (String) -> Unit = {},
) {
  var value by stateOf(value = initialValue)
  val focusManager = LocalFocusManager.current
  val bringIntoViewRequester = remember { BringIntoViewRequester() }
  val coroutineScope = rememberCoroutineScope()

  Column(modifier.fillMaxWidth().wrapContentHeight()) {
    Text(
      label,
      style = appTypography.labelLarge.copy(
        fontWeight = FontWeight.W600, color = appColorScheme.primary, fontFamily = GilroyFamily
      ),
    )
    AppSpacer(height = 16.dp)
    Card(
      Modifier.fillMaxWidth().wrapContentHeight(),
      shape = RoundedCornerShape(8.dp),
      colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = elevation),
    ) {
      Box(
        Modifier.fillMaxWidth().padding(
          horizontal = 8.dp, vertical = 13.dp
        ),
      ) {
        if (value == "") {
          Text(
            placeholder,
            modifier.align(Alignment.CenterStart),
            style = appTypography.labelSmall.copy(
              lineHeight = 14.sp, fontWeight = FontWeight.W400
            )
          )
        }

        BasicTextField(
          value,
          onValueChange = {
            value = it
            onValueChange(value)
          },
          enabled = enable,
          readOnly = readOnly,
          visualTransformation = visualTransformation,
          keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
          keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next, keyboardType = KeyboardType.Ascii
          ),
          singleLine = true,
          interactionSource = interactionSource,
          modifier = Modifier.fillMaxSize().bringIntoViewRequester(bringIntoViewRequester)
            .onFocusEvent { focusState ->
              if (focusState.isFocused) {
                coroutineScope.launch {
                  bringIntoViewRequester.bringIntoView()
                }
              }
            }
            .padding(horizontal = 16.dp).align(Alignment.Center),
          textStyle = appTypography.bodyMedium.copy(
            lineHeight = 14.sp, fontWeight = FontWeight.W400,
          ),
        )
      }
    }
  }
}
