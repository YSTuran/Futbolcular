package yusufs.turan.futbolcular.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import yusufs.turan.futbolcular.model.Futbolcu
import yusufs.turan.futbolcular.service.FutbolcuAPI

class FutbolcuViewModel : ViewModel() {
    //kaynak -> https://raw.githubusercontent.com/YSTuran/veri-setlerim/refs/heads/main/futbolcular.json
    private val BASE_URL = "https://raw.githubusercontent.com"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FutbolcuAPI::class.java)

    val futbolcuList = mutableStateOf<List<Futbolcu>>(listOf())

    fun getFutbolcu(){
        viewModelScope.launch {
            futbolcuList.value = retrofit.tumVeriyiCek()
        }
    }
}