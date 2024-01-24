package com.lucifer.catordog.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucifer.catordog.R

@Composable
fun TopAppBar(strVal: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp,5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        Text(
            text = strVal,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = stringResource(id = R.string.bitmap_description)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar("Hi, There")
}