package com.mupper.almasanavidalibre.ui.app.navigation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mupper.almasanavidalibre.R
import com.mupper.almasanavidalibre.ui.theme.AlmaSanaVidaLibreTheme

@Composable
fun MainPage() {
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                Icon(Icons.Outlined.CheckCircle, contentDescription = "check circle")
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {

            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("TEMA DE LA SEMANA")
            Text("Retroceder para avanzar", style = TextStyle.Default.copy(fontSize = 36.sp))
            Row(
                modifier = Modifier.fillMaxWidth().clickable {  },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ic_calendar_month),
                    contentDescription = "calendar",
                    modifier = Modifier.padding(4.dp)
                )
                Text("21 MAR. 2022")
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clickable {  },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Cita diaria")
                        Spacer(modifier = Modifier.weight(1f))
                        Text("1 MIN")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clickable {  },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Devocional")
                        Spacer(modifier = Modifier.weight(1f))
                        Text("1 MIN")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clickable {  },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Una pregunta para meditar")
                        Spacer(modifier = Modifier.weight(1f))
                        Text("1 MIN")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clickable {  },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Oración")
                        Spacer(modifier = Modifier.weight(1f))
                        Text("1 MIN")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clickable {  },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Termina con un momento de silencio")
                        Spacer(modifier = Modifier.weight(1f))
                        Text("1 MIN")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun MainPagePreview() {
    AlmaSanaVidaLibreTheme {
        MainPage()
    }
}