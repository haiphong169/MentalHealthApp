package com.haiphong.mentalhealthapp.ui.screens.admin

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.haiphong.mentalhealthapp.ui.util.viewmodel.adminHome.AdminHomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haiphong.mentalhealthapp.ui.widgets.RequestListItem


@Composable
fun AdminHomeScreen(
    viewModel: AdminHomeViewModel = viewModel(),
    toRequest: (String) -> Unit,
    signOut: () -> Unit
) {
    val requestList by viewModel.requestsList.collectAsState()

    LazyColumn {
        items(requestList) {
            RequestListItem(request = it, toRequest = toRequest)
        }
        item {
            Button(onClick = { signOut() }) {
                Text(text = "Sign Out")
            }
        }
    }
}