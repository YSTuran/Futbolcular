package yusufs.turan.futbolcular.service

import retrofit2.http.GET
import yusufs.turan.futbolcular.model.Futbolcu

interface FutbolcuAPI {
    //kaynak -> https://raw.githubusercontent.com/YSTuran/veri-setlerim/refs/heads/main/futbolcular.json

    @GET("YSTuran/veri-setlerim/refs/heads/main/futbolcular.json")
    suspend fun tumVeriyiCek() : List<Futbolcu>

    @GET("YSTuran/veri-setlerim/refs/heads/main/futbolcular.json")
    suspend fun tekOyuncuyuCek() : List<Futbolcu>
}