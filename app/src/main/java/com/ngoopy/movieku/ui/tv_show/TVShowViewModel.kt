package com.ngoopy.movieku.ui.tv_show

import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.TVShowEntity
import com.ngoopy.movieku.utils.DataDummy

class TVShowViewModel : ViewModel() {
    fun getTVShow(): List<TVShowEntity> = DataDummy.generateDummyTVShow()
}