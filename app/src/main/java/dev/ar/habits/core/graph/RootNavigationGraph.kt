package dev.ar.habits.core.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.ar.habits.authentication.graph.authNavigationGraph
import dev.ar.habits.home.graph.homeNavigationGraph

@Composable
fun RootNavigationGraph(
  navController: NavHostController
) {
  NavHost(
    navController = navController,
    route = Graph.ROOT,
    startDestination = Graph.AUTHENTICATION
  ) {
    authNavigationGraph(navController = navController)
    homeNavigationGraph(navController = navController)
  }
}

object Graph {
  const val ROOT = "root_graph"
  const val AUTHENTICATION = "auth_graph"
  const val HOME = "home_graph"
}