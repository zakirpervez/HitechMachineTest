package com.hitech.hitechmachinetest.ui.composable.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.ui.theme.Red_40
import kotlinx.coroutines.delay

private const val SPLASH_DELAY = 3000L

@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    LaunchedEffect(key1 = Unit, block = {
        delay(SPLASH_DELAY)
        onNavigate()
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Red_40),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .aspectRatio(0.4f, true)
                .scale(1f)
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun SplashScreenPreview() {
    SplashScreen(onNavigate = {})
}
