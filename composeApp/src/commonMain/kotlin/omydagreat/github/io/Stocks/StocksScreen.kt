package omydagreat.github.io.Stocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import omydagreat.github.io.Common.Util.*

/**
 * Composable function that displays stock information.
 *
 * @param onNavigate A lambda function that is called when the "Go to Home" button is clicked.
 */
@Composable
fun StocksScreen(onNavigate: () -> Unit) {
  // State to hold the stock information and user input
  var stockInfo by remember { mutableStateOf("Loading...") }
  var stockSymbol by remember { mutableStateOf("AAPL") }
  val coroutineScope = rememberCoroutineScope()

  // Function to fetch stock information
  fun fetchStockInfo() {
    coroutineScope.launch {
      stockInfo = fetchStockSummary(stockSymbol).toString()
    }
  }

  // Main UI layout
  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      // Display the title
      Heading4("Stock Information")
      Spacer(modifier = Modifier.height(16.dp))
      // TextField for user to input stock symbol
      TextField(value = stockSymbol, onValueChange = { stockSymbol = it }, label = { Body1("Enter Stock Symbol") })
      Spacer(modifier = Modifier.height(16.dp))
      // Button to fetch stock information
      ThemedButton(onClick = { fetchStockInfo() }) {
        Body2("Fetch Stock Info")
      }
      Spacer(modifier = Modifier.height(16.dp))
      // Display the stock information
      Body1(text = stockInfo)
      Spacer(modifier = Modifier.height(16.dp))
      // Button to navigate back to the home screen
      ThemedButton(onClick = { onNavigate() }) {
        Body2("Go to Home")
      }
    }
  }
}
