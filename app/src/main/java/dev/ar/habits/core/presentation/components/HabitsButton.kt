package dev.ar.habits.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ar.habits.core.utils.FeatColor
import dev.ar.habits.core.utils.shadow

@Composable
fun HabitsButton(
  modifier: Modifier = Modifier,
  text: String? = null,
  containerColor: Color = FeatColor.Blue,
  contentColor: Color = FeatColor.White,
  fontWeight: FontWeight? = FontWeight.Light,
  icon: ImageVector? = null,
  shape: Shape = ButtonDefaults.shape,
  onClick: () -> Unit
) {
  Button(
    modifier = modifier,
    shape = shape,
    colors = ButtonDefaults.buttonColors(
      containerColor = containerColor,
      contentColor = contentColor
    ),
    onClick = onClick
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
      icon?.let {
        Icon(
          imageVector = it,
          contentDescription = null,
          modifier = Modifier.size(20.dp)
        )
      }
      text?.let {
        Text(
          text = it,
          fontWeight = fontWeight,
        )
      }
    }
  }
}

@Composable
fun HabitsButton(
  modifier: Modifier = Modifier,
  text: String? = null,
  containerColor: Color = FeatColor.Blue,
  contentColor: Color = FeatColor.White,
  fontWeight: FontWeight? = FontWeight.Light,
  icon: Painter? = null,
  shape: Shape = ButtonDefaults.shape,
  onClick: () -> Unit
) {
  Button(
    modifier = modifier,
    shape = shape,
    colors = ButtonDefaults.buttonColors(
      containerColor = containerColor,
      contentColor = contentColor
    ),
    onClick = onClick
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
      icon?.let {
        Icon(
          painter = it,
          contentDescription = null,
          modifier = Modifier.size(20.dp)
        )
      }
      text?.let {
        Text(
          text = it,
          fontWeight = fontWeight,
        )
      }
    }
  }
}

@Composable
fun HabitsButtonCircle(
  modifier: Modifier = Modifier,
  text: String? = null,
  containerColor: Color = FeatColor.Blue,
  contentColor: Color = FeatColor.White,
  fontWeight: FontWeight? = FontWeight.Light,
  icon: ImageVector? = null,
  shape: Shape = CircleShape,
  onClick: () -> Unit
) {
  Button(
    modifier = modifier,
    shape = shape,
    colors = ButtonDefaults.buttonColors(
      containerColor = containerColor,
      contentColor = contentColor
    ),
    contentPadding = PaddingValues(0.dp),
    onClick = onClick
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
      icon?.let {
        Icon(
          imageVector = it,
          contentDescription = null,
          modifier = Modifier.size(20.dp)
        )
      }
      text?.let {
        Text(
          text = it,
          fontWeight = fontWeight,
        )
      }
    }
  }
}

@Composable
fun HabitsButtonCircle(
  modifier: Modifier = Modifier,
  text: String? = null,
  containerColor: Color = FeatColor.Blue,
  contentColor: Color = FeatColor.White,
  fontWeight: FontWeight? = FontWeight.Light,
  icon: Painter? = null,
  shape: Shape = CircleShape,
  size: Dp = 20.dp,
  onClick: () -> Unit
) {
  Button(
    modifier = modifier,
    shape = shape,
    colors = ButtonDefaults.buttonColors(
      containerColor = containerColor,
      contentColor = contentColor
    ),
    contentPadding = PaddingValues(0.dp),
    onClick = onClick
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
      icon?.let {
        Image(
          painter = icon,
          contentDescription = null,
          modifier = Modifier.size(size)
        )
      }
      text?.let {
        Text(
          text = it,
          fontWeight = fontWeight,
        )
      }
    }
  }
}

@Composable
fun HabitsButtonCircle(
  modifier: Modifier = Modifier,
  containerColor: Color = FeatColor.Blue,
  contentColor: Color = FeatColor.White,
  image: Painter? = null,
  shape: Shape = CircleShape,
  onClick: () -> Unit
) {
  Button(
    modifier = modifier,
    shape = shape,
    colors = ButtonDefaults.buttonColors(
      containerColor = containerColor,
      contentColor = contentColor
    ),
    contentPadding = PaddingValues(0.dp),
    onClick = onClick
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
      image?.let {
        Image(
          painter = image,
          contentDescription = null,
          modifier = Modifier.fillMaxSize()
        )
      }
    }
  }
}

@Preview
@Composable
fun HabitsButtonPrev() {
  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    HabitsButton(
      text = "Login",
      icon = Icons.TwoTone.Home,
      onClick = {}
    )
    HabitsButton(
      icon = Icons.TwoTone.Home,
      onClick = {}
    )
    HabitsButtonCircle(
      modifier = Modifier
        .size(50.dp)
        .shadow(
          color = Color(0xFF3742FA),
          borderRadius = 80.dp,
          blurRadius = 12.dp,
          offsetY = 10.dp,
          spread = (-3).dp
        ),
      icon = Icons.TwoTone.Home
    ) {

    }
  }
}