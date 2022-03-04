package com.example.intentfilterimprovements

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.send_action).setOnClickListener {
            val component = ComponentName(
                "com.example.accessibilitytalkmobileweek", // package name of target application
                "com.example.accessibilitytalkmobileweek.IntentFilterActivity" // full path name of the Activity to start
            )

            try {
                Intent( // ACTION_SEND_MULTIPLE
                ).apply {
                    // setAction(ACTION_SEND_MULTIPLE)
//                    setAction(ACTION_SEND)
                    setComponent(component)
                    // addCategory(CATEGORY_DEFAULT)
                }.also {
                    startActivity(it)
                }
            } catch (e: Exception) {
                MaterialAlertDialogBuilder(this).setPositiveButton(
                    "ok"
                ) { dialog, _ ->
                    dialog.dismiss()
                }.setMessage("Error: ${e.localizedMessage}").show()
            }
            /*     val intent = Intent().apply {
                     action = ACTION_SEND
                     // putExtra("data", "From Intent")
                 }
                 startActivity(intent)*/
        }
    }
}
