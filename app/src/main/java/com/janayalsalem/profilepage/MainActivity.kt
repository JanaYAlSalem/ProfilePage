package com.janayalsalem.profilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janayalsalem.profilepage.ui.theme.ProfilePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CardPage()
                }
            }
        }
    }
}
@Preview
@Composable
fun CardPage() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp) {

            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                ProfileImage()


            }

        }

    }

}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {

    Surface(modifier = modifier
        .size(250.dp)
        .padding(23.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)) {

        Image(painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)

    }

}
