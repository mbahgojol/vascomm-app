import androidx.compose.runtime.Composable
import com.mbahgojol.auth.LoginScreen
import com.mbahgojol.auth.di.authModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
  KoinApplication(application = {
    modules(authModule)
  }) {
    AppTheme {
      LoginScreen({})
    }
  }
}
