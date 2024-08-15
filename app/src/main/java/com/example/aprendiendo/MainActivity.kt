package com.example.aprendiendo

import android.content.res.Configuration
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.service.quicksettings.Tile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.StabilityInferred
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprendiendo.ui.theme.AprendiendoTheme

private val messeges: List<MyMesseges> = listOf(
    MyMesseges("Hola mundo1 ", "soy una lista"),
    MyMesseges("Hola mundo2 ", "soy una lista"),
    MyMesseges("Hola mundo3 ", "soy una lista"),
    MyMesseges("Hola mundo4 ", "soy una lista"),
    MyMesseges("Hola mundo5 ", "soy una lista"),
    MyMesseges("Hola mundo6 ", "soy una lista"),
    MyMesseges("Hola mundo7 ", "soy una lista"),
    MyMesseges("Hola mundo8 ", "soy una lista"),
    MyMesseges("Hola mundo9", "soy una lista"),
    MyMesseges("Hola mundo10 ", "soy una lista"),
    MyMesseges("Hola mundo11 ", "soy una lista"),
    MyMesseges("Hola mundo12 ", "soy una lista"))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AprendiendoTheme {
                Mymessege(messeges)
            }
        }
    }
}
@Composable
fun MyText(text: String, color: Color , style: TextStyle){
    Text(text, color = color, style = style)
}

@Composable
fun MyTexts(messeges: MyMesseges){
    Column (modifier = Modifier.padding(8.dp)) {
        MyText(messeges.tile,MaterialTheme.colorScheme.secondary, MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(4.dp))
        MyText(messeges.body, MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.titleMedium)
    }

}

@Composable
fun MiImagen(){
    Image(painterResource(id = R.drawable.ic_launcher_foreground) ,
        contentDescription = "Mi imagen de prueba", modifier = Modifier
            .clip(CircleShape)  // dale la forma a la imagen.
            .background(MaterialTheme.colorScheme.primary) // darle el color de fondo a la imagen (recordar el orden
            //primero size y luego color para que se ajuste.
            .size(63.dp) // tamaño de la imagen.
    )
}


@Composable
fun Myfunction(messeges: MyMesseges){

    Row (modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(10.dp)){
        //aqui tambien importa el orden en que se ponga primero el padding o el backround color.
        MiImagen()
        MyTexts(messeges)
    }

}

data class  MyMesseges(val tile: String, val body: String)

@Composable
fun Mymessege(messeges: List<MyMesseges>){
    LazyColumn {
        items(messeges){
            messeges -> Myfunction(messeges)
        }
    }
}



@Preview(showSystemUi = true)
@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewText(){
    AprendiendoTheme {
        val scrollState = rememberScrollState()
        Column (modifier = Modifier.verticalScroll(scrollState)) {
            Mymessege(messeges)

        }

    }
}

