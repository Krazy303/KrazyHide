package com.rushikesh.krazyhide.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetectionConfidenceCard(
    confidence: Float,
    onConfidenceChanged: (Float) -> Unit
) {
    SettingsCard {
        Column {
            Text("Detection Confidence", style = MaterialTheme.typography.titleMedium)
            Text("Adjust sensitivity of the AI model", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))
            Slider(
                value = confidence,
                onValueChange = onConfidenceChanged,
                valueRange = 10f..95f
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Sensitive", style = MaterialTheme.typography.labelSmall)
                Text("${confidence.toInt()}%", style = MaterialTheme.typography.labelMedium)
                Text("Strict", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Composable
fun OverlayOpacityCard(
    opacity: Float,
    onOpacityChanged: (Float) -> Unit
) {
    SettingsCard {
        Column {
            Text("Overlay Opacity", style = MaterialTheme.typography.titleMedium)
            Text("Adjust transparency of the cover", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))
            Slider(
                value = opacity,
                onValueChange = onOpacityChanged,
                valueRange = 0f..100f
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Transparent", style = MaterialTheme.typography.labelSmall)
                Text("${opacity.toInt()}%", style = MaterialTheme.typography.labelMedium)
                Text("Solid", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Composable
fun PixelationLevelCard(
    pixelationLevel: Int,
    onPixelationLevelChanged: (Int) -> Unit
) {
    SettingsCard {
        Column {
            Text("Pixelation Level", style = MaterialTheme.typography.titleMedium)
            Text("Intensity of blur in Detailed Mode", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))
            Slider(
                value = pixelationLevel.toFloat(),
                onValueChange = { onPixelationLevelChanged(it.toInt()) },
                valueRange = 4f..32f,
                steps = 7
            )
            Text("${pixelationLevel}x", style = MaterialTheme.typography.labelMedium)
        }
    }
}
