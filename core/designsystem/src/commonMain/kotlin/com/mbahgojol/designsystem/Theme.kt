import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mbahgojol.designsystem.AppTypography
import com.mbahgojol.designsystem.OnPrimary
import com.mbahgojol.designsystem.Pink40
import com.mbahgojol.designsystem.Primary
import com.mbahgojol.designsystem.Shape

private val DarkColorScheme = darkColorScheme(
  primary = Primary,
  onPrimary = OnPrimary,
  tertiary = Pink40,
  onSecondary = Color.Black,
  background = Color(0xFFFFFBFE),
  surface = Color(0xFFFFFBFE),
  onTertiary = Color.White,
  onBackground = Color(0xFF1C1B1F),
  onSurface = Color(0xFF1C1B1F),
)

private val LightColorScheme = lightColorScheme(
  primary = Primary,
  onPrimary = OnPrimary,
  tertiary = Pink40,
  onSecondary = Color.Black,
  background = Color(0xFFFFFBFE),
  surface = Color(0xFFFFFBFE),
  onTertiary = Color.White,
  onBackground = Color(0xFF1C1B1F),
  onSurface = Color(0xFF1C1B1F),
)

@Composable
fun AppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme, typography = AppTypography, content = content, shapes = Shape
  )
}
