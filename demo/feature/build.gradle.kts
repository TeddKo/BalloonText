plugins {
    alias(libs.plugins.tddy.ko.android.library)
    alias(libs.plugins.tddy.ko.compose.library)
}

android {
    namespace = "tddy.ko.balloontext.feature"
}

dependencies {
    implementation(projects.demo.designSystem)
    implementation(projects.library)
}