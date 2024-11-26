package omydagreat.github.io.util

import moe.tlaster.precompose.navigation.Navigator

infix fun Navigator.gate(route: String) = navigate(route)

infix fun String.withSymbol(symbol: String) = this.replace("{symbol}", symbol)
