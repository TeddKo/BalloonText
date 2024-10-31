package tddy.ko.balloontext.library

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Determines the position and orientation of the balloon's tail.
 * Controls where the tail appears and which direction it points.
 **/
enum class BalloonDirection { RIGHT_TOP, LEFT_TOP, RIGHT_BOTTOM, LEFT_BOTTOM }

/**
 * Defines the corner curvature presets for the balloon shape.
 * Provides three different levels of corner roundness (large, medium, small)
 * to control the balloon's corner curvature.
 **/
enum class BalloonTextShape { LARGE_SHAPE, MEDIUM_SHAPE, SMALL_SHAPE }

/**
 * Internal utility function for drawing the balloon shape path.
 * Creates a smooth balloon shape with rounded corners and a tail.
 *
 * @param shapeRect The bounding rectangle for the main body of the balloon
 * @param arcSize The size of the corner arcs for rounded corners
 * @param tailSize The size of the balloon's tail
 * @param cornerRadius The radius of the rounded corners
 *
 * Path drawing sequence:
 * 1. Top-left corner arc
 * 2. Top-right corner arc with tail connection
 * 3. Tail using quadratic bezier curves
 * 4. Bottom-right corner arc
 * 5. Bottom-left corner arc
 * 6. Close the path
 **/
internal fun Path.drawBalloonShape(
    shapeRect: Rect,
    arcSize: Size,
    tailSize: Size,
    cornerRadius: Float
) {
    arcTo(
        rect = Rect(
            offset = Offset(
                x = shapeRect.left,
                y = shapeRect.top
            ),
            size = arcSize
        ),
        startAngleDegrees = 180f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
    arcTo(
        rect = Rect(
            Offset(
                x = shapeRect.right - (cornerRadius * 2) - tailSize.width,
                y = shapeRect.top
            ),
            size = arcSize
        ),
        startAngleDegrees = 270f,
        sweepAngleDegrees = 45f,
        forceMoveTo = false
    )
    quadraticTo(
        x1 = shapeRect.right - (tailSize.width / 2),
        y1 = shapeRect.top,
        x2 = shapeRect.right,
        y2 = shapeRect.top
    )
    quadraticTo(
        x1 = shapeRect.right - (tailSize.width / 2),
        y1 = shapeRect.top,
        x2 = shapeRect.right - (cornerRadius / 2),
        y2 = shapeRect.top + (cornerRadius / 2) + (tailSize.height / 2)
    )
    arcTo(
        rect = Rect(
            Offset(
                x = shapeRect.right - (cornerRadius * 2) - tailSize.width,
                y = shapeRect.bottom - (cornerRadius * 2)
            ),
            size = arcSize
        ),
        startAngleDegrees = 0f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
    arcTo(
        rect = Rect(
            offset = Offset(
                x = shapeRect.left,
                y = shapeRect.bottom - (cornerRadius * 2)
            ),
            size = arcSize
        ),
        startAngleDegrees = 90f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
    close()
}