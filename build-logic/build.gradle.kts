plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("AndroidApplication") {
            id = "tddy.ko.balloontext.application"
            implementationClass = "AndroidApplicationPlugin"
        }

        register("AndroidLibrary") {
            id = "tddy.ko.balloontext.library"
            implementationClass = "AndroidLibraryPlugin"
        }

        register("ComposeApplication") {
            id = "tddy.ko.balloontext.compose.application"
            implementationClass = "ComposeApplicationPlugin"
        }

        register("ComposeLibrary") {
            id = "tddy.ko.balloontext.compose.library"
            implementationClass = "ComposeLibraryPlugin"
        }
    }
}