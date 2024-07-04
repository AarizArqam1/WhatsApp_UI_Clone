package com.techloyce.uipractice.ui.screens

import android.provider.CallLog.Calls
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techloyce.uipractice.data.INITIAL_PAGER_STATE
import com.techloyce.uipractice.data.tabs
import com.techloyce.uipractice.ui.components.AppbarComponent
import com.techloyce.uipractice.ui.components.TabBarComponent
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){

    val pagerState= rememberPagerState(
        initialPage = INITIAL_PAGER_STATE
    ) {
        // provide pageCount
        tabs.size
    }
    val scope= rememberCoroutineScope()

    Column {
        AppbarComponent()
        TabBarComponent(
            pagerState=pagerState,
            initialIndex = INITIAL_PAGER_STATE,
            onTabSelected = {selectedPage->
                scope.launch {
                    pagerState.animateScrollToPage(selectedPage)
                }
            }
        )
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState) {page ->
            when(page){
                0-> ChatsScreen()
                1-> StatusScreen()
                2-> CallsScreen()
            }
            
        }
    }

}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}


