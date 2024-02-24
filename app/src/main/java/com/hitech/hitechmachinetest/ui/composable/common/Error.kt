package com.hitech.hitechmachinetest.ui.composable.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hitech.hitechmachinetest.R

/**
 * Used to show error data.
 * @param title [String]
 * @param content [String]
 * @param drawableId [Int]
 * @param modifier [Modifier]
 */
@Composable
fun Error(
    title: String,
    content: String,
    @DrawableRes drawableId: Int = R.drawable.baseline_playlist_remove_24,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .background(color = Color.White)
                .width(200.dp)
                .aspectRatio(10f / 6f),
            painter = painterResource(id = drawableId),
            contentDescription = stringResource(id = R.string.no_data_found)
        )
        HorizontalSpacer(height = 16.dp)
        HeaderText(text = title)
        HorizontalSpacer(height = 16.dp)
        NormalText(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = content
        )
    }
}