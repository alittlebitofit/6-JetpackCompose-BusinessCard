package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Greeting(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(color = Color.White)
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        LogoColumn(Modifier.weight(1f))
        ContactColumn(Modifier.weight(1f))
    }
}


@Composable
fun LogoColumn(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
        )
        Text(
            text = "Full Name",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp),
        )
        Text(
            text = "Title",
            color = Color.Black,
            fontSize = 24.sp,
        )
    }
}


@Composable
fun ContactColumn(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        ContactDetail(Icons.Filled.Call, "+0123456789")
        ContactDetail(Icons.Filled.Search, "@followMe")
        ContactDetail(Icons.Filled.Email, "email@gmail.com")
    }
}


@Composable
private fun ContactDetail(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = modifier.weight(1f),
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = Color.Black
            )
        }

        Text(
            text = text,
            modifier = modifier
                .weight(2f)
                .padding(start = 24.dp),
            color = Color.Black,
            fontSize = 24.sp,
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting()
    }
}