package dev.ar.habits.core.utils

import androidx.compose.ui.graphics.Color

@JvmInline
value class FeatColor(val value: ULong) {
  companion object {
    val Black25 = Color(0x41000000)
    val White = Color(0xFFFFFFFF)
    val LightGray = Color(0xFFF1F2F6)
    val Gray = Color(0xFF2F3542)
    val Gray50 = Color(0x802F3542)
    val Blue = Color(0xFF3742FA)
    val Blue10 = Color(0x193742FA)
    val Blue50 = Color(0x803742FA)
    val LightBlue = Color(0xFF8EB4ED)
  }
}