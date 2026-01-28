package com.cds.callrecording

import android.media.MediaRecorder
import android.os.Environment
import java.io.File

object CallRecorder {
    private var recorder: MediaRecorder? = null

    fun start() {
        val dir = File(
            Environment.getExternalStorageDirectory(),
            "DialerRecords"
        )

        if (!dir.exists()) dir.mkdirs()

        val file = File(dir, "call_${System.currentTimeMillis()}.mp3")

        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(file.absolutePath)
            prepare()
            start()
        }
    }

    fun stop() {
        try {
            recorder?.stop()
            recorder?.release()
            recorder = null
        } catch (_: Exception) {}
    }
}