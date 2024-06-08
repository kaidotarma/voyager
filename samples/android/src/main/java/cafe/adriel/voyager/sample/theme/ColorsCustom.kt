package cafe.adriel.voyager.sample.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val themedButtonBackground: Color,
    val themedButtonTitle: Color,
)

internal val DarkCustomColors = CustomColors(
    themedButtonBackground = Color(0xFF2A2A2A),
    themedButtonTitle = Color(0xFFFFFFFF),
)

internal val LightCustomColors = CustomColors(
    themedButtonBackground = Color(0xFFF9F9F9),
    themedButtonTitle = Color(0xFF000000),
)

internal val LocalCustomColors = staticCompositionLocalOf {
    DarkCustomColors
}
