package com.anelcc.tonal.presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anelcc.tonal.ui.theme.TonalIntervioewTheme


@Composable
fun MovementListScreen(viewModel: MovementViewModel = hiltViewModel<MovementViewModel>(), onclick: () -> Unit) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchMovementList()
    }

    LazyColumn {
        items(uiState.movementList.size) {
            Row (modifier = Modifier.padding(top = 56.dp).fillMaxSize().clickable {
                viewModel.onSelectItem(uiState.movementList[it])
                onclick.invoke()
            }) {
                Text(text = uiState.movementList[it].name)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MovementListPreview() {
    TonalIntervioewTheme {
        MovementListScreen {

        }
    }
}