package io.nirmal.croix.presentation.editProfile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.nirmal.croix.presentation.ui.theme.SpaceMedium

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = Color.LightGray,
    onChipClick: () -> Unit ={}
) {
    Text(
        text = text,
        color = if(selected) selectedColor else unSelectedColor,
        modifier = modifier
            .border(
                width = 1.dp,
                color = if(selected) selectedColor else unSelectedColor,
                shape = RoundedCornerShape(50.dp)
                )
            .padding(SpaceMedium)
            .clickable {
                onChipClick
            }
    )
}