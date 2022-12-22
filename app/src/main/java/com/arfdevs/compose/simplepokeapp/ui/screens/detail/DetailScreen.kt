package com.arfdevs.compose.simplepokeapp.ui.screens.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arfdevs.compose.simplepokeapp.R
import com.arfdevs.compose.simplepokeapp.di.Injection
import com.arfdevs.compose.simplepokeapp.model.Type
import com.arfdevs.compose.simplepokeapp.ui.ViewModelFactory
import com.arfdevs.compose.simplepokeapp.ui.common.UiState
import com.arfdevs.compose.simplepokeapp.ui.component.TypeRow
import com.arfdevs.compose.simplepokeapp.ui.theme.SimplePokeAppTheme

@Composable
fun DetailScreen(
    pokemonId: Int,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateBack: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value
        .let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getPokemonById(pokemonId)
                }
                is UiState.Success -> {
                    val detailData = uiState.data
                    PokemonDetail(
                        image = detailData.image,
                        name = detailData.name,
                        type = detailData.type,
                        entry = detailData.entry,
                        onBackClick = navigateBack
                    )
                }
                is UiState.Error -> {}
            }
        }
}

@Composable
fun PokemonDetail(
    @DrawableRes image: Int,
    name: String,
    type: Type,
    entry: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.back),
            modifier = Modifier
                .padding(16.dp)
                .clickable { onBackClick() }
        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                modifier = modifier
                    .widthIn(30.dp)
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 6.dp)
            )
            Image(
                painter = painterResource(image),
                contentDescription = "Pokemon image in detail",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .heightIn(300.dp)
                    .widthIn(300.dp)
                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            TypeRow(type = type)
        }
        OutlinedTextField(
            label = { Text(text = stringResource(R.string.pokedex_entry)) },
            value = entry,
            readOnly = true,
            enabled = true,
            textStyle = MaterialTheme.typography.body2,
            modifier = modifier.padding(16.dp),
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    SimplePokeAppTheme {
        PokemonDetail(
            image = R.drawable.poke_2,
            name = "Ivysaur",
            type = Type("Grass", "Poison"),
            entry = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
            onBackClick = {})
    }
}