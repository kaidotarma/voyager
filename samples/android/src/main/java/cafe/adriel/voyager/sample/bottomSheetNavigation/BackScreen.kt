package cafe.adriel.voyager.sample.bottomSheetNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.sample.LocalThemeIsDark
import cafe.adriel.voyager.sample.ThemeWrapper
import cafe.adriel.voyager.sample.basicNavigation.BasicNavigationScreen
import cafe.adriel.voyager.sample.theme.LocalCustomColors

class BackScreen : Screen {

    @Composable
    override fun Content() {
        val bottomSheetNavigator = LocalBottomSheetNavigator.current

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Button(
                    onClick = { bottomSheetNavigator.show(BasicNavigationScreen(index = 0, wrapContent = true)) }
                ) {
                    Text(text = "Show BottomSheet")
                }

                // FIXME: this button will be themed in version 1.1.0-alpha04 but not in 1.1.0-beta01 or 1.1.0-beta02
                ThemeSwitch()

                // FIXME: This button will be themed only because it is wrapped
                ThemeWrapper {
                    ThemeSwitch()
                }
            }
        }
    }
}

@Composable
fun ThemeSwitch() {
    var isDark by LocalThemeIsDark.current
    TextButton(
        modifier = Modifier.background(color = LocalCustomColors.current.themedButtonBackground),
        onClick = {
            isDark = !isDark
        }
    ) {
        Text(
            text = "Change theme",
            style = TextStyle(
                color = LocalCustomColors.current.themedButtonTitle,
            )
        )
    }
}
