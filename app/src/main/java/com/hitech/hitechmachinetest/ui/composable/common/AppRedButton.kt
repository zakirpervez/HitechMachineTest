package com.hitech.hitechmachinetest.ui.composable.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.ui.theme.Red_40

/**
 * Represent a primary button.
 * @param modifier: [Modifier]
 * @param buttonText: [String]
 * @param onButtonClick: Represent click event
 */
@Composable
fun AppRedButton(modifier: Modifier, buttonText: String, onButtonClick: () -> Unit) {
    Button(modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Red_40
        ), shape = RoundedCornerShape(8.dp), onClick = {
            onButtonClick()
        }) {
        Text(
            text = buttonText, color = Color.White
        )
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    AppRedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp), onButtonClick = {}, buttonText = stringResource(id = R.string.app_name)
    )
}

