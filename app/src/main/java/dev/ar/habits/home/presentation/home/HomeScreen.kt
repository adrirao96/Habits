package dev.ar.habits.home.presentation.home

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ar.habits.core.presentation.components.HabitsButtonCircle
import dev.ar.habits.core.utils.FeatColor
import dev.ar.habits.R
import dev.ar.habits.core.utils.shadow
import dev.ar.habits.home.presentation.home.components.HomeDateSelector
import dev.ar.habits.home.presentation.home.components.HomeHabit
import dev.ar.habits.home.presentation.home.components.HomeQuote
import java.time.LocalDate
import java.time.ZonedDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  onClickAddHabit: () -> Unit
) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    containerColor = FeatColor.LightGray,
    topBar = {
      CenterAlignedTopAppBar(
        modifier = Modifier.padding(10.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = FeatColor.LightGray
        ),
        title = {
          Text(
            "Home",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = FeatColor.Gray
          )
        },
        navigationIcon = {
          HabitsButtonCircle(
            modifier = Modifier.size(40.dp),
            icon = painterResource(id = R.drawable.ic_settings),
            containerColor = FeatColor.Blue10,
            contentColor = FeatColor.Gray,
            size = 24.dp
          ) {
          }
        },
        actions = {
          HabitsButtonCircle(
            modifier = Modifier.size(48.dp),
            image = painterResource(id = R.drawable.ellipse_2),
          ) {

          }
        },

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
        icon = Icons.Default.Add,
        onClick = onClickAddHabit,
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
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        HomeQuote(
          quote = "We first make our habits, and then our habits make us.",
          author = "Anonymous",
          imageId = R.drawable.ic_card,
          modifier = Modifier
            .shadow(
              blurRadius = 20.dp,
              offsetY = 10.dp,
              color = FeatColor.Black25
            )
        )

        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "Habits".uppercase(),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = FeatColor.Blue
          )
          Spacer(modifier = Modifier.width(10.dp))
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            HomeDateSelector(
              selectedDate = ZonedDateTime.now(),
              mainDate = ZonedDateTime.now(),
              onDateClick = {}
            )
          }
        }

        LazyColumn(
          modifier = Modifier
            .fillMaxSize(),
          content = {
            items(10) {
              if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Column(modifier = Modifier.padding(vertical = 5.dp)) {
                  HomeHabit(
                    selectedDate = LocalDate.now(),
                    onCheckedChange = { /*TODO*/ },
                    onHabitClick = { /*TODO*/ },
                  )
                }
              }
            }
          }
        )
      }
    }
  }
}

@Preview
@Composable
fun HomePrev() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(FeatColor.White)
  ) {
    HomeScreen {}
  }
}