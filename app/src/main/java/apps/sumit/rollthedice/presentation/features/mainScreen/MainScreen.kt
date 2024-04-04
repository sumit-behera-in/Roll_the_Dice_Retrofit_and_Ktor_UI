package apps.sumit.rollthedice.presentation.features.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import apps.sumit.rollthedice.presentation.features.mainScreen.viewmodel.MainScreenViewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.7f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(modifier = Modifier.fillMaxSize(0.6f)) {
                if (state.isLoading) {
                    CircularProgressIndicator(modifier.fillMaxSize())
                } else {
                    state.dice?.let {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it.imageUrl)
                                .decoderFactory(SvgDecoder.Factory())
                                .build(),
                            contentDescription = it.name,
                        )
                    }
                }
            }
            state.dice?.let { Text(text = it.name) }
            state.dice?.let { Text(text = it.description) }
        }

        Button(onClick = { viewModel.getDice() }) {
            Text(text = "Refresh")
        }

    }

}