package edu.iau.cshj.csc402.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CSC402Lab3Theme {
                OrderPuzzleScreen()
            }
        }
    }
}