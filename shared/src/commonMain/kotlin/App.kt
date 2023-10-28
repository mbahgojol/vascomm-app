import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.mbahgojol.auth.LoginScreen
import com.mbahgojol.auth.di.authModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
  KoinApplication(application = {
    modules(authModule)
  }) {
    MaterialTheme {
      LoginScreen({})
    }
  }
}

expect fun getPlatformName(): String
