@file:OptIn(ExperimentalAnimationApi::class)

package com.example.thirtydaysoffitness

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydaysoffitness.model.Excercise
import com.example.thirtydaysoffitness.model.ExcerciseRepository
import com.example.thirtydaysoffitness.ui.theme.ThirtyDaysOfFitnessTheme

@Composable
fun ExcerciseCardItem(
    excercise: Excercise,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .padding(8.dp)
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
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
            if (expanded) {
                Text(
                    text = stringResource(id = excercise.excerciseDescription),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyLarge
            )
            }
        }
    }
}

@Composable
fun ExcerciseList(
    excercises: List<Excercise>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    val visibleState = remember{
        MutableTransitionState(false).apply{
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn( contentPadding = contentPadding){
            itemsIndexed(excercises){ index, excercise ->
                ExcerciseCardItem(
                    excercise = excercise,
                    modifier = Modifier
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessVeryLow
                                ),
                                initialOffsetY ={ it * ( index+1 ) }
                            )
                        )
                )
            }
        }
    }
}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ExcerciseCardPreview(){
    val excercise1 = Excercise(
        R.string.day_1,
        R.string.excercise1,
        R.drawable.pushups,
        R.string.description1
    )
    ThirtyDaysOfFitnessTheme {
        Surface {
            ExcerciseCardItem(excercise = excercise1)
        }
    }
}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ExcercisePreview(){
    ThirtyDaysOfFitnessTheme {
        Surface {
            ExcerciseList(excercises = ExcerciseRepository.Excercises)
        }
    }
}