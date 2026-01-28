package com.cds.callrecording

import android.telecom.Connection
import android.telecom.DisconnectCause

class MyConnection: Connection() {
    override fun onAnswer() {
        setActive()
        CallRecorder.start()
    }

    override fun onDisconnect() {
        CallRecorder.stop()
        setDisconnected(DisconnectCause(DisconnectCause.LOCAL))
        destroy()
    }
}