package com.cds.callrecording

import android.telecom.Connection
import android.telecom.ConnectionRequest
import android.telecom.ConnectionService
import android.telecom.PhoneAccountHandle

class MyConnectionService: ConnectionService() {

    override fun onCreateOutgoingConnection(
        handle: PhoneAccountHandle,
        request: ConnectionRequest
    ): Connection {
        return MyConnection()
    }

    override fun onCreateIncomingConnection(
        handle: PhoneAccountHandle,
        request: ConnectionRequest
    ): Connection {
        return MyConnection()
    }
}