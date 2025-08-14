package yusufs.turan.futbolcular

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import yusufs.turan.futbolcular.model.Futbolcu
import yusufs.turan.futbolcular.model.Team
import yusufs.turan.futbolcular.screens.DetayEkrani
import yusufs.turan.futbolcular.screens.FutbolcuList
import yusufs.turan.futbolcular.ui.theme.FutbolcularTheme
import yusufs.turan.futbolcular.viewmodel.DetayViewModel
import yusufs.turan.futbolcular.viewmodel.FutbolcuViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: FutbolcuViewModel by viewModels<FutbolcuViewModel>()
    private val detayViewModel: DetayViewModel by viewModels<DetayViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            FutbolcularTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "futbolcu_list") {

                            composable("futbolcu_list") {
                                viewModel.getFutbolcu()
                                FutbolcuList(
                                    futbolList = viewModel.futbolcuList.value,
                                    navController = navController
                                )
                            }

                            composable(
                                "detay_ekrani/{secilenFutbolcu}",
                                arguments = listOf(
                                    navArgument("secilenFutbolcu") {
                                        type =
                                            NavType.StringType
                                    }
                                )
                            ) { backStackEntry ->

                                val kullaniciIndex = backStackEntry.arguments
                                    ?.getString("secilenFutbolcu")?.toInt() ?: 0

                                val secilenFutbolcu = remember {
                                    mutableStateOf(
                                        Futbolcu(
                                            id = 1,
                                            futbolcuAdi = "",
                                            tamAdi = "",
                                            yas = 0,
                                            pozisyon = "",
                                            formaNumarasi = 0,
                                            boy = 0.0,
                                            kilo = 0,
                                            ulke = "",
                                            ayak = "",
                                            takim = Team("", ""),
                                            piyasaDegeri = ""
                                        )
                                    )
                                }

                                LaunchedEffect(kullaniciIndex) {
                                    secilenFutbolcu.value =
                                        detayViewModel.tekFutbolcuAl(kullaniciIndex)
                                }

                                DetayEkrani(futbolcu = secilenFutbolcu.value)
                            }
                        }

                    }
                }
            }
        }
    }
}

