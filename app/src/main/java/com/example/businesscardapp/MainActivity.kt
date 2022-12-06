package com.example.businesscardapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 200.dp, bottom = 150.dp)
        ) {
            CenterDataCard(name = "Arifdjanov Sarvar", position = "Android Developer Extraordinaire", image = R.drawable.android_logo)
        }

        Column(modifier = Modifier.padding(top = 10.dp)) {
            Divider(color = Color.White, thickness = 1.dp)
            DataCard(message = "+998 (90) 960-12-00", icon = R.drawable.ic_call_foreground)
            Divider(color = Color.White, thickness = 1.dp)
            DataCard(message = "@OverLordN7", icon = R.drawable.ic_share_foreground)
            Divider(color = Color.White, thickness = 1.dp)
            DataCard(message = "arifdjanovsarvar@gmail.com", icon = R.drawable.ic_mail_foreground)
        }


    }
}

@Composable
fun DataCard(message: String, icon : Int){
    val image = painterResource(id = icon)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 40.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
        Text(
            text = message,
            color = Color.White,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(5.dp)
        )
    }

}

@Composable
fun CenterDataCard(name: String,position: String, image: Int){
    val img = painterResource(id = image)

    Box(modifier = Modifier
        .width(90.dp)
        .height(90.dp)
    ){
        Image(
            painter = img,
            contentDescription = null
        )
    }

    Text(
        text = name,
        fontSize = 32.sp,
        color = Color.White,
        modifier = Modifier
            .padding(5.dp)
    )
    Text(
        text = position,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3DDC84),
        modifier = Modifier.
        padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}