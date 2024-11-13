package omydagreat.github.io.Common.Util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import omydagreat.github.io.Common.Global

/**
 * A themed button composable that applies custom colors and padding.
 *
 * @param onClick The callback to be invoked when the button is clicked.
 * @param modifier The modifier to be applied to the button.
 * @param content The content to be displayed inside the button.
 */
@Composable
fun ThemedButton(
  onClick: () -> Unit, modifier: Modifier = Modifier, content: @Composable () -> Unit
) = Button(
  onClick = onClick, colors = ButtonDefaults.buttonColors(
    backgroundColor = Global.theme.colors.onBackground, contentColor = Global.theme.colors.background
  ), contentPadding = PaddingValues(16.dp), modifier = modifier
) {
  content()
}

/**
 * A themed dropdown menu composable that applies custom background color.
 *
 * @param expanded Whether the dropdown menu is expanded or not.
 * @param onDismissRequest The callback to be invoked when the dropdown menu is dismissed.
 * @param content The content to be displayed inside the dropdown menu.
 */
@Composable
fun ThemedDropdownMenu(
  expanded: Boolean, onDismissRequest: () -> Unit, content: @Composable () -> Unit
) = DropdownMenu(
  expanded = expanded,
  onDismissRequest = onDismissRequest,
  modifier = Modifier.background(Global.theme.colors.onBackground)
) {
  content()
}