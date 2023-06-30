package dev.ar.habits.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ar.habits.core.utils.FeatColor
import dev.ar.habits.core.utils.shadow

@Composable
fun HabitsCard(

) {
  Card(
    modifier = Modifier.shadow(
      blurRadius = 20.dp,
      offsetY = 10.dp,
      color = FeatColor.Black25
    ),
    colors = CardDefaults.cardColors(
      containerColor = FeatColor.White,
    ),
  ) {
    Column(
      modifier = Modifier.padding(20.dp)
    ) {
      Text(text = "Habits Card")
    }
  }
}

@Preview
@Composable
fun HabitsCar() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(FeatColor.LightGray)
      .padding(22.dp)
  ) {
    HabitsCard()
  }
}