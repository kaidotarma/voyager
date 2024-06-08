package cafe.adriel.voyager.sample.bottomSheetNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.sample.AppTheme

class BottomSheetNavigationActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                BottomSheetNavigator(sheetBackgroundColor = MaterialTheme.colorScheme.surface) {
                    Navigator(BackScreen())
                }
            }
        }
    }
}
