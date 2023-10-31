package com.haiphong.mentalhealthapp.ui.util

data class Request(
    val requestId: String = "",
    val specialist: Specialist = Specialist(),
    val email: String = "",
    val password: String = "",
    val type: String = RequestType.CreateAccount.name
) {

}

enum class RequestType {
    CreateAccount, Update
}