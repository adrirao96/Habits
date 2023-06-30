package dev.ar.habits.authentication.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import dev.ar.habits.R

@Composable
fun Logo(
  modifier: Modifier,
  @DrawableRes id: Int
) {
  Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
  ) {
    Image(painter = painterResource(id = id), contentDescription = null)
  }
}