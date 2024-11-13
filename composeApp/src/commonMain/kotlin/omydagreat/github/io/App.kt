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

/**
 * Composable function that represents the main application.
 * It sets up the MaterialTheme and handles navigation between screens.
 */
@Composable
@Preview
fun App() = PreComposeApp {
  val navigator = rememberNavigator()
  NavHost(
    navigator = navigator, initialRoute = "/home"
  ) {
    scene(route = "/home") {
      TBox {
        HomeScreen(navigator, "/details", "/stocks/MSFT")
      }
    }
    scene(route = "/details") {
      TBox {
        DetailsScreen(navigator, "/home")
      }
    }
    scene(route = "/stocks/{symbol}") { backStackEntry ->
      val symbol: String? = backStackEntry.path<String>("symbol")
      TBox {
        StocksScreen(navigator, "/home", symbol ?: "AAPL")
      }
    }
  }
}
