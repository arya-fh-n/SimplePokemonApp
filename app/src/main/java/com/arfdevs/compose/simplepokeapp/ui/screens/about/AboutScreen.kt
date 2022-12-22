package com.arfdevs.compose.simplepokeapp.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arfdevs.compose.simplepokeapp.R
import com.arfdevs.compose.simplepokeapp.ui.theme.SimplePokeAppTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyBio()
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(15.dp)
        )
    }
}

@Composable
fun MyBio(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About Me",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = modifier
                .widthIn(30.dp)
                .fillMaxWidth()
                .padding(top = 18.dp, bottom = 12.dp)
        )
        Image(
            painter = painterResource(R.drawable.about_me),
            contentDescription = "Pokemon image in detail",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(300.dp)
                .width(300.dp)
                .clip(CircleShape)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )
        Text(
            text = "Arya Fikryhuda Nurpatria",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            modifier = modifier
                .widthIn(30.dp)
                .fillMaxWidth()
                .padding(top = 6.dp, bottom = 2.dp)
        )
        Text(
            text = "(arf_devs)",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
            modifier = modifier
                .widthIn(30.dp)
                .fillMaxWidth()
                .padding(bottom = 6.dp)
        )
        Text(
            text = "aryafikry86@gmail.com",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            modifier = modifier
                .widthIn(30.dp)
                .fillMaxWidth()
                .padding(bottom = 6.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AboutScreenPreview() {
    SimplePokeAppTheme {
        AboutScreen()
    }
}