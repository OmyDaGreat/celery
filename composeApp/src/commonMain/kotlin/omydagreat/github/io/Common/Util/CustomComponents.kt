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
