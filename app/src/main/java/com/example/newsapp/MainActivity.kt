package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.newsapp.presentation.navgraph.NavGraph
import com.example.newsapp.ui.theme.NewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }

        enableEdgeToEdge()


        setContent {
            NewsAppTheme(dynamicColor = false) {

                ChangeSystemUiColor()

                Navigation()
            }
        }
    }

    @Composable
    private fun Navigation() {
        Box(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            val startDestination = viewModel.startDestination
            NavGraph(startDestination = startDestination)
        }
    }

    @Composable
    private fun ChangeSystemUiColor() {
        val isSystemInDarkTheme = isSystemInDarkTheme()
        val systemController = rememberSystemUiController()

        SideEffect {
            systemController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = !isSystemInDarkTheme
            )
        }
    }
}

