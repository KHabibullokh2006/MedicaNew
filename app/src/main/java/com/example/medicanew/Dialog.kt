package com.example.medicanew

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class Dialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Logout")
                .setMessage("Are you sure you want to log out?")
                .setCancelable(true)
                .setPositiveButton("Yes, Logout") { _, _ ->

                }
                .setNegativeButton(
                    "Cancel"
                ) { _, _ ->

                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}