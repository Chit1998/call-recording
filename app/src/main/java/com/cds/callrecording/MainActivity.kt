package com.cds.callrecording

import android.content.Intent
import android.os.Bundle
import android.telecom.TelecomManager
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        setContentView(TextView(this).apply {
//            text = "Dialer Recorder"
//            gravity = Gravity.CENTER
//            textSize = 22f
//        })
//        startActivity(
//            Intent("android.settings.MANAGE_DEFAULT_APPS_SETTINGS")
//        )
//
//        requestDefaultDialer()
        val textView = TextView(this)
        textView.text = "Dialer Recorder"
        textView.gravity = Gravity.CENTER
        textView.textSize = 22f
        setContentView(textView)

//        checkDefaultDialer()
        requestDefaultDialerIfNeeded()
    }

    private fun requestDefaultDialerIfNeeded() {

        val telecomManager =
            getSystemService(TelecomManager::class.java)

        if (telecomManager.defaultDialerPackage != packageName) {

            val intent =
                Intent(TelecomManager.ACTION_CHANGE_DEFAULT_DIALER)

            intent.putExtra(
                TelecomManager.EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME,
                packageName
            )

            startActivity(intent)

        } else {

            Toast.makeText(
                this,
                "Already Default Dialer",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun checkDefaultDialer() {

        val telecomManager =
            getSystemService(TelecomManager::class.java)

        if (telecomManager.defaultDialerPackage != packageName) {

            val intent =
                Intent(TelecomManager.ACTION_CHANGE_DEFAULT_DIALER)

            intent.putExtra(
                TelecomManager.EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME,
                packageName
            )

            startActivity(intent)

        } else {

            Toast.makeText(
                this,
                "App is already Default Dialer",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun requestDefaultDialer() {
        val intent = Intent(TelecomManager.ACTION_CHANGE_DEFAULT_DIALER)
        intent.putExtra(
            TelecomManager.EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME,
            packageName
        )
        startActivity(intent)
    }

}