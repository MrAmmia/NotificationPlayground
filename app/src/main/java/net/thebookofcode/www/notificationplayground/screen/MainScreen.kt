package net.thebookofcode.www.notificationplayground.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import net.thebookofcode.www.notificationplayground.MainViewModel
import net.thebookofcode.www.notificationplayground.navigation.Screen

@Composable
fun MainScreen(navController: NavHostController,
               mainViewModel: MainViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = mainViewModel::showNotification) {
            Text(text = "Simple Notification")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = mainViewModel::updateNotification) {
            Text(text = "Update Notification")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = mainViewModel::cancelNotification) {
            Text(text = "Cancel Notification")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = mainViewModel::showProgress) {
            Text(text = "Progress")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            navController.navigate(
                Screen.Details.passArgument(
                    message = "Coming from Main Screen."
                )
            )
        }) {
            Text(text = "DETAILS SCREEN")
        }

    }
}