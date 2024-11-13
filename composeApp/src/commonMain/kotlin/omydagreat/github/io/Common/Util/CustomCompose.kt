package omydagreat.github.io.Common.Util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import omydagreat.github.io.Common.Global

/**
 * A composable function that creates a themed Box with a background color.
 *
 * @param stuff The content to be displayed inside the Box.
 */
@Composable
fun TBox(stuff: @Composable BoxScope.() -> Unit) {
  MaterialTheme(colors = Global.theme.colors) {
    Box(modifier = Modifier.background(Global.theme.colors.background), content = stuff)
  }
}
