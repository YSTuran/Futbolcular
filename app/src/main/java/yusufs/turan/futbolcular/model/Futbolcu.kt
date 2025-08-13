package yusufs.turan.futbolcular.model


data class Futbolcu(
    val id: Int,
    val futbolcuAdi: String,
    val tamAdi: String,
    val yas: Int,
    val pozisyon: String,
    val formaNumarasi: Int,
    val boy: Double,
    val kilo: Int,
    val ulke: String,
    val ayak: String,
    val takim: Team,
    val piyasaDegeri: String
)

data class Team(
    val takimAdi: String,
    val Lig: String
)

