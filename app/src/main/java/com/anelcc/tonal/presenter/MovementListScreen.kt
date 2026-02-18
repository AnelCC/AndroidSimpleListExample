package com.anelcc.tonal.presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anelcc.tonal.ui.theme.TonalIntervioewTheme


@Composable
fun MovementListScreen(viewModel: MovementViewModel, onclick: () -> Unit) {
    val movements = viewModel.movements

    LazyColumn {
        items(movements.size) {
            Row (modifier = Modifier.padding(top = 56.dp).fillMaxSize().clickable {
                viewModel.onSelectItem(movements[it])
                onclick.invoke()
            }) {
                Text(text = movements[it].name)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MovementListPreview() {
    TonalIntervioewTheme {
        MovementListScreen(MovementViewModel()) {

        }
    }
}