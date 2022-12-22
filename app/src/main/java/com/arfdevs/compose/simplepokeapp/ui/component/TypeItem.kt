package com.arfdevs.compose.simplepokeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arfdevs.compose.simplepokeapp.model.Type
import com.arfdevs.compose.simplepokeapp.ui.theme.SimplePokeAppTheme

@Composable
fun TypeItem(
    modifier: Modifier = Modifier,
    type: String,
    primary: Boolean
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .heightIn(30.dp)
            .widthIn(30.dp)
            .padding(start = 2.dp, end = 2.dp)
            .background(
                color = if (primary) MaterialTheme.colors.primary else MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(14.dp)
            )
    ) {
        Text(
            text = type,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = if (primary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSecondary,
            modifier = modifier
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}

@Composable
fun TypeRow(
    type: Type,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TypeItem(type = type.primaryType, primary = true)

        if (type.secondaryType != "") {
            TypeItem(type = type.secondaryType!!, primary = false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TypeItemPreview() {
    SimplePokeAppTheme {
        TypeItem(type = "Fighting", primary = true)
    }
}

@Preview(showBackground = true)
@Composable
fun TypeRowPreview() {
    SimplePokeAppTheme {
        TypeRow(type = Type("Fire", "Fighting"))
    }
}