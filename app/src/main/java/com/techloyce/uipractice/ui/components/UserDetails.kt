package com.techloyce.uipractice.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techloyce.uipractice.domain.ChatListDataObject
import com.techloyce.uipractice.ui.theme.HighLightGreen

@Composable
fun USerDetails(chatData: ChatListDataObject){

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        MessageHeader(chatData)
        MessageSubSection(chatData)

    }
}


@Composable
fun MessageHeader(chatData: ChatListDataObject) {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        TextComponent(value = chatData.UserName,
            fontSize=18.sp,
            color= Color.Black,
            modifier = Modifier.weight(1F),
            fontweight=FontWeight.SemiBold)



        TextComponent(
            value = chatData.message.timeStamp,
            fontSize=12.sp,
            color=if((chatData.message.unreadCount?:0)>0) HighLightGreen else Color.Gray,
            null
        )

    }
}
@Composable
fun MessageSubSection(chatData: ChatListDataObject) {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        TextComponent(
            value = chatData.message.content,
            fontSize=12.sp,
            color=Color.Gray,
            null
        )

        Spacer(modifier = Modifier.weight(1F))

        chatData.message.unreadCount?.also {
            CircularCountComponent(
                unreadCount = it.toString(),
                backgroundColor= HighLightGreen

            )
        }


    }
}