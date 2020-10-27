package com.malibin.hearthstone.db.presentation.dialog

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.malibin.hearthstone.db.R
import com.malibin.hearthstone.db.databinding.DialogSimpleBinding

/**
 * Created By Malibin
 * on 10월 28, 2020
 */

abstract class SimpleDialog(context: Context) : AlertDialog(context), SimpleDialogClickListener {
    abstract val contentRes: Int
    abstract val okButtonTextRes: Int
    abstract val cancelButtonTextRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DialogSimpleBinding.inflate(layoutInflater).apply {
            clickListener = this@SimpleDialog
            content.text = contentRes.toText()
            btnOk.text = okButtonTextRes.toText()
            btnCancel.text = cancelButtonTextRes.toText()
        }
        setContentView(binding.root)
        setTransparentWindowBackground()
    }

    private fun setTransparentWindowBackground() {
        window?.setBackgroundDrawableResource(R.color.transparent)
    }

    private fun Int.toText(): String = context.resources.getString(this)
}
