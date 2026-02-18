package com.anelcc.tonal.presenter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anelcc.tonal.ui.theme.TonalIntervioewTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovementListScreen(viewModel: MovementViewModel = hiltViewModel<MovementViewModel>(), onclick: () -> Unit) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchMovementList()
    }


    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Movements")
                }
            )
        }) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .padding(top = 16.dp)
            .fillMaxSize()) {
            items(uiState.movementList.size) {
                Row (modifier = Modifier.fillMaxWidth().padding(16.dp).clickable {
                    viewModel.onSelectItem(uiState.movementList[it])
                    onclick.invoke()
                }) {
                    Text(text = uiState.movementList[it].name,
                        style = MaterialTheme.typography.titleLarge)
                }
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