plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

setupModuleForAndroidxCompose(
    withKotlinExplicitMode = false
)

android {
    namespace = "cafe.adriel.voyager.sample"
    defaultConfig {
        applicationId = "cafe.adriel.voyager.sample"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
//    implementation(projects.voyagerScreenmodel)
//    implementation(projects.voyagerNavigator)
//    implementation(projects.voyagerTabNavigator)
//    implementation(projects.voyagerBottomSheetNavigator)
//    implementation(projects.voyagerTransitions)
//    implementation(projects.voyagerHilt)
//    implementation(projects.voyagerKodein)
//    implementation(projects.voyagerKoin)
//    implementation(projects.voyagerRxjava)
//    implementation(projects.voyagerLivedata)

    // TODO: swap these to see success/fail results
    val success = "1.1.0-alpha04"
    val fail = "1.1.0-beta02"
    val voyagerVersion = success
    implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-hilt:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-kodein:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-koin:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-rxjava:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-livedata:$voyagerVersion")
    implementation("androidx.compose.material3:material3:1.2.1")

    implementation(libs.kodein)
    implementation(libs.koin)
    implementation(libs.appCompat)
    implementation(libs.lifecycle.viewModelKtx)
    implementation(libs.lifecycle.viewModelCompose)
    implementation(libs.compose.rxjava)
    implementation(libs.compose.compiler)
    implementation(libs.compose.runtime)
    implementation(libs.compose.runtimeLiveData)
    implementation(libs.compose.activity)
    implementation(libs.compose.material)
    implementation(libs.compose.materialIcons)
    implementation(libs.compose.animation)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    debugImplementation(libs.leakCanary)
}
