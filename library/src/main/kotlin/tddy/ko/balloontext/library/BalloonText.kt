package tddy.ko.balloontext.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

/**
 * BalloonText is a customizable Jetpack Compose library for creating chat bubble-style text components.
 *
 * Features:
 * - Customizable balloon direction (right-top, left-top, right-bottom, left-bottom)
 * - Three preset shape sizes (large, medium, small)
 * - Configurable colors and padding
 * - Smooth corner radius
 * - Custom tail shape
 *
 * @param modifier Modifier to be applied to the text component
 * @param balloonDirection Direction of the balloon's tail
 * @param balloonTextShape Preset shape size of the balloon (LARGE_SHAPE, MEDIUM_SHAPE, SMALL_SHAPE)
 * @param textPadding Padding around the text content inside the balloon
 * @param balloonColor Background color of the balloon shape
 * @param text Text to be displayed inside the balloon
 * @param textColor Color of the text (defaults to MaterialTheme's surface color)
 *
 *
 * Example usage:
 * ```
 * BalloonText(
 *     balloonDirection = BalloonDirection.LEFT_TOP,
 *     balloonTextShape = BalloonTextShape.MEDIUM_SHAPE,
 *     balloonColor = MaterialTheme.colorScheme.primary,
 *     text = "Hello, World!"
 * )
 * ```
 *
 * @see BalloonDirection
 * @see BalloonTextShape
 **/
@Composable
fun BalloonText(
    modifier: Modifier = Modifier,
    balloonDirection: BalloonDirection,
    balloonTextShape: BalloonTextShape = BalloonTextShape.MEDIUM_SHAPE,
    textPadding: PaddingValues = PaddingValues(10.dp),
    balloonColor: Color,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.surface,
) {
    val density = LocalDensity.current

    val cornerRadius = when (balloonTextShape) {
        BalloonTextShape.LARGE_SHAPE -> 18.dp
        BalloonTextShape.MEDIUM_SHAPE -> 15.dp
        BalloonTextShape.SMALL_SHAPE -> 8.dp
    }

    val cornerRadiusPx = with(density) { cornerRadius.toPx() }
    val tailSize = Size(cornerRadiusPx / 2, cornerRadiusPx / 2)
    val tailWidthDp = with(density) { tailSize.width.toDp() }

    val balloonShape = GenericShape { size, _ ->
        val shapeRect = Rect(Offset.Zero, size)
        val arcSize = Size(cornerRadiusPx * 2, cornerRadiusPx * 2)
        drawBalloonShape(
            shapeRect = shapeRect,
            arcSize = arcSize,
            tailSize = tailSize,
            cornerRadius = cornerRadiusPx
        )
    }

    val xScale = when (balloonDirection) {
        BalloonDirection.RIGHT_TOP,
        BalloonDirection.RIGHT_BOTTOM -> 1f

        BalloonDirection.LEFT_TOP,
        BalloonDirection.LEFT_BOTTOM -> -1f
    }

    val yScale = when (balloonDirection) {
        BalloonDirection.RIGHT_BOTTOM,
        BalloonDirection.LEFT_BOTTOM -> -1f

        BalloonDirection.RIGHT_TOP,
        BalloonDirection.LEFT_TOP -> 1f
    }

    Text(
        modifier = modifier
            .scale(scaleX = xScale, scaleY = yScale)
            .background(balloonColor, shape = balloonShape)
            .graphicsLayer {
                scaleX = xScale
                scaleY = yScale
            }
            .padding(
                start = when (balloonDirection) {
                    BalloonDirection.LEFT_TOP, BalloonDirection.LEFT_BOTTOM -> tailWidthDp + 2.dp
                    else -> 4.dp
                },
                end = when (balloonDirection) {
                    BalloonDirection.RIGHT_TOP, BalloonDirection.RIGHT_BOTTOM -> tailWidthDp + 2.dp
                    else -> 4.dp
                }
            )
            .padding(paddingValues = textPadding),
        text = text,
        color = textColor,
        style = MaterialTheme.typography.bodyMedium
    )
}