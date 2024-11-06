package com.example.exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable

fun Ujian(){
    var Origin by remember { mutableStateOf("") }
    var Depature by remember { mutableStateOf("") }
    var Arrival by remember { mutableStateOf("") }
    var MemilihTR by remember { mutableStateOf("") }

    var Originsv by remember { mutableStateOf("") }
    var Depaturesv by remember { mutableStateOf("") }
    var Arrivalsv by remember { mutableStateOf("") }
    var MemilihTRsv by remember { mutableStateOf("") }

    val listTR = listOf("Bus", "Ship", "Train", "Plane")
    Column (modifier = Modifier.fillMaxSize()) {
        HeaderSection()
        Text(text = "Plan Your Adventures",
            modifier = Modifier
                .padding(6.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)

        Text(text = "Let's plan an equisite adventure",
            modifier = Modifier
                .padding(start = 6.dp))

        Spacer(modifier = Modifier.size(50.dp))


        Column (modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = Origin,
                onValueChange = {Origin = it},
                label = {Text("Origin")},
                placeholder = {Text("Masukkan Origin")})

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = Depature,
                onValueChange = {Depature = it},
                label = {Text("Depature")},
                placeholder = {Text("Masukkan Depature")})

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = Arrival,
                onValueChange = {Arrival = it},
                label = {Text("Arrival")},
                placeholder = {Text("Masukkan Arrival")})

            Row {
                listTR.forEach { item ->
                    Row (verticalAlignment = Alignment.CenterVertically){
                        RadioButton(
                            selected = MemilihTR == item,
                            onClick = {
                                MemilihTR = item
                            }
                        )
                        Text(item)
                    }
                }
            }

            Text(text = "Choose Transportation")
            Button (onClick = {
                Origin = Originsv
                Depature = Depaturesv
                Arrival = Arrivalsv
                MemilihTR = MemilihTRsv
            }) {
                Text("Submit")
            }
            ElevatedCard (modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Blue)){

                DetailData(judul = "Origin", isinya = Originsv)
                DetailData(judul = "Depature", isinya = Depaturesv)

            }

            Spacer(Modifier.padding(15.dp))

            ElevatedCard (modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Blue)){

                DetailData(judul = "Arrival", isinya = Arrivalsv)
                DetailData(judul = "Transport", isinya = MemilihTR)

            }

        }
    }
}






@Composable
fun HeaderSection(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Blue)
        .padding(15.dp)
    ){
        Row(modifier  = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Icon(imageVector = Icons.Filled.Person,
                    contentDescription = null
                )

                Text(text = "Muhammad Adri",
                    color = Color.White
                )
                Icon(imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
                Text(
                    text = "Kabupaten Tanggerang",
                    color = Color.White
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.saya),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )

            }
        }
    }
}

@Composable
fun DetailData(judul: String, isinya:String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(text = judul, modifier = Modifier.weight(0.8f))
        Text(text = ":", modifier = Modifier.weight(0.2f))
        Text(text = isinya, modifier = Modifier.weight(2f))
    }
}


