@file:Suppress("unused")

package omydagreat.github.io.util

import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Heading1(text: String) = Text(
  text = text, style = typography.h1, color = Global.theme.colors.onBackground
)

@Composable
fun Heading2(text: String) = Text(
  text = text, style = typography.h2, color = Global.theme.colors.onBackground
)

@Composable
fun Heading3(text: String) = Text(
  text = text, style = typography.h3, color = Global.theme.colors.onBackground
)

@Composable
fun Heading4(text: String) = Text(
  text = text, style = typography.h4, color = Global.theme.colors.onBackground
)

@Composable
fun Heading5(text: String) = Text(
  text = text, style = typography.h5, color = Global.theme.colors.onBackground
)

@Composable
fun Heading6(text: String) = Text(
  text = text, style = typography.h6, color = Global.theme.colors.onBackground
)

@Composable
fun Body1(text: String) = Text(
  text = text, style = typography.body1, color = Global.theme.colors.onBackground
)

@Composable
fun Body2(text: String) = Text(
  text = text, style = typography.body2, color = Global.theme.colors.background
)
