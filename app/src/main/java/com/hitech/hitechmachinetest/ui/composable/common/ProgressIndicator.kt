package com.hitech.hitechmachinetest.ui.composable.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.hitech.hitechmachinetest.ui.theme.Red_40

/**
 * Progress indicator. Progress indicator with purple background and white progress indicator.
 */
@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        val strokeWidth = 4.dp
        CircularProgressIndicator(
            modifier = Modifier
                .drawBehind {
                    this.drawCircle(
                        Red_40,
                        radius = size.width / 2 - strokeWidth.toPx() / 2,
                        style = Stroke(strokeWidth.toPx())
                    )
                }
                .background(color = Red_40)
                .padding(8.dp),
            color = Color.White,
            strokeWidth = strokeWidth
        )
    }
}
