package omydagreat.github.io.Home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import omydagreat.github.io.Common.Util.*

/**
 * Composable function that represents the Home screen.
 *
 * @param onNavigate A lambda function that is called when the navigate button is clicked.
 */
@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {
  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Heading4(text = "This is the Home Screen")
      Spacer(modifier = Modifier.height(16.dp))
      ThemedButton(onClick = { onNavigate(Screen.Details) }) {
        Body2("Go to Details")
      }
      Spacer(modifier = Modifier.height(16.dp))
      ThemedButton(onClick = { onNavigate(Screen.Stocks) }) {
        Body2("Go to Stocks")
      }
    }
  }
}
