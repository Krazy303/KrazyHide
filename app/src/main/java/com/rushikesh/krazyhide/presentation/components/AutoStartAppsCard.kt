package com.rushikesh.krazyhide.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Launch
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rushikesh.krazyhide.R

@Composable
fun AutoStartAppsCard(
    selectedCount: Int,
    onClick: () -> Unit
) {
    SettingsCard {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.Launch,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = stringResource(R.string.auto_start_apps),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = if (selectedCount == 0) {
                                stringResource(R.string.no_apps_selected)
                            } else {
                                stringResource(R.string.apps_selected, selectedCount)
                            },
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                TextButton(onClick = onClick) {
                    Text(stringResource(R.string.select_apps))
                }
            }
        }
    }
}
