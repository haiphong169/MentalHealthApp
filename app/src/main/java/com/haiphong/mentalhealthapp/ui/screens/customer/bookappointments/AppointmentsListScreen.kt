package com.haiphong.mentalhealthapp.ui.screens.customer.bookappointments

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haiphong.mentalhealthapp.ui.util.viewmodel.bookAppointment.AppointmentsListViewModel
import com.haiphong.mentalhealthapp.ui.widgets.AppointmentListItem

@Composable
fun AppointmentsListScreen(
    appointmentsListViewModel: AppointmentsListViewModel = viewModel(),
    toAppointment: (String) -> Unit
) {
    val appointmentsList by appointmentsListViewModel.appointmentList.collectAsState()

    LazyColumn {
        items(appointmentsList) {
            AppointmentListItem(appointment = it, toAppointment = toAppointment)
        }
    }
}