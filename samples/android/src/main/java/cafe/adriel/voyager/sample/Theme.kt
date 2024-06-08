package cafe.adriel.voyager.sample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.sample.theme.DarkColorScheme
import cafe.adriel.voyager.sample.theme.DarkCustomColors
import cafe.adriel.voyager.sample.theme.LightColorScheme
import cafe.adriel.voyager.sample.theme.LightCustomColors
import cafe.adriel.voyager.sample.theme.LocalCustomColors

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun AppTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState
    ) {
        val isDark by isDarkState
        MaterialTheme(
            colorScheme = if (isDark) DarkColorScheme else LightColorScheme,
            content = {
                val customColors = if (isDark) DarkCustomColors else LightCustomColors
                CompositionLocalProvider(LocalCustomColors provides customColors) {
                    Surface(content = content)
                }
            }
        )
    }
}

/**
 * Use this wrapper only if there is some view where content does not update automatically after theme change.
 * TODO: perhaps can be removed after https://github.com/adrielcafe/voyager/issues/429
 */
@Composable
fun ThemeWrapper(content: @Composable (() -> Unit)) {
    val isDark by LocalThemeIsDark.current
    val customColors = if (isDark) DarkCustomColors else LightCustomColors
    CompositionLocalProvider(value = LocalCustomColors provides customColors, content = content)
}
