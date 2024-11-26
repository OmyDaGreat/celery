package omydagreat.github.io.Stocks

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator
import omydagreat.github.io.Common.Util.*

/**
 * Composable function for the Stocks screen.
 *
 * @param navi The Navigator instance for navigation.
 * @param homeRoute The route to navigate to the Home screen.
 * @param symbol The initial stock symbol to display information for.
 */
@Composable
fun StocksScreen(navi: Navigator, homeRoute: String, symbol: String) {
  var stockInfo by remember { mutableStateOf("Waiting for Stock Input") }
  var stockSymbol by remember { mutableStateOf(symbol) }
  val coroutineScope = rememberCoroutineScope()

  fun fetchStockInfo() {
    coroutineScope.launch {
      stockInfo = fetchStockSummary(stockSymbol)?.toString() ?: "No data available"
    }
  }

  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Heading4("Stock Information")
      Spacer(modifier = Modifier.height(16.dp))
      TextField(value = stockSymbol, onValueChange = { stockSymbol = it }, label = { Body1("Enter Stock Symbol") })
      Spacer(modifier = Modifier.height(16.dp))
      ThemedButton(onClick = { fetchStockInfo() }) {
        Body2("Fetch Stock Info")
      }
      Spacer(modifier = Modifier.height(16.dp))
      Body1(text = stockInfo)
      Spacer(modifier = Modifier.height(16.dp))
      ThemedButton(onClick = { navi gate homeRoute }) {
        Body2("Go to Home")
      }
    }
  }
}
