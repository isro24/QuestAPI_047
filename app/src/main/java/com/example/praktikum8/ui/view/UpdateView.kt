package com.example.praktikum8.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktikum8.ui.customwidget.CustomeTopAppBar
import com.example.praktikum8.ui.navigation.DestinasiNavigasi
import com.example.praktikum8.ui.viewmodel.PenyediaViewModel
import com.example.praktikum8.ui.viewmodel.UpdateViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object DestinasiUpdate : DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Edit Mahasiswa"
    const val NIM = "nim"
    val routeWithArgs = "$route/{$NIM}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateView(
    NavigateBack: () -> Unit,
    onNavigate:()-> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        modifier = modifier,
        topBar = {
            CustomeTopAppBar(
                title = DestinasiUpdate.titleRes,
                canNavigateBack = true,
                navigateUp = NavigateBack,
            )
        }
    ){ padding ->
        EntryBody(
            modifier = Modifier.padding(padding),
            onSiswaValueChange = viewModel::updateInsertMhsState,
            insertUiState = viewModel.updateUIState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateData()
                    delay(600)
                    withContext(Dispatchers.Main){
                        onNavigate()
                    }
                }
            }
        )
    }
}