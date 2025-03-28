package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var imageId by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayArt(imageId)
        DisplayInfo(imageId)
        DisplayFooter(
            imageId = imageId,
            onAction = { action ->
                when (action) {
                    Action.Rewind -> {
                        if(imageId == 0)
                            imageId = 2;
                        else
                            imageId = (imageId - 1) % 3;
                    }
                    Action.Next -> {
                        imageId = (imageId + 1) % 3;
                    }
                }
            }
        )
    }
}

enum class Action {
    Rewind, Next
}

@Composable
fun DisplayArt(imageId: Int) {
    var image = painterResource(id = ImageData(imageId).imageId)
    Image(painter = image, contentDescription = "desc")
}

@Composable
fun DisplayFooter(
    imageId: Int,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment = Alignment.Center,
    horizontal: Arrangement.HorizontalOrVertical = Arrangement.Center
) {
    Row(
        modifier = modifier,
        verticalAlignment  = Alignment.CenterVertically
    ) {
        Button(
            onClick = { onAction(Action.Rewind) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Rewind")
        }
        Button(
            onClick = { onAction(Action.Next) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun DisplayInfo(imageId: Int,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement  = Arrangement.Center,
        horizontalAlignment  = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        var imageData = ImageData(imageId);
        Text(
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(id = imageData.titleId),
            modifier = modifier
                .padding(10.dp)
        )
        Text(
            text = stringResource(id = imageData.descriptionId) ,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}

class ImageDto(public var imageId: Int, public var descriptionId: Int, public var titleId: Int) {}

private fun ImageData(imageId : Int) : ImageDto {
    val images : List<ImageDto> = listOf(
        ImageDto(R.drawable.van_gogh, R.string.van_gogh_description, R.string.van_gogh_title),
        ImageDto(R.drawable.black_square, R.string.black_square_description, R.string.black_square_title),
        ImageDto(R.drawable.mona_lisa, R.string.mona_lisa_description, R.string.mona_lisa_title));

    return images[imageId];
}
