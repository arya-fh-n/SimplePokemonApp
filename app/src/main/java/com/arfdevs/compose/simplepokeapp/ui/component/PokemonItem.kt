package com.arfdevs.compose.simplepokeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arfdevs.compose.simplepokeapp.R
import com.arfdevs.compose.simplepokeapp.model.Type
import com.arfdevs.compose.simplepokeapp.ui.theme.SimplePokeAppTheme

@Composable
fun PokemonItem(
    id: Int,
    image: Int,
    name: String,
    type: Type,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = "Pokemon Image",
            modifier = modifier
                .padding(8.dp)
                .size(60.dp)
                .border(2.dp, MaterialTheme.colors.primaryVariant, CircleShape)
                .clip(CircleShape)
        )
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "#$id $name",
                fontWeight = FontWeight.Medium,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
            PaddingValues(start = 10.dp)
            TypeRow(type = type)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonItemPreview() {
    SimplePokeAppTheme {
        PokemonItem(
            1, R.drawable.poke_1, "Bulbasaur", Type("Grass", "Poison")
        )
    }
}