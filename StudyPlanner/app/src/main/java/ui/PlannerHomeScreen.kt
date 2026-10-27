package ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "Welcome to your Study Planner",
    val totalTasks: Int = 0,
    val doneTasks: Int = 0
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onCompleteTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = uiState.greeting,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "${uiState.doneTasks} of ${uiState.totalTasks} done",
            style = MaterialTheme.typography.titleLarge
        )

        Button(
            onClick = onCompleteTask,
            enabled = uiState.doneTasks < uiState.totalTasks
        ) {
            Text("Complete one task")
        }
    }
}

@Composable
fun PlannerHomeRoute() {
    var uiState by remember {
        mutableStateOf(
            PlannerUiState(
                greeting = "Welcome to your Study Planner",
                totalTasks = 3,
                doneTasks = 0
            )
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        PlannerHomeScreen(
            uiState = uiState,
            onCompleteTask = {
                if (uiState.doneTasks < uiState.totalTasks) {
                    uiState = uiState.copy(
                        doneTasks = uiState.doneTasks + 1
                    )
                }
            }
        )
    }
}

@Preview(
    showBackground = true,
    name = "Nothing done yet"
)
@Composable
private fun PlannerNothingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Welcome to your Study Planner",
                totalTasks = 3,
                doneTasks = 0
            ),
            onCompleteTask = {}
        )
    }
}

@Preview(
    showBackground = true,
    name = "Everything done"
)
@Composable
private fun PlannerEverythingDonePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                greeting = "Welcome to your Study Planner",
                totalTasks = 3,
                doneTasks = 3
            ),
            onCompleteTask = {}
        )
    }
}