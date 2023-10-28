import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
actual fun font(
  name: String,
  res: String,
  weight: FontWeight,
  style: FontStyle,
): Font {
  val context = LocalContext.current
  val id = context.resources.getIdentifier(res, "fonts", context.packageName)
  return Font(id, weight, style)
}

actual fun ByteArray.toImageBitmap(): ImageBitmap = toAndroidBitmap().asImageBitmap()

fun ByteArray.toAndroidBitmap(): Bitmap {
  return BitmapFactory.decodeByteArray(this, 0, size)
}

