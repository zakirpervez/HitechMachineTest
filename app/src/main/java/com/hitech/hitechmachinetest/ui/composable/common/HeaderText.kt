package com.hitech.hitechmachinetest.ui.composable.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hitech.hitechmachinetest.R

/**
 * Used to show a bold header text.
 * @param text: [String]
 */
@Composable
fun HeaderText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.ExtraBold,
        color = Color.DarkGray,
        fontSize = 24.sp
    )
}

@Composable
@Preview(showBackground = true)
fun HeaderTextPreview() {
    HeaderText(text = stringResource(id = R.string.app_name))
}
