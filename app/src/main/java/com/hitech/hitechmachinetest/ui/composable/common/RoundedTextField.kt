package com.hitech.hitechmachinetest.ui.composable.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.ui.theme.Red_40

/**
 * Represent a common [OutlinedTextField] for the app.
 * @param hint: [String]
 * @param drawableEnd: [ImageVector]
 * @param keyboardOptions: [KeyboardOptions]
 * @param isError: [Boolean]
 * @param onValueChange: Callback to get the value from text field.
 */
@Composable
fun RoundedTextField(
    hint: String,
    drawableEnd: ImageVector,
    keyboardOptions: KeyboardOptions,
    isError: Boolean,
    onValueChange: (String) -> Unit
) {
    var value: String by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = value,
        label = {
            Text(text = hint)
        },
        onValueChange = {
            value = it
            onValueChange(value)
        },
        keyboardOptions = keyboardOptions,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = { Icon(drawableEnd, "", tint = Color.DarkGray) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.DarkGray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.LightGray,
            focusedIndicatorColor = Red_40
        ),
        isError = isError
    )
}

@Preview(showBackground = true)
@Composable
fun RoundedTextFieldPreview() {
    RoundedTextField(
        hint = stringResource(id = R.string.app_name),
        drawableEnd = Icons.Filled.Person,
        isError = false,

        onValueChange = {},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}
