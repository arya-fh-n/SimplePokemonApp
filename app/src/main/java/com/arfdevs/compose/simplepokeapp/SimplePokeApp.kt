package com.arfdevs.compose.simplepokeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arfdevs.compose.simplepokeapp.ui.navigation.Screen
import com.arfdevs.compose.simplepokeapp.ui.screens.about.AboutScreen
import com.arfdevs.compose.simplepokeapp.ui.screens.detail.DetailScreen
import com.arfdevs.compose.simplepokeapp.ui.screens.home.HomeScreen
import com.arfdevs.compose.simplepokeapp.ui.theme.SimplePokeAppTheme

@Composable
fun SimplePokeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { TopBar(navController) },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { pokemonId ->
                    navController.navigate(Screen.Detail.createRoute(pokemonId))
                })
            }
            composable(Screen.About.route) {
                AboutScreen()
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("pokemonId") ?: -1
                DetailScreen(
                    pokemonId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
            }
        }
    }
}

@Composable
fun TopBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(text = "Simple Pokemon App")
        },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Setting")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    modifier = modifier.semantics(mergeDescendants = true) {
                        contentDescription = "about_page"
                    },
                    onClick = { navController.navigate(Screen.About.route) }
                ) {
                    Text(text = "About Me")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SimplePokeAppPreview() {
    SimplePokeAppTheme {
        SimplePokeApp()
    }
}
