package dev.ar.habits.authentication.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ar.habits.authentication.presentation.components.Logo
import dev.ar.habits.core.utils.FeatColor
import dev.ar.habits.R
import dev.ar.habits.core.presentation.components.HabitsButton
import dev.ar.habits.core.presentation.components.HabitsTextField

@Composable
fun SignUpScreen(
  onClickSignUp: () -> Unit,
  onClickSignIn: () -> Unit
) {
  Column(
    modifier = Modifier
      .background(FeatColor.LightBlue)
      .fillMaxSize()
  ) {
    Title(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
    )
    Logo(
      modifier = Modifier
        .fillMaxWidth()
        .weight(4f),
      id = R.drawable.signup
    )
    Body(
      modifier = Modifier
        .fillMaxWidth()
        .weight(3.5f),
      onClickSignIn = onClickSignIn,
      onClickSignUp = onClickSignUp
    )
  }
}

@Composable
fun Title(
  modifier: Modifier
) {
  Box(
    modifier = modifier,
    contentAlignment = Alignment.BottomCenter
  ) {
    Text(
      text = "Create your account",
      fontSize = 20.sp,
    )
  }
}

@Composable
fun Body(
  modifier: Modifier,
  onClickSignIn: () -> Unit,
  onClickSignUp: () -> Unit
) {
  Box(modifier = modifier) {
    Column(
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp),
      verticalArrangement = Arrangement.spacedBy(20.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      HabitsTextField(
        value = "",
        placeholder = "Email",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth()
      )
      HabitsTextField(
        value = "",
        placeholder = "Password",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        isPassword = true,
        trailingIcon = Icons.Default.Visibility
      )
      HabitsButton(
        text = "Create account",
        icon = painterResource(id = R.drawable.ic_signup),
        onClick = onClickSignUp
      )
      TextButton(
        colors = ButtonDefaults.textButtonColors(
          contentColor = FeatColor.Gray50
        ),
        onClick = onClickSignIn
      ) {
        Row(
          horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
          Text(text = "Already have an account?")
          Text(text = "Sign in", color = FeatColor.Blue, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

@Preview
@Composable
fun SignUpPrev() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(FeatColor.White)
  ) {
    SignUpScreen(
      onClickSignUp = {},
      onClickSignIn = {}
    )
  }
}