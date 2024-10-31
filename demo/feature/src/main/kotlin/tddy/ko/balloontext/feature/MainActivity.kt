package tddy.ko.balloontext.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import tddy.ko.balloontext.design_system.theme.BalloonTextTheme
import tddy.ko.balloontext.library.BalloonDirection
import tddy.ko.balloontext.library.BalloonText
import tddy.ko.balloontext.library.BalloonTextShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BalloonTextTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .navigationBarsPadding()
                        .imePadding()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 10.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    BalloonText(
                        modifier = Modifier.align(Alignment.Start),
                        balloonDirection = BalloonDirection.LEFT_TOP,
                        balloonColor = MaterialTheme.colorScheme.primary,
                        balloonTextShape = BalloonTextShape.SMALL_SHAPE,
                        text = "SmallShape BalloonText Left Top"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.End),
                        balloonDirection = BalloonDirection.RIGHT_TOP,
                        balloonColor = MaterialTheme.colorScheme.secondary,
                        balloonTextShape = BalloonTextShape.SMALL_SHAPE,
                        text = "SmallShape BalloonText Right Top"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.Start),
                        balloonDirection = BalloonDirection.LEFT_BOTTOM,
                        balloonColor = MaterialTheme.colorScheme.primary,
                        balloonTextShape = BalloonTextShape.SMALL_SHAPE,
                        text = "SmallShape BalloonText Left Bottom"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.End),
                        balloonDirection = BalloonDirection.RIGHT_BOTTOM,
                        balloonColor = MaterialTheme.colorScheme.secondary,
                        balloonTextShape = BalloonTextShape.SMALL_SHAPE,
                        text = "SmallShape BalloonText Right Bottom"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.Start),
                        balloonDirection = BalloonDirection.LEFT_TOP,
                        balloonColor = MaterialTheme.colorScheme.primary,
                        text = "MediumShape BalloonText Left Top"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.End),
                        balloonDirection = BalloonDirection.RIGHT_TOP,
                        balloonColor = MaterialTheme.colorScheme.secondary,
                        text = "MediumShape BalloonText Right Top"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.Start),
                        balloonDirection = BalloonDirection.LEFT_BOTTOM,
                        balloonColor = MaterialTheme.colorScheme.primary,
                        text = "MediumShape BalloonText Left Bottom"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.End),
                        balloonDirection = BalloonDirection.RIGHT_BOTTOM,
                        balloonColor = MaterialTheme.colorScheme.secondary,
                        text = "MediumShape BalloonText Right Bottom"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.Start),
                        balloonDirection = BalloonDirection.LEFT_TOP,
                        balloonColor = MaterialTheme.colorScheme.primary,
                        balloonTextShape = BalloonTextShape.LARGE_SHAPE,
                        text = "LargeShape BalloonText Left Top"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.End),
                        balloonDirection = BalloonDirection.RIGHT_TOP,
                        balloonColor = MaterialTheme.colorScheme.secondary,
                        balloonTextShape = BalloonTextShape.LARGE_SHAPE,
                        text = "LargeShape BalloonText Right Top"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.Start),
                        balloonDirection = BalloonDirection.LEFT_BOTTOM,
                        balloonColor = MaterialTheme.colorScheme.primary,
                        balloonTextShape = BalloonTextShape.LARGE_SHAPE,
                        text = "LargeShape BalloonText Left Bottom"
                    )
                    BalloonText(
                        modifier = Modifier.align(Alignment.End),
                        balloonDirection = BalloonDirection.RIGHT_BOTTOM,
                        balloonColor = MaterialTheme.colorScheme.secondary,
                        balloonTextShape = BalloonTextShape.LARGE_SHAPE,
                        text = "LargeShape BalloonText Right Bottom"
                    )
                }
            }
        }
    }
}