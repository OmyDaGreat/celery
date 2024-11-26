package omydagreat.github.io.screens.stock

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator
import omydagreat.github.io.util.*

/**
 * Composable function for the Stocks screen.
 *
 * @param navi The Navigator instance for navigation.
 * @param homeRoute The route to navigate to the Home screen.
 * @param symbol The initial stock symbol to display information for.
 */
@Composable
fun StockScreen(navi: Navigator, homeRoute: String, symbol: String) {
  // State to hold the stock information
  var stockInfo by remember { mutableStateOf("Waiting for Stock Input") }
  // State to hold the stock symbol
  var stockSymbol by remember { mutableStateOf(symbol) }
  // Coroutine scope for launching coroutines
  val coroutineScope = rememberCoroutineScope()
  // Modifier for setting height
  val heightMod = Modifier.height(16.dp)

  /**
   * Function to fetch stock information asynchronously.
   */
  fun fetchStockInfo() {
    coroutineScope.launch {
      stockInfo = fetchStockSummary(stockSymbol)?.toString() ?: "No data available"
    }
  }

  // Main container for the Stocks screen
  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      StockInfoHeader()
      Spacer(modifier = heightMod)
      StockSymbolInput(stockSymbol) { stockSymbol = it }
      Spacer(modifier = heightMod)
      FetchStockInfoButton { fetchStockInfo() }
      Spacer(modifier = heightMod)
      StockInfoDisplay(stockInfo)
      Spacer(modifier = heightMod)
      GoHomeButton(navi, homeRoute)
    }
  }
}

/**
 * Composable function to display the stock information header.
 */
@Composable
fun StockInfoHeader() {
  Heading4("Stock Information")
}

/**
 * Composable function for the stock symbol input field.
 *
 * @param stockSymbol The current stock symbol.
 * @param onValueChange Callback to handle changes to the stock symbol.
 */
@Composable
fun StockSymbolInput(stockSymbol: String, onValueChange: (String) -> Unit) {
  TextField(value = stockSymbol, onValueChange = onValueChange, label = { Body1("Enter Stock Symbol") })
}

/**
 * Composable function for the button to fetch stock information.
 *
 * @param onClick Callback to handle button click.
 */
@Composable
fun FetchStockInfoButton(onClick: () -> Unit) {
  ThemedButton(onClick = onClick) {
    Body2("Fetch Stock Info")
  }
}

/**
 * Composable function to display the fetched stock information.
 *
 * @param stockInfo The stock information to display.
 */
@Composable
fun StockInfoDisplay(stockInfo: String) {
  Body1(text = stockInfo)
}

/**
 * Composable function for the button to navigate to the home screen.
 *
 * @param navi The Navigator instance for navigation.
 * @param homeRoute The route to navigate to the Home screen.
 */
@Composable
fun GoHomeButton(navi: Navigator, homeRoute: String) {
  ThemedButton(onClick = { navi gate homeRoute }) {
    Body2("Go to Home")
  }
}
