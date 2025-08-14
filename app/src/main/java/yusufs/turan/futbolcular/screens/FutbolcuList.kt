package yusufs.turan.futbolcular.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yusufs.turan.futbolcular.model.Futbolcu
import yusufs.turan.futbolcular.model.Team
import yusufs.turan.futbolcular.ui.theme.FutbolcularTheme

@Composable
fun FutbolcuList(futbolList: List<Futbolcu>){
    LazyColumn (modifier = Modifier.fillMaxSize()
        .background(color = MaterialTheme.colorScheme.tertiaryContainer)
        .padding(2.dp)){
        items(futbolList){
          futbolcuRow(it)
        }
    }
}


@Composable
fun futbolcuRow(futbolcu: Futbolcu){
    Column (modifier = Modifier.fillMaxSize().background(color = MaterialTheme
        .colorScheme.primaryContainer)
        .border(BorderStroke(2.dp, Color.DarkGray))
        .padding(10.dp)){
        Text(futbolcu.futbolcuAdi+" ("+futbolcu.yas+")",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center)
    }
}

/*@Preview
@Composable
fun listPreview(){
    FutbolcularTheme {
        futbolcuRow(futbolcu = Futbolcu(1,"Y.Turan",
            "Yusuf Samet Turan", 20 ,"kaleci",
            16, 1.70, 75, "türkiye","sağ",
            Team("galatasaray","süper lig"), "500k"))
    }
}*/