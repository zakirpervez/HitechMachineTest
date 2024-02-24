package com.hitech.hitechmachinetest.ui.composable.profile

import android.net.Uri
import androidx.compose.foundation.Image
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
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.model.User
import com.hitech.hitechmachinetest.ui.composable.common.AppRedButton
import com.hitech.hitechmachinetest.ui.composable.common.DescriptionText
import com.hitech.hitechmachinetest.ui.composable.common.HeaderText
import com.hitech.hitechmachinetest.ui.composable.common.HorizontalSpacer
import com.hitech.hitechmachinetest.ui.composable.common.NormalText

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfileReviewScreen(user: User?) {
    Box {
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
            ) {
                user?.imageContent?.let {
                    Image(
                        painter = rememberImagePainter(it),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            HorizontalSpacer(height = 16.dp)
            NormalText(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = user?.url ?: "-",
                color = Color.Blue
            )
            HorizontalSpacer(height = 16.dp)
            NormalText(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = user?.fullName ?: "-"
            )
            HorizontalSpacer(height = 16.dp)
            NormalText(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = user?.email ?: "-"
            )
        }
        AppRedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(alignment = Alignment.BottomCenter)
                .height(48.dp), buttonText = stringResource(id = R.string.sign_in_text)
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val user = User(
        fullName = stringResource(id = R.string.app_name),
        email = "hitech@example.com",
        password = "hitest@123",
        url = "https://www.hitechtalents.com/",
        imageContent = Uri.parse("https://www.hitechtalents.com/"),
    )
    ProfileReviewScreen(user)
}