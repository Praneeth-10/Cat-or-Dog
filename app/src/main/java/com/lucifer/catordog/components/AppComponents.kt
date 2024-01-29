package com.lucifer.catordog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucifer.catordog.R

@Composable
fun TopAppBar(strVal: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp),
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


@Composable
fun TextComponent(textValue: String, textSize: TextUnit, textColor: Color = Color.Black) {
    Text(
        text = textValue,
        fontSize = textSize,
        fontWeight = FontWeight.Light,
        color = textColor
    )
}

@Composable
fun TextInputComponent(labelName: String, onEventChange: (value: String) -> Unit) {
    var currentValue by remember {
        mutableStateOf("")
    }

    val lFocus = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            onEventChange(it)
            currentValue = it
        },
        label = {
            Text(
                text = labelName,
                style = TextStyle.Default.copy(fontSize = 25.sp)
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = 25.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions {
            lFocus.clearFocus()
        }
    )
}


@Composable
fun AnimalCard(imgVector: ImageVector, imgDescription: String = "Testing", selected: Boolean) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 2.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                imageVector = imgVector,
                contentDescription = imgDescription
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        TopAppBar("Hi, There")
        TextComponent(textValue = "hi  Testing", textSize = 24.sp)
        TextInputComponent(labelName = "Entering", onEventChange = {
        })
    }
}

@Preview
@Composable
fun AnimalCardPrev() {
    AnimalCard(Icons.Outlined.AccountCircle, selected = true)
}