package dev.ar.habits.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ar.habits.core.utils.FeatColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitsTextField(
  value: String,
  modifier: Modifier = Modifier,
  singleLine: Boolean = true,
  enabled: Boolean = true,
  shape: Shape = RoundedCornerShape(10.dp),
  placeholder: String,
  trailingIcon: ImageVector? = null,
  leadingIcon: ImageVector? = null,
  onIconClick: () -> Unit = {},
  maxLines: Int = 1,
  isPassword: Boolean = false,
  isTextHidden: Boolean = false,
  isValid: Boolean = false,
  onValueChange: (String) -> Unit,
) {
  TextField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    singleLine = singleLine,
    enabled = enabled,
    maxLines = maxLines,
    trailingIcon = trailingIcon?.let {
      {
        TrailingIcon(
          isPassword = isPassword,
          trailingIcon = it,
          onIconClick = onIconClick,
          isValid = isValid,
          isTextHidden = isTextHidden
        )
      }
    },
    leadingIcon = leadingIcon?.let {
      {
        LeadingIcon(
          leadingIcon = it,
          onIconClick = onIconClick
        )
      }
    },
    colors = TextFieldDefaults.textFieldColors(
      containerColor = FeatColor.White,
      unfocusedLeadingIconColor = FeatColor.Gray50,
      unfocusedIndicatorColor = Color.Transparent,
      placeholderColor = FeatColor.Gray50,
      focusedSupportingTextColor = Color.Transparent,
      focusedIndicatorColor = Color.Transparent,
      cursorColor = FeatColor.Gray50
    ),
    placeholder = {
      Text(
        text = placeholder,
        fontSize = 12.sp
      )
    },
    shape = shape,
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitsTextFieldMultiline(
  value: String,
  modifier: Modifier = Modifier,
  height: Dp = 100.dp,
  singleLine: Boolean = false,
  enabled: Boolean = true,
  shape: Shape = RoundedCornerShape(10.dp),
  placeholder: String,
  maxLines: Int = 3,
  colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
  onValueChange: (String) -> Unit,
) {
  Box {
    BasicTextField(
      modifier = modifier
        .clip(shape)
        .height(height)
        .background(FeatColor.White)
        .padding(14.dp),
      value = value,
      onValueChange = onValueChange,
      singleLine = singleLine,
      enabled = enabled,
      maxLines = maxLines,
      cursorBrush = SolidColor(FeatColor.Gray50)
    )
    value.ifEmpty {
      Text(
        modifier = Modifier
          .align(Alignment.TopStart)
          .padding(14.dp),
        text = placeholder,
        color = FeatColor.Gray50,
        fontSize = 12.sp
      )
    }

  }

}


@Composable
private fun TrailingIcon(
  isPassword: Boolean = false,
  isTextHidden: Boolean = false,
  trailingIcon: ImageVector? = null,
  isValid: Boolean = false,
  onIconClick: () -> Unit = {}
) {
  if (trailingIcon != null) {
    IconButton(onClick = onIconClick) {
      Icon(
        imageVector = trailingIcon,
        contentDescription = null
      )
    }
  } else if (isPassword) {
    IconButton(onClick = onIconClick) {
      val icon =
        if (isTextHidden) Icons.Default.Visibility else Icons.Default.Visibility
      Icon(
        imageVector = icon,
        contentDescription = null
      )
    }
  } else if (isValid) {
    Icon(
      imageVector = Icons.Default.Check,
      contentDescription = null
    )
  }
}

@Composable
private fun LeadingIcon(
  leadingIcon: ImageVector? = null,
  onIconClick: () -> Unit = {}
) {
  if (leadingIcon != null) {
    IconButton(onClick = onIconClick) {
      Icon(
        imageVector = leadingIcon,
        contentDescription = null
      )
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun HabitTextFieldPrev() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(FeatColor.LightGray)
      .padding(10.dp)
  ) {
    HabitsTextFieldMultiline(
      modifier = Modifier
        .fillMaxWidth(),
      value = "",
      onValueChange = {},
      placeholder = "Email",
    )
    Spacer(modifier = Modifier.height(10.dp))
    HabitsTextField(
      modifier = Modifier
        .fillMaxWidth(),
      value = "",
      onValueChange = {},
      placeholder = "Email",
    )
  }
}