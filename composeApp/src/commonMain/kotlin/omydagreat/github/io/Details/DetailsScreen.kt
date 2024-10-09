package omydagreat.github.io.Details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import omydagreat.github.io.Common.Global

/**
 * Composable function that represents the Details screen.
 *
 * @param onNavigate A lambda function that is called when the navigate button is clicked.
 */
@Composable
fun DetailsScreen(onNavigate: () -> Unit) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = "This is the Details Screen", style = MaterialTheme.typography.h4, color = Global.theme.onBackground)
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { onNavigate() }) {
        Text("Go to Home")
      }
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { Global.toggleTheme() }) {
        Text("Toggle ${if (Global.isDarkMode) "Light" else "Dark"} Mode")
      }
    }
  }
}
