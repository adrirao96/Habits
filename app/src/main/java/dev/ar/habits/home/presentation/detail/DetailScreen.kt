package dev.ar.habits.home.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ar.habits.R
import dev.ar.habits.core.presentation.components.HabitsButtonCircle
import dev.ar.habits.core.presentation.components.HabitsTextField
import dev.ar.habits.core.presentation.components.HabitsTextFieldMultiline
import dev.ar.habits.core.utils.FeatColor
import dev.ar.habits.core.utils.shadow
import dev.ar.habits.home.presentation.detail.components.DetailFrequency
import dev.ar.habits.home.presentation.detail.components.DetailReminder
import java.time.DayOfWeek
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
  var value by remember {
    mutableStateOf(TextFieldValue())
  }
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    containerColor = FeatColor.LightGray,
    topBar = {
      CenterAlignedTopAppBar(
        modifier = Modifier.padding(10.dp),
        title = {
          Text(text = "New habit", fontSize = 24.sp)
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = FeatColor.LightGray
        ),
        navigationIcon = {
          HabitsButtonCircle(
            modifier = Modifier.size(40.dp),
            icon = Icons.Default.ArrowBack,
            containerColor = FeatColor.Blue10,
            contentColor = FeatColor.Gray,
          ) {

          }
        }
      )
    },
    floatingActionButton = {
      HabitsButtonCircle(
        modifier = Modifier
          .size(50.dp)
          .shadow(
            blurRadius = 20.dp,
            offsetY = 10.dp,
            color = FeatColor.Blue50
          ),
        icon = Icons.Default.Check,
        onClick = {},
      )
    }
  ) {
    Box(
      modifier = Modifier
        .padding(it)
        .fillMaxSize(),
    ) {
      Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
      )
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        HabitsTextField(
          modifier = Modifier.fillMaxWidth(),
          value = "",
          placeholder = "Enter habit name",
          onValueChange = {

          }
        )
        HabitsTextFieldMultiline(
          modifier = Modifier
            .fillMaxWidth(),
          value = value.text,
          placeholder = "Enter description",
          maxLines = 3,
          onValueChange = {
            value = value.copy(it)
          }
        )
        DetailFrequency(
          selectedDays = DayOfWeek.values().toList(),
          onFrequencyChange = {
          }
        )
        DetailReminder(LocalTime.now(), onTimeClick = {})
      }
    }
  }
}

@Preview
@Composable
fun DetailScreenPrev() {
  Column(
    modifier = Modifier
      .fillMaxSize()
  ) {
    DetailScreen()
  }
}