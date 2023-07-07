package dev.ar.habits.authentication.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ar.habits.core.utils.FeatColor
import dev.ar.habits.R
import dev.ar.habits.authentication.presentation.components.Logo
import dev.ar.habits.core.presentation.components.HabitsButton
import dev.ar.habits.core.presentation.components.HabitsTextField

@Composable
fun LoginScreen(
  onClickLogin: () -> Unit,
  onClickSignUp: () -> Unit
) {
  Column(
    modifier = Modifier
      .background(FeatColor.LightBlue)
      .fillMaxSize()
  ) {
    Welcome(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
    )
    Logo(
      modifier = Modifier
        .fillMaxWidth()
        .weight(4f),
      id = R.drawable.login
    )
    Body(
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
        .background(FeatColor.LightGray)
        .weight(3.5f),
      onClickLogin = onClickLogin,
      onClickSignUp = onClickSignUp
    )
  }
}

@Composable
fun Welcome(
  modifier: Modifier
) {
  Box(
    modifier = modifier,
    contentAlignment = Alignment.BottomCenter
  ) {
    Row(
      horizontalArrangement = Arrangement.spacedBy(5.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "Welcome to",
        fontSize = 20.sp
      )
      Text(
        text = "Habits".uppercase(),
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold
      )
    }
  }
}

@Composable
fun Body(
  modifier: Modifier,
  onClickLogin: () -> Unit,
  onClickSignUp: () -> Unit
) {
  Box(
    modifier = modifier,
  ) {
    Column(
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp),
      verticalArrangement = Arrangement.spacedBy(20.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = "Login",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = FeatColor.Gray
      )
      HabitsTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        placeholder = "Email"
      )
      HabitsTextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        placeholder = "Password",
        trailingIcon = Icons.Default.Visibility,
        isPassword = true
      )
      HabitsButton(
        text = "Login",
        icon = painterResource(id = R.drawable.ic_login),
        onClick = onClickLogin
      )
      TextButton(
        colors = ButtonDefaults.textButtonColors(
          contentColor = FeatColor.Gray50
        ),
        onClick = onClickSignUp
      ) {
        Row(
          horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {
          Text(text = "Don't have an account?")
          Text(text = "Sign up", color = FeatColor.Blue, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}

@Preview
@Composable
fun LoginScreenPrev() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(FeatColor.White)
  ) {
    LoginScreen(
      onClickLogin = {},
      onClickSignUp = {}
    )
  }
}