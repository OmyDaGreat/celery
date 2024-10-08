package omydagreat.github.io.Details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/**
 * Composable function that represents the Details screen.
 *
 * @param onBack A lambda function that is called when the back button is clicked.
 */
@Composable
fun DetailsScreen(onBack: () -> Unit) {
  Column {
    Text(text = "This is the Details Screen")
    Text(text = Greeting().greet())
    Button(onClick = onBack) {
      Text("Back to Home")
    }
  }
}
