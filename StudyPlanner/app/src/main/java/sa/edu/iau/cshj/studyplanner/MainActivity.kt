package sa.edu.iau.cshj.studyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ui.PlannerHomeRoute
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyPlannerTheme {
                PlannerHomeRoute()
            }
        }
    }
}