package dev.ar.habits.home.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.ar.habits.core.graph.Graph
import dev.ar.habits.home.presentation.detail.DetailScreen
import dev.ar.habits.home.presentation.home.HomeScreen

fun NavGraphBuilder.homeNavigationGraph(navController: NavHostController) {
  navigation(route = Graph.HOME, startDestination = HomeScreen.Home.route) {
    composable(route = HomeScreen.Home.route) {
      HomeScreen(
        onClickAddHabit = {
          navController.navigate(HomeScreen.Detail.route)
        }
      )
    }
    composable(route = HomeScreen.Detail.route) {
      DetailScreen()
    }
  }
}

sealed class HomeScreen(val route: String) {
  object Home : HomeScreen(route = "HOME")
  object Detail : HomeScreen(route = "DETAIL")
}