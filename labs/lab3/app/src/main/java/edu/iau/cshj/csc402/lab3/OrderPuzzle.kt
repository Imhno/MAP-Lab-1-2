package edu.iau.cshj.csc402.lab3


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402Lab3Theme

private val PuzzleGreen = Color(0xFF3DDC84)

@Composable
fun ChainA(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .background(PuzzleGreen)
            .padding(24.dp)
    )
}

@Composable
fun ChainB(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .padding(24.dp)
            .background(PuzzleGreen)
    )
}

@Composable
fun ChainC(modifier: Modifier = Modifier) {
    Text(
        text = "content",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(PuzzleGreen)
            .padding(24.dp)
    )
}

@Composable
fun OrderPuzzleScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "Chain A: background then padding")

        ChainA(
            modifier = Modifier.border(
                width = 1.dp,
                color = Color.Gray
            )
        )

        Text(text = "Chain B: padding then background")

        ChainB(
            modifier = Modifier.border(
                width = 1.dp,
                color = Color.Gray
            )
        )

        Text(text = "Chain C: clip then background")

        ChainC(
            modifier = Modifier.border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(20.dp)
            )
        )

        Text(text = "Clickable before padding")

        Text(
            text = "Tap near my edge",
            modifier = Modifier
                .clickable {
                    println("First button clicked")
                }
                .padding(16.dp)
                .background(Color.LightGray)
        )

        Text(text = "Padding before clickable")

        Text(
            text = "Tap near my edge",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    println("Second button clicked")
                }
                .background(Color.LightGray)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderPuzzlePreview() {
    CSC402Lab3Theme {
        OrderPuzzleScreen()
    }
}