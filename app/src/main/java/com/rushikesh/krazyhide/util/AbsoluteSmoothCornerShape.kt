package com.rushikesh.krazyhide.util

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.abs

class AbsoluteSmoothCornerShape(
    val cornerRadius: Dp,
    val smoothness: Int
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radius = with(density) { cornerRadius.toPx() }
        return Outline.Generic(
            Path().apply {
                val width = size.width
                val height = size.height
                val s = smoothness.toDouble() / 100.0

                moveTo(radius, 0f)
                lineTo(width - radius, 0f)
                
                // Top Right
                cubicTo(
                    width - radius * (1 - s).toFloat(), 0f,
                    width, radius * (1 - s).toFloat(),
                    width, radius
                )
                
                lineTo(width, height - radius)
                
                // Bottom Right
                cubicTo(
                    width, height - radius * (1 - s).toFloat(),
                    width - radius * (1 - s).toFloat(), height,
                    width - radius, height
                )
                
                lineTo(radius, height)
                
                // Bottom Left
                cubicTo(
                    radius * (1 - s).toFloat(), height,
                    0f, height - radius * (1 - s).toFloat(),
                    0f, height - radius
                )
                
                lineTo(0f, radius)
                
                // Top Left
                cubicTo(
                    0f, radius * (1 - s).toFloat(),
                    radius * (1 - s).toFloat(), 0f,
                    radius, 0f
                )
                
                close()
            }
        )
    }
}
