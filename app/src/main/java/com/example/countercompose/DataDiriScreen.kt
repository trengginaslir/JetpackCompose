package com.example.countercompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.countercompose.ui.theme.CounterComposeTheme

@Composable
fun DataDiriScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DataDiriViewModel = viewModel()
) {
    DataDiriContent(
        nama = viewModel.nama,
        umur = viewModel.umur,
        onNamaChange = viewModel::onNamaChange,
        onUmurChange = viewModel::onUmurChange,
        onBack = onBack,
        modifier = modifier
    )
}

@Composable
fun DataDiriContent(
    nama: String,
    umur: String,
    onNamaChange: (String) -> Unit,
    onUmurChange: (String) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Data Diri",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = onNamaChange,
            label = { Text("Nama") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = umur,
            onValueChange = onUmurChange,
            label = { Text("Umur") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        if (nama.isNotBlank() || umur.isNotBlank()) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Nama saya \"$nama\" dan umur saya \"$umur\", Salam kenal!",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("KEMBALI")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DataDiriScreenPreview() {
    CounterComposeTheme {
        DataDiriContent(
            nama = "",
            umur = "",
            onNamaChange = {},
            onUmurChange = {},
            onBack = {}
        )
    }
}
