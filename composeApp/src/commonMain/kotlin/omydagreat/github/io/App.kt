package omydagreat.github.io

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import omydagreat.github.io.Common.Util.TBox
import omydagreat.github.io.Details.DetailsScreen
import omydagreat.github.io.Home.HomeScreen
import omydagreat.github.io.Stocks.StocksScreen
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
        HomeScreen(navigator, DETAILS_ROUTE, STOCKS_ROUTE.replace("{symbol}", "MSFT"), listOf("AAPL", "GOOGL", "TSLA"))
      }
      scene(route = DETAILS_ROUTE) {
        DetailsScreen(navigator, HOME_ROUTE)
      }
      scene(route = STOCKS_ROUTE) { backStackEntry ->
        val symbol: String? = backStackEntry.path<String>("symbol")
        StocksScreen(navigator, HOME_ROUTE, symbol ?: "AAPL")
      }
    }
  }
}
