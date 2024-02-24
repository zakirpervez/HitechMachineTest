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
 * Used to show a small bold text for descriptive text.
 * @param text: [String]
 */
@Composable
fun DescriptionText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        color = Color.LightGray,
        fontSize = 12.sp,
    )
}

@Composable
@Preview
fun DescriptionTextPreview() {
    DescriptionText(text = stringResource(id = R.string.profile_creation_description_text))
}