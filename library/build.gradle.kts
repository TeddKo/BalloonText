import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.tddy.ko.android.library)
    alias(libs.plugins.tddy.ko.compose.library)
    alias(libs.plugins.vanniktech.maven)
}

android {
    namespace = "tddy.ko.balloontext.library"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("io.github.teddko", "balloontext", "1.0.0")

    pom {
        name.set("BalloonText")
        description.set("Jetpack Compose BalloonText Library")
        url.set("https://github.com/TeddKo/BalloonText")
        inceptionYear.set("2024")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("TeddKo")
                name.set("Tedd Ko")
                email.set("tddy.ko@kakao.com")
                url.set("https://github.com/TeddKo")
            }
        }

        scm {
            url.set("https://github.com/TeddKo/BalloonText")
            connection.set("scm:git:git://github.com/TeddKo/BalloonText.git")
            developerConnection.set("scm:git:git://github.com/TeddKo/BalloonText.git")
        }
    }
}