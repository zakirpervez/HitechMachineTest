package com.hitech.hitechmachinetest.ui.composable.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hitech.hitechmachinetest.R

@Composable
fun NormalText(modifier: Modifier, text: String, color: Color = Color.DarkGray) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Bold,
        color = color,
        fontSize = 12.sp,
    )
}

@Composable
@Preview
fun NormalTextPreview() {
    NormalText(
        modifier = Modifier.fillMaxSize(),
        text = stringResource(id = R.string.email_label),
        color = Color.Blue
    )
}