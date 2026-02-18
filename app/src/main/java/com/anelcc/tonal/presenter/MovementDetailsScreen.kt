package com.anelcc.tonal.presenter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.anelcc.tonal.ui.theme.TonalIntervioewTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovementDetailsScreen(viewModel: MovementViewModel = hiltViewModel<MovementViewModel>(), onBackClick: () -> Unit) {
    val selectedItem by viewModel.selectedItem.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Movements")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackClick.invoke()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)
            .fillMaxSize()) {
            Text("${selectedItem?.description}")
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .align(Alignment.CenterHorizontally)
                    .size(240.dp),
                model = "${selectedItem?.url}",
                contentDescription = "${selectedItem?.name}",
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MovementDetailsPreview() {
    TonalIntervioewTheme {
        MovementDetailsScreen(){}
    }
}