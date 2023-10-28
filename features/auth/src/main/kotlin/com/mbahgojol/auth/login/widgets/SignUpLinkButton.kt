package com.mbahgojol.auth.login.widgets

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.resources.R

@Composable
fun SignUpLinkButton(
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
) {
  val annotatedText = buildAnnotatedString {
    withStyle(
      style = SpanStyle(
        color = appTypography.labelMedium.color,
        fontWeight = appTypography.labelMedium.fontWeight,
        fontSize = appTypography.labelMedium.fontSize,
        fontFamily = appTypography.labelMedium.fontFamily
      )
    ) {
      append(stringResource(id = R.string.ask_dont_have_account).plus(" "))
    }
    pushStringAnnotation(
      tag = "sign_up_link", annotation = ""
    )
    withStyle(
      style = SpanStyle(
        color = appColorScheme.primary,
        fontWeight = FontWeight.Bold,
        fontSize = appTypography.labelMedium.fontSize,
        fontFamily = appTypography.labelMedium.fontFamily
      )
    ) {
      append(stringResource(id = R.string.register_now))
    }

    pop()
  }

  ClickableText(text = annotatedText, onClick = { offset ->
    annotatedText.getStringAnnotations(
      tag = "sign_up_link", start = offset, end = offset
    ).firstOrNull()?.let {
      onClick()
    }
  }, modifier = modifier)
}
