package com.cds.callrecording

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.telecom.PhoneAccount
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager

class PhoneAccountReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val telecomManager =
            context.getSystemService(TelecomManager::class.java)

        val handle = PhoneAccountHandle(
            ComponentName(context, MyConnectionService::class.java),
            "MyDialer"
        )

        val account = PhoneAccount.builder(handle, "My Dialer")
            .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER)
            .build()

        telecomManager.registerPhoneAccount(account)
    }
}