package uk.co.spltech.secume.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun androidx.fragment.app.Fragment.createLayoutManager(
    orientation: Int = RecyclerView.VERTICAL
    , reverseLayout: Boolean = false
): RecyclerView.LayoutManager = LinearLayoutManager(context, orientation, reverseLayout)
