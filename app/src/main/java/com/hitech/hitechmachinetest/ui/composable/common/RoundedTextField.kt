package com.hitech.hitechmachinetest.ui.composable.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitech.hitechmachinetest.R

@Composable
fun RoundedTextField(hint: String, drawableEnd: ImageVector) {
    OutlinedTextField(
        value = hint,
        onValueChange = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            Icon(drawableEnd, "", tint = Color.DarkGray)
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.DarkGray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.LightGray,
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun RoundedTextFieldPreview() {
    RoundedTextField(
        stringResource(id = R.string.first_name_label),
        drawableEnd = Icons.Filled.Person
    )
}