package com.example.androidretrofit.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.androidretrofit.domain.Info

@Composable
fun InfoItem(movie: Info) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp)
    ) {
        Surface() {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = movie.image,

                        builder = {
                            scale(Scale.FILL)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = movie.desc,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movie.category,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = movie.desc,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

}