package com.techloyce.uipractice.data

data class TabData(
    val title : String,
    val unreadCount:Int?
)


val tabs=listOf<TabData>(
    TabData(Tabs.CHATS.value,null),
    TabData(Tabs.STATUS.value,null),
    TabData(Tabs.CALLS.value,null)

)

enum class Tabs(val value:String){
    CHATS("Chats"),
    STATUS("Status"),
    CALLS("Calls")
}

const val INITIAL_PAGER_STATE=0