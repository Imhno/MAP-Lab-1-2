package edu.iau.cshj.csc402.lab2



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.lab2.ui.theme.Navy
import edu.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TaskTrackerScreen(modifier: Modifier = Modifier) {
    val tasks = remember {
        mutableStateListOf(
            TeamTask(
                id = 1,
                title = "Create GitHub repository",
                owner = "Fatimah",
                isDone = true
            ),
            TeamTask(
                id = 2,
                title = "Write project proposal",
                owner = "Omar",
                isDone = true
            ),
            TeamTask(
                id = 3,
                title = "Design the login screen",
                owner = "Noura"
            ),
            TeamTask(
                id = 4,
                title = "Set up Android Studio",
                owner = "Yousef"
            )
        )
    }

    val doneCount = tasks.count { it.isDone }
    val openCount = tasks.count { !it.isDone }
    val totalCount = tasks.size

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(24.dp)
        ) {
            Text(
                text = "Team Task Tracker",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Task 11 - Challenge",
                color = Color.White,
                fontSize = 15.sp
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Navy
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SummaryItem(
                    value = doneCount.toString(),
                    label = "Done",
                    valueColor = AndroidGreen
                )

                SummaryItem(
                    value = openCount.toString(),
                    label = "Open"
                )

                SummaryItem(
                    value = totalCount.toString(),
                    label = "Total"
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                bottom = 10.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                items = tasks,
                key = { task -> task.id }
            ) { task ->
                TaskRow(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOfFirst {
                            it.id == task.id
                        }

                        if (index != -1) {
                            tasks[index] = task.copy(
                                isDone = !task.isDone
                            )
                        }
                    }
                )
            }
        }

        Button(
            onClick = {
                val nextId =
                    (tasks.maxOfOrNull { it.id } ?: 0) + 1

                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "haya"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen,
                contentColor = Navy
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "+   Add task",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SummaryItem(
    value: String,
    label: String,
    valueColor: Color = Color.White
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = valueColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color = Color.LightGray,
            fontSize = 13.sp
        )
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onToggle()
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = AndroidGreen,
                    checkmarkColor = Navy
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = task.title,
                    color = if (task.isDone) {
                        Color.Gray
                    } else {
                        Navy
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (task.isDone) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = task.owner,
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskTrackerScreenPreview() {
    TaskTrackerScreen()
}