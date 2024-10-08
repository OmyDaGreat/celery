package omydagreat.github.io.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import omydagreat.github.io.Common.Screen

/**
 * Composable function that represents the Home screen.
 *
 * @param onNavigate A lambda function that is called when the navigate button is clicked.
 */
@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {
  Column {
    Text(text = "This is the Home Screen")
    Button(onClick = { onNavigate(Screen.Details) }) {
      Text("Go to Details")
    }
  }
}
