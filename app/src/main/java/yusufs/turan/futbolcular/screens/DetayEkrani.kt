package yusufs.turan.futbolcular.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yusufs.turan.futbolcular.model.Futbolcu
import yusufs.turan.futbolcular.model.Team

@Composable
fun DetayEkrani(futbolcu: Futbolcu) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f) // tam adı ve pozisyon için alanı paylaştır
                ) {
                    Text(
                        text = futbolcu.tamAdi,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF222222),
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )
                    Text(
                        text = futbolcu.pozisyon,
                        fontSize = 15.sp,
                        color = Color.Gray,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(8.dp)) // Araya boşluk ekleyelim

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Blue, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = futbolcu.formaNumarasi.toString(),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Yaş: ${futbolcu.yas} | Boy: ${futbolcu.boy} m | Kilo: ${futbolcu.kilo} kg",
                fontSize = 14.sp
            )
            Text(
                text = "Ülke: ${futbolcu.ulke} | Ayak: ${futbolcu.ayak}",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = futbolcu.takim.takimAdi,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )
                    Text(
                        text = futbolcu.takim.Lig,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Piyasa Değeri: ${futbolcu.piyasaDegeri}",
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
    }
}


/*@Preview(showBackground = true)
@Composable
fun DetayPreview() {
    val exampleFutbolcu = Futbolcu(
        id = 1,
        futbolcuAdi = "Arda Güler",
        tamAdi = "Arda Güler",
        yas = 19,
        pozisyon = "Orta Saha",
        formaNumarasi = 15,
        boy = 1.76,
        kilo = 70,
        ulke = "Türkiye",
        ayak = "Sağ",
        takim = Team("Real Madrid", "La Liga"),
        piyasaDegeri = "€30M"
    )
    MaterialTheme {
        DetayEkrani(futbolcu = exampleFutbolcu)
    }
}*/