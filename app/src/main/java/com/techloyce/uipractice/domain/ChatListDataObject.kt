package com.techloyce.uipractice.domain

import com.techloyce.uipractice.R

data class ChatListDataObject(
    val chatId : Int,
    val message:Message,
    val UserName : String,
    val UserImage: Int= R.drawable.ic_user
)
data class Message(
    val content:String,
    val status: MessageDeliveryStatus,
    val type: MessageType,
    val timeStamp : String,
    val unreadCount : Int?=null
)
enum class MessageDeliveryStatus{
    DELIVERED,
    READ,
    PENDING,
    ERROR
}

enum class MessageType{
    TEXT,
    AUDIO,
    IMAGE,
}