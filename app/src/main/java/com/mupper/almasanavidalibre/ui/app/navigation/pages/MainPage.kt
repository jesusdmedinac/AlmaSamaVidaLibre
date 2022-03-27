package com.mupper.almasanavidalibre.ui.app.navigation.pages

import android.text.format.DateFormat
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mupper.almasanavidalibre.R
import com.mupper.almasanavidalibre.ui.theme.AlmaSanaVidaLibreTheme
import java.util.*

@Composable
fun MainPage() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("TEMA DE LA SEMANA")
            Text("Retroceder para avanzar", style = TextStyle.Default.copy(fontSize = 36.sp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ic_calendar_month),
                    contentDescription = "calendar",
                    modifier = Modifier.padding(4.dp)
                )
                Text(DateFormat.format("d MMM, yyyy", Date()).toString())
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /*TODO*/ }) {
                    Text("CALENDARIO")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("L", "M", "M", "J", "V", "S", "D").forEach {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(it)
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ic_menu_book),
                    contentDescription = "Devocional",
                    modifier = Modifier.padding(4.dp)
                )
                Text("DEVOCIONAL DE HOY")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    DailyStep(
                        label = "Cita diaria",
                        time = "1 MIN"
                    )
                    DailyStep(
                        label = "Devocional",
                        time = "1 MIN"
                    )
                    DailyStep(
                        label = "Una pregunta para meditar",
                        time = "1 MIN"
                    )
                    DailyStep(
                        label = "Oración",
                        time = "1 MIN"
                    )
                    DailyStep(
                        label = "Termina con un momento de silencio",
                        time = "1 MIN"
                    )
                }
            }
        }
    }
}

@Composable
private fun DailyStep(
    label: String,
    time: String,
) {
    var dailyAppointmentOpened by remember { mutableStateOf(false) }

    val transition =
        updateTransition(targetState = dailyAppointmentOpened, label = "Card transition")

    val colorTransitionSpec: @Composable() (Transition.Segment<Boolean>.() -> FiniteAnimationSpec<Color>) =
        {
            if (targetState) spring(dampingRatio = 3f)
            else spring(dampingRatio = 2f)
        }
    val textColor by transition.animateColor(
        label = "Card text color",
        transitionSpec = colorTransitionSpec
    ) { state ->
        if (state) MaterialTheme.colors.background
        else MaterialTheme.colors.onBackground
    }
    val backgroundColor by transition.animateColor(
        label = "Card background color",
        transitionSpec = colorTransitionSpec
    ) { state ->
        if (state) MaterialTheme.colors.onBackground
        else MaterialTheme.colors.background
    }
    val height by transition.animateDp(label = "Card height") { state ->
        if (state) 128.dp
        else 56.dp
    }
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clickable {
                dailyAppointmentOpened = !dailyAppointmentOpened
            },
        backgroundColor = backgroundColor,
        contentColor = textColor
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(label)
                Spacer(modifier = Modifier.weight(1f))
                Text(time)
            }

            AnimatedVisibility(visible = dailyAppointmentOpened) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(modifier = Modifier.weight(1f), onClick = { /*TODO*/ }) {
                        Text("Escuchar")
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    Button(modifier = Modifier.weight(1f), onClick = { /*TODO*/ }) {
                        Text("Leer")
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun animateHorizontalAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment.Horizontal> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment.Horizontal(bias) }
}

@Composable
private fun animateVerticalAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment.Vertical> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment.Vertical(bias) }
}

@Composable
@Preview
fun MainPagePreview() {
    AlmaSanaVidaLibreTheme {
        MainPage()
    }
}