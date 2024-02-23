package com.hitech.hitechmachinetest.ui.composable.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.ui.composable.common.AppRedButton
import com.hitech.hitechmachinetest.ui.composable.common.DescriptionText
import com.hitech.hitechmachinetest.ui.composable.common.HeaderText
import com.hitech.hitechmachinetest.ui.composable.common.HorizontalSpacer
import com.hitech.hitechmachinetest.ui.composable.common.NormalText

@Composable
fun ProfileReviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .background(color = Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        HeaderText(text = stringResource(id = R.string.hello_user_text, "Zakir"))
        HorizontalSpacer(height = 4.dp)
        DescriptionText(text = stringResource(id = R.string.portfolio_text))
        HorizontalSpacer(height = 16.dp)
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(220.dp)
                .background(
                    color = Color.LightGray, shape = RoundedCornerShape(16.dp)
                )
                .align(alignment = Alignment.CenterHorizontally),
        )
        HorizontalSpacer(height = 16.dp)
        NormalText(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = stringResource(id = R.string.website_label),
            color = Color.Blue
        )
        HorizontalSpacer(height = 16.dp)
        NormalText(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = stringResource(id = R.string.first_name_label)
        )
        HorizontalSpacer(height = 16.dp)
        NormalText(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = stringResource(id = R.string.email_label)
        )
        HorizontalSpacer(height = 64.dp)
        AppRedButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .height(48.dp), buttonText = stringResource(id = R.string.sign_in_text)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileReviewScreen()
}