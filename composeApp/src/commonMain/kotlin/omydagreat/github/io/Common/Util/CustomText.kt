package omydagreat.github.io.Common.Util

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import omydagreat.github.io.Common.Global

@Composable
fun Heading1(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.h1,
    color = Global.theme.onBackground
  )
}

@Composable
fun Heading2(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.h2,
    color = Global.theme.onBackground
  )
}

@Composable
fun Heading3(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.h3,
    color = Global.theme.onBackground
  )
}

@Composable
fun Body1(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.body1,
    color = Global.theme.onBackground
  )
}

@Composable
fun Body2(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.body2,
    color = Global.theme.onBackground
  )
}
