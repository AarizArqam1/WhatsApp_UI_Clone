package com.techloyce.uipractice.ui.screens


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techloyce.uipractice.data.chatList
import com.techloyce.uipractice.domain.ChatListDataObject
import com.techloyce.uipractice.ui.components.USerDetails
import com.techloyce.uipractice.ui.components.UserImage

@Composable
fun ChatsScreen(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        item { 
            Spacer(modifier = Modifier.height(10.dp))
        }

        items(chatList){chatData->
            ListItem(chatData)
        }

    }

}

@Composable
fun ListItem(chatData:ChatListDataObject){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        UserImage(chatData.UserImage)
        USerDetails(chatData = chatData)

    }
}


@Preview(showBackground = true)
@Composable
fun ChatsScreenPreview(){
    ChatsScreen()
}