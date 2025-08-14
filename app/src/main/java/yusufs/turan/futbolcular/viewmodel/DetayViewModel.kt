package yusufs.turan.futbolcular.viewmodel

import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yusufs.turan.futbolcular.model.Futbolcu
import yusufs.turan.futbolcular.service.FutbolcuAPI

class DetayViewModel : ViewModel() {
    private val BASE_URL = "https://raw.githubusercontent.com"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FutbolcuAPI :: class.java)

    suspend fun tekFutbolcuAl(id: Int): Futbolcu {
        val futbolcu = retrofit.tekOyuncuyuCek()[id]
        return futbolcu
    }
}