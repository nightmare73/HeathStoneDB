package com.malibin.hearthstone.db.presentation.initial

import android.content.Context
import com.malibin.hearthstone.db.presentation.dialog.SimpleDialog
import com.malibin.hearthstone.db.R

/**
 * Created By Malibin
 * on 10월 29, 2020
 */

class InitialWarningDialog(context: Context) : SimpleDialog(context) {
    override val contentRes: Int = R.string.initial_data_warning
    override val okButtonTextRes: Int = R.string.initial_download
    override val cancelButtonTextRes: Int = R.string.cancel
}
