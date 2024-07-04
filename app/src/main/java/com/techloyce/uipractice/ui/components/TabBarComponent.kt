package com.techloyce.uipractice.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techloyce.uipractice.data.TabData
import com.techloyce.uipractice.data.tabs
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabBarComponent(
    initialIndex:Int=0,
    pagerState: PagerState,
    onTabSelected :(Int)->Unit
                    ){
    var selectedIndex by rememberSaveable{
        mutableIntStateOf(initialIndex)
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page->
            selectedIndex=page
            onTabSelected(selectedIndex)
        }
    }

    TabRow(selectedTabIndex = selectedIndex,
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.tertiary,
        indicator = {tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                color = MaterialTheme.colorScheme.tertiary,
                height = 4.dp
            )

        }
        ) {

        tabs.forEachIndexed { index, tabData ->
            Tab(selected = index == selectedIndex, onClick = {
                selectedIndex=index
                onTabSelected(selectedIndex)
            },
                text = {
                    TabContent(tabData)
                }
            )
        }

    }
}

@Composable
private fun TabContent(tabData: TabData) {
    if (tabData.unreadCount == null) {
        TabTitle(tabData)
    } else {
        TabTitleWithCount(tabData = tabData)
    }
}

@Composable
private fun TabTitle(tabData: TabData) {
    Text(
        text = tabData.title,
        style = TextStyle(
            fontSize = 16.sp
        )

    )
}

@Composable
fun TabTitleWithCount(tabData: TabData){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TabTitle(tabData = tabData)
        tabData?.unreadCount?.also { unreadCount->
            CircularCountComponent(unreadCount.toString(), MaterialTheme.colorScheme.background)
        }

//        if(tabData!=null && tabData.unreadCount!=null){
//            CircularCountComponent(tabData.unreadCount.toString(), MaterialTheme.colorScheme.background)
//        }

    }

}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun TabBarComponentPreview(){
    //TabBarComponent()
}