package dev.ar.habits.authentication.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.ar.habits.authentication.presentation.login.LoginScreen
import dev.ar.habits.authentication.presentation.signup.SignUpScreen
import dev.ar.habits.core.graph.Graph

fun NavGraphBuilder.authNavigationGraph(navController: NavHostController) {
  navigation(
    route = Graph.AUTHENTICATION,
    startDestination = AuthScreen.Login.route
  ) {
    composable(AuthScreen.Login.route) {
      LoginScreen(
        onClickLogin = {
          navController.navigate(Graph.HOME)
        },
        onClickSignUp = {
          navController.navigate(AuthScreen.SignUp.route)
        }
      )
    }
    composable(AuthScreen.SignUp.route) {
      SignUpScreen(
        onClickSignIn = {
          navController.navigate(AuthScreen.Login.route)
        },
        onClickSignUp = { /*TODO*/ }
      )
    }
  }
}

sealed class AuthScreen(val route: String) {
  object Login : AuthScreen(route = "LOGIN")
  object SignUp : AuthScreen(route = "SIGN_UP")
}