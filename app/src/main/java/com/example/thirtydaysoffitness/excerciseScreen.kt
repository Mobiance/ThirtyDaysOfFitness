package com.example.thirtydaysoffitness

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydaysoffitness.model.excercise
import com.example.thirtydaysoffitness.model.excerciseRepository
import com.example.thirtydaysoffitness.ui.theme.ThirtyDaysOfFitnessTheme

@Composable
fun excerciseCardItem(
    excercise: excercise,
    modifier: Modifier = Modifier
        .padding(8.dp)
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(id = excercise.dayNumber)
            )
            Text(
                text = stringResource(id = excercise.title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .padding(4.dp)
            )
            Image(
                painter = painterResource(id = excercise.excerciseImage),
                contentDescription =null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(id = excercise.excerciseDescription),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun excerciseList(
    excercises: List<excercise>,
    modifier: Modifier = Modifier
){
    LazyColumn(){
        itemsIndexed(excercises){index, excercise ->
            excerciseCardItem(
                excercise = excercise
            )

        }
    }

}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun excerciseCardPreview(){
    val excercise1 = excercise(
        R.string.day_1,
        R.string.excercise1,
        R.drawable.pushups,
        R.string.description1
    )
    ThirtyDaysOfFitnessTheme {
        Surface {
            excerciseCardItem(excercise = excercise1)
        }
    }
}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun excercisePreview(){
    ThirtyDaysOfFitnessTheme {
        Surface {
            excerciseList(excercises = excerciseRepository.excercises)
        }
    }
}