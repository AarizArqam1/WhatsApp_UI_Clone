package com.techloyce.uipractice.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun UserImage(userImage: Int) {

    Icon(
        modifier= Modifier.size(60.dp),
        painter = painterResource(id = userImage), contentDescription = "")
}