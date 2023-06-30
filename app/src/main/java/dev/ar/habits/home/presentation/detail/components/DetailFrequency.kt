package dev.ar.habits.home.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ar.habits.core.utils.FeatColor
import java.time.DayOfWeek

@Composable
fun DetailFrequency(
  selectedDays: List<DayOfWeek>,
  onFrequencyChange: (DayOfWeek) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(12.dp))
      .background(Color.White)
  ) {
    Text(
      text = "Frequency",
      modifier = Modifier.padding(14.dp),
      color = FeatColor.Gray50,
    )
    Divider(color = FeatColor.LightGray)
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min)
        .padding(horizontal = 4.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      val days = DayOfWeek.values()
      days.forEachIndexed { index, dayOfWeek ->
        DetailFrequencyDate(
          date = dayOfWeek,
          isChecked = selectedDays.contains(dayOfWeek),
          onCheckedChange = { onFrequencyChange(dayOfWeek) }
        )
        if (index < days.size - 1) {
          Divider(
            modifier = Modifier
              .fillMaxHeight()
              .width(1.dp),
            color = FeatColor.White
          )
        }
      }
    }
  }
}