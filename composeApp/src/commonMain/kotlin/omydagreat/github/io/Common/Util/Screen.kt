package omydagreat.github.io.Common.Util

/**
 * Represents different screens in the application.
 *
 * @property route The route associated with the screen.
 */
sealed class Screen(val route: String) {

  /**
   * Represents the Home screen.
   */
  object Home : Screen("home")

  /**
   * Represents the Details screen.
   */
  object Details : Screen("details")

  /**
   * Represents the Stocks screen.
   */
  object Stocks : Screen("stocks")
}
