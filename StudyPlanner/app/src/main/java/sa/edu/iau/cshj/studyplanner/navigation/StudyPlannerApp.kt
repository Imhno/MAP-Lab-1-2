package sa.edu.iau.cshj.studyplanner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ui.PlannerHomeRoute
import ui.TaskDetailRoute

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlannerHome
    ) {
        composable<PlannerHome> {
            PlannerHomeRoute(
                onTaskClick = { title ->
                    navController.navigate(
                        TaskDetail(title = title)
                    )
                }
            )
        }

        composable<TaskDetail> { backStackEntry ->
            val detail = backStackEntry.toRoute<TaskDetail>()

            TaskDetailRoute(
                title = detail.title,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}