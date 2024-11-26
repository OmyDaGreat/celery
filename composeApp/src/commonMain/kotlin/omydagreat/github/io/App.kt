package omydagreat.github.io

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import omydagreat.github.io.util.TBox
import omydagreat.github.io.screens.settings.SettingsScreen
import omydagreat.github.io.screens.home.HomeScreen
import omydagreat.github.io.screens.stock.StockScreen
import omydagreat.github.io.util.withSymbol
import org.jetbrains.compose.ui.tooling.preview.Preview

const val HOME_ROUTE = "/home"
const val DETAILS_ROUTE = "/details"
const val STOCKS_ROUTE = "/stocks/{symbol}"

/**
 * Composable function that represents the main application.
 * It sets up the MaterialTheme and handles navigation between screens.
 */
@Composable
@Preview
fun App() = PreComposeApp {
  val navigator = rememberNavigator()
  TBox {
    NavHost(
      navigator = navigator, initialRoute = HOME_ROUTE
    ) {
      scene(route = HOME_ROUTE) {
        HomeScreen(navigator, DETAILS_ROUTE, STOCKS_ROUTE withSymbol "MSFT")
      }
      scene(route = DETAILS_ROUTE) {
        SettingsScreen(navigator, HOME_ROUTE)
      }
      scene(route = STOCKS_ROUTE) { stack ->
        StockScreen(navigator, HOME_ROUTE, stack.path<String>("symbol") ?: "AAPL")
      }
    }
  }
}
