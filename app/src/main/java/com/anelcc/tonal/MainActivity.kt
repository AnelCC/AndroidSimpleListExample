package com.anelcc.tonal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anelcc.tonal.presenter.MovementDetailsScreen
import com.anelcc.tonal.presenter.MovementListScreen
import com.anelcc.tonal.presenter.MovementViewModel
import com.anelcc.tonal.ui.theme.TonalIntervioewTheme

/*
Hiring interview:

1st screen: Create a Movement list page
Display a list of movements in a vertical list where each row has the movement image (optional) and the movement name.


Note: Focus on a working solution with a basic structured architecture and briefly mention things you would add in a production app. Focus on keeping it simple to allow time for a potential follow up step.

To avoid having to set up retrofit, here is a parsed list of movements:

data class Movement(val id: String, val name: String, val url: String, val description: String)
val movements = listOf(
    Movement(id = "1", name = "Bench Press", url = "https://tonal.com/cdn/shop/files/paul_3770x_2_screen.webp?v=1741275088&width=768", description = "Upper-body exercise that uses the chest, shoulders and triceps."),
    Movement(id = "2", name = "Goblet Squat", url = "https://tonal.com/cdn/shop/files/paul_3383x_2_screen.webp?v=1741288691&width=768", description = "Lower-body that involves legs, glutes and core."),
    Movement(id = "3", name = "Biceps Curl", url = "https://tonal.com/cdn/shop/files/jarod_4109x_2_screen.webp?v=1741275614&width=768", description = "Upper-body exercise that lifts weight through elbow flexion."),
    Movement(id = "4", name = "Rotational Chop", url = "https://tonal.com/cdn/shop/files/kelly_6315x_2_screen.jpg?v=1741291777&width=768", description = "Core-strengthening exercise that trains the abdominals and obliques.")
)
2nd screen: Movement details page:
Navigate from the selected movement with jetpack navigation routes.
Display the selected image (optional), name and description.

*/



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TonalIntervioewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppTonal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun AppTonal(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel = MovementViewModel()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            MovementListScreen(viewModel) {
                navController.navigate("details")
            }
        }
        composable("details") {
            MovementDetailsScreen(viewModel)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TonalIntervioewTheme {
        AppTonal()
    }
}