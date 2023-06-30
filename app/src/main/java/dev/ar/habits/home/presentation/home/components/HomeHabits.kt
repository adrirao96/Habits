package dev.ar.habits.home.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ar.habits.core.utils.FeatColor
import java.time.LocalDate

@Composable
fun HomeHabit(
//  habit: Habit,
  selectedDate: LocalDate,
  onCheckedChange: () -> Unit,
  onHabitClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier.fillMaxWidth()
      .clip(RoundedCornerShape(12.dp))
      .background(Color.White)
      .clickable {
        onHabitClick()
      }.padding(19.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(text = "habit.name", fontWeight = FontWeight.Bold, fontSize = 14.sp)
    HabitCheckbox(isChecked = false) {
      onCheckedChange()
    }
  }
}

@Composable
fun HabitCheckbox(
  isChecked: Boolean,
  modifier: Modifier = Modifier,
  onCheckedChange: () -> Unit
) {
  val backgroundColor =
    if (isChecked) FeatColor.Blue else FeatColor.Blue10

  Box(
    modifier = modifier
      .size(35.dp)
      .clip(RoundedCornerShape(12.dp))
      .background(color = backgroundColor)
      .clickable {
        onCheckedChange()
      },
    contentAlignment = Alignment.Center
  ) {
    if (isChecked) {
      Icon(
        imageVector = Icons.Default.Check,
        contentDescription = "checked",
        tint = FeatColor.White
      )
    }
  }
}