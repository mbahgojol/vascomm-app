import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

private typealias OnBackClick = () -> Unit

@Composable
fun LoginScreen(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
) {
  LoginUi(
    onBackClick = onBackClick,
    modifier = modifier,
  )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun LoginUi(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
  greeting: Greeting = koinInject(),
) {
  Column {
    Text(greeting.name())
    Image(painterResource(SharedRes.Images.img_login), null)
  }
}
