package com.rushikesh.krazyhide.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rushikesh.krazyhide.R
import com.rushikesh.krazyhide.service.CaptureState

@Composable
fun CaptureStatusCard(
    captureState: CaptureState,
    onStartCapture: () -> Unit,
    onStopCapture: () -> Unit
) {
    val isRunning = captureState == CaptureState.RUNNING
    val isInitializing = captureState == CaptureState.INITIALIZING

    val statusColor by animateColorAsState(
        targetValue = when (captureState) {
            CaptureState.RUNNING -> MaterialTheme.colorScheme.primary
            CaptureState.INITIALIZING -> MaterialTheme.colorScheme.tertiary
            CaptureState.IDLE -> MaterialTheme.colorScheme.error.copy(alpha = 0.6f)
        }, label = "color"
    )

    SettingsCard {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(statusColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Shield,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = statusColor
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = stringResource(
                    when (captureState) {
                        CaptureState.RUNNING -> R.string.screen_capture_active
                        CaptureState.INITIALIZING -> R.string.screen_capture_initializing
                        CaptureState.IDLE -> R.string.screen_capture_inactive
                    }
                ),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.5).sp
                )
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Button(
                onClick = if (isRunning) onStopCapture else onStartCapture,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isRunning) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.primary,
                    contentColor = if (isRunning) MaterialTheme.colorScheme.onErrorContainer else MaterialTheme.colorScheme.onPrimary
                ),
                enabled = !isInitializing
            ) {
                Text(
                    text = stringResource(if (isRunning) R.string.stop_capture else R.string.start_capture),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}
