package omydagreat.github.io

/**
 * Represents a platform with a name.
 */
interface Platform {
  /**
   * The name of the platform.
   */
  val name: String
}

/**
 * Expects a function that returns the current platform.
 *
 * @return The current platform.
 */
expect fun getPlatform(): Platform
