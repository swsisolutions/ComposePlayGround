package com.swasi.ui.componentexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonList()
        }
    }

    @Composable
    fun ButtonList() {
//        val context = LocalContext.current
        Column(
            Modifier
                .padding(5.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//            ApButton("Hello",
//                buttonColor = Color.Magenta,
//                onClick = {
//                Toast.makeText(context, "External Button Clicked", Toast.LENGTH_SHORT).show()
//            })
            showSimpleButton()
            ButtonExample()
            ButtonExample1()
            OutlinedButtonExample()
            TextButtonExample()
            MainContent()
        }
    }

    @Composable
    fun showSimpleButton() {
        Button(
            onClick = {},
            modifier = Modifier.padding(8.dp),
//            elevation = ButtonConstants.defaultElevation(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Simple Button")
        }
    }

    @Composable
    fun ButtonExample() {
        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text("Button")
        }
    }

    @Composable
    fun ButtonExample1() {
        Button(
            onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Red
            )
        ) {
            Text("Button")
        }
    }

    @Composable
    fun OutlinedButtonExample() {
        OutlinedButton(onClick = { /* Do something! */ }) {
            Text("I'm an Outlined Button")
        }
    }

    @Composable
    fun TextButtonExample() {
        TextButton(onClick = { /* Do something! */ }) {
            Text("I'm a Text Button")
        }
    }

    @Composable
    fun MainContent() {
        val context = LocalContext.current
        Column(
            Modifier
                .background(Color(0xFFFFFFFF))
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                onClick = {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(8.dp)/*,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 6.dp,
                    pressedElevation = 8.dp,
                    disabledElevation = 0.dp
                )*/
            ) {
                Text(
                    text = "Elevation 6 DP",
                    modifier = Modifier.padding(12.dp)
                )
            }

            Button(
                onClick = {
                    Toast.makeText(context, "Disable Clicked", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(8.dp)/*,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 6.dp,
                    pressedElevation = 8.dp,
                    disabledElevation = 0.dp
                )*/,
                enabled = false
            ) {
                Text(
                    text = "Disabled Elevation 0 DP",
                    modifier = Modifier.padding(12.dp)
                )
            }

            TextButton(
                onClick = {
                    Toast.makeText(context, "Elevation 1 DP Clicked", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(8.dp)/*,
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                )*/,
                enabled = true
            ) {
                Text(
                    text = "Elevation 1 DP",
                    modifier = Modifier.padding(12.dp)
                )
            }

            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Elevation 8 DP Clicked", Toast.LENGTH_SHORT).show()
                },
                shape = CircleShape/*,
                elevation = ButtonDefaults.ButtonDefaults.buttonElevation()*/

            ) {
                Text(
                    text = "Elevation 8 DP",
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }

    @Composable
    fun showSimpleButtonWithImage() {
        Button(
            onClick = {},
            modifier = Modifier.padding(8.dp),
//            elevation = ButtonConstants.defaultElevation(),
            shape = RoundedCornerShape(15.dp),
        ) {
            Row {
                Icon(Icons.Filled.Menu, "menu")
//                Icon(asset = painterResource(R.drawable.my_photograph), modifier = Modifier.padding(end = 4.dp))
                Text(text = "Simple Button")
            }
        }
    }

    @Preview
    @Composable
    fun ButtonPreview() {
        ButtonList()
    }
}