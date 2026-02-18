package com.anelcc.tonal.presenter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.anelcc.tonal.ui.theme.TonalIntervioewTheme


@Composable
fun MovementDetailsScreen(viewModel: MovementViewModel) {
    val selectedItem by viewModel.selectedItem.collectAsState()

    Column(modifier = Modifier.padding(top = 56.dp).fillMaxSize()) {
        Text("${selectedItem?.description}")
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .size(240.dp),
            model = "${selectedItem?.url}",
            contentDescription = "${ selectedItem?.name}",
            onLoading = { /* Show loading spinner */ },
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MovementDetailsPreview() {
    TonalIntervioewTheme {
        MovementDetailsScreen(MovementViewModel())
    }
}