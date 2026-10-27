package sa.edu.iau.cshj.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ui.AttendanceRoute
import sa.edu.iau.cshj.lab04.ui.theme.Lab04AttendanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab04AttendanceTheme {
                AttendanceRoute()
            }
        }
    }
}