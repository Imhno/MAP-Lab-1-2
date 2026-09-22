package edu.iau.cshj.csc402.lab2


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.lab2.ui.theme.Navy
import edu.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {
    val courses = remember {
        listOf(
            Course(
                code = "CSC 402",
                title = "Mobile Application Programming",
                credits = 3,
                days = "Mon / Wed"
            ),
            Course(
                code = "CSC 311",
                title = "Database Systems",
                credits = 4,
                days = "Sun / Tue"
            ),
            Course(
                code = "CSC 340",
                title = "Operating Systems",
                credits = 3,
                days = "Mon / Wed"
            ),
            Course(
                code = "MATH 202",
                title = "Discrete Mathematics",
                credits = 3,
                days = "Sun / Thu"
            ),
            Course(
                code = "ENG 214",
                title = "Technical Writing",
                credits = 2,
                days = "Tue"
            ),
            Course(
                code = "PHYS 105",
                title = "General Physics II",
                credits = 4,
                days = "Sun / Tue"
            ),
            Course(
                code = "ISLM 101",
                title = "Islamic Culture",
                credits = 2,
                days = "Thu"
            )
        )
    }

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
                text = "CSC 402 Lab 2",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Task 10 - My Courses",
                color = Color.White,
                fontSize = 15.sp
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course = course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {
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
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(AndroidGreen)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = course.code,
                    color = Navy,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = course.title,
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = course.days,
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }

            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(AndroidGreen)
                    .padding(horizontal = 12.dp, vertical = 7.dp)
            ) {
                Text(
                    text = "${course.credits} credits",
                    color = Navy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}