package com.janayalsalem.profilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    val buttonClickedState = remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp
        ) {

            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                ProfileInfo()
                ShowButton(buttonClickedState)


            }

        }

    }

}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier
            .size(250.dp)
            .padding(23.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }

}

@Composable
fun ProfileInfo() {

    // full name
    Text(
        text = "Jana AlSalem",
        style = MaterialTheme.typography.h4,
        color = MaterialTheme.colors.primaryVariant,
        textAlign = TextAlign.Center
    )



    Column(modifier = Modifier.padding(5.dp)) {
        // line to divide
        Divider()

        // bio
        Text(
            text = "Android Developer",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.subtitle1
        )

        // location
        Text(
            text = "Riyadh,SA",
            modifier = Modifier.padding(3.dp),
        )


    }
}


@Composable
fun ShowButton( buttonClickedState: MutableState<Boolean>) {

    Button(onClick = { buttonClickedState.value = !buttonClickedState.value }) {
        if(buttonClickedState.value)
        Text("Hide All Project", style = MaterialTheme.typography.button)
    else
        Text("Show All Project", style = MaterialTheme.typography.button)
    }
    if (buttonClickedState.value) {
        ShowData()
    }else {
        Box {}
    }
}

@Composable
fun ShowData() {

    val topicOfProject = listOf("Project 1", "Project 2", "Project 3", "Project 3", "Project 3")

    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)) {
            Content(data = topicOfProject)

        }

    }

}

@Composable
fun Content(data: List<String>) {
    LazyColumn{
        items(data) { item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp) {

               // all projects show as rows
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)) {

                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great Project", style = MaterialTheme.typography.body2)
                    }

                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(text = "                           ", fontWeight = FontWeight.Bold)
                        Text(text = "                            ", style = MaterialTheme.typography.body2)
                    }


                        Button(onClick = { /*TODO*/ }, modifier = Modifier
                            .width(80.dp)
                            .height(50.dp)) {
                            Text("More Details", style = MaterialTheme.typography.button)
                        }


                }

            }

        }
    }

}