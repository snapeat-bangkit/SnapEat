package com.bangkit.snapeat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.bangkit.snapeat.domain.usecases.AppEntryUseCases
import com.bangkit.snapeat.presentation.main.MainScreen
import com.bangkit.snapeat.presentation.navgraph.NavGraph
import com.bangkit.snapeat.presentation.navgraph.Route
import com.bangkit.snapeat.presentation.onboarding.OnBoardingScreen
import com.bangkit.snapeat.ui.theme.SnapEatTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            SnapEatTheme(
                dynamicColor = false
            ) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    val navController = rememberNavController()
                    val startDestination = Route.OnBoardingScreen.route
                    if(startDestination == Route.HomeScreen.route){
                        MainScreen()
                    } else {
                        NavGraph(navController =  navController, startDestination = Route.OnBoardingScreen.route)
                    }
                }
            }
        }
    }
}

