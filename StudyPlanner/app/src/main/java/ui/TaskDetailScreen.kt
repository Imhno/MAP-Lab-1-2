package ui


import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class TaskDetailUiState(
    val title: String = ""
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
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
            text = uiState.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Button(onClick = onShareClick) {
            Text("Share")
        }

        OutlinedButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}

@Composable
fun TaskDetailRoute(
    title: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        TaskDetailScreen(
            uiState = TaskDetailUiState(title = title),
            onShareClick = {
                val send = Intent(Intent.ACTION_SEND).apply {
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Today I'm studying: $title"
                    )
                    type = "text/plain"
                }

                context.startActivity(
                    Intent.createChooser(send, "Share via")
                )
            },
            onBackClick = onBackClick
        )
    }
}

@Preview(
    showBackground = true,
    name = "Kotlin task"
)
@Composable
private fun KotlinTaskDetailPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(
                title = "Review Kotlin"
            ),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Preview(
    showBackground = true,
    name = "Lab report task"
)
@Composable
private fun LabReportTaskDetailPreview() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(
                title = "Lab 5 report"
            ),
            onShareClick = {},
            onBackClick = {}
        )
    }
}