package com.jacknic.android.download

import android.app.DownloadManager
import android.app.DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
import android.content.Context
import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

/**
 * 文件下载
 * 使用DownloadManager下载，并监听下载进度
 * <i>参考链接 {@link  http://www.trinea.cn/android/android-downloadmanager/}</i>
 * <i>Android官网  https://developer.android.com/reference/android/app/DownloadManager</i>
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        btnDownload.setOnClickListener {
            val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val uri = Uri.parse("https://imtt.dd.qq.com/16891/68CF64B59AB1C0719D2DCB9DB0EFC03A.apk?fsname=com.tencent.mm_7.0.3_1400.apk")
            val request = DownloadManager.Request(uri)
            request.setDescription("正在下载微信app")
            request.setTitle("微信.apk")
            request.setNotificationVisibility(VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            val downloadId = downloadManager.enqueue(request)
            println("下载的ID为：$downloadId")
            val query = DownloadManager.Query().setFilterById(downloadId)
            contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, object : ContentObserver(Handler(Looper.getMainLooper())) {
                override fun onChange(selfChange: Boolean, uri: Uri?) {
                    val cursor = downloadManager.query(query)
                    if (cursor != null && cursor.moveToFirst()) {
                        val totalSize = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                        val downloadedSize = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                        val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                        if (status == DownloadManager.STATUS_RUNNING) {
                            progressBar.max = totalSize
                            progressBar.progress = downloadedSize
                            println("文件大小：$totalSize")
                            println("完成状态：$status")
                            println("已下载：$downloadedSize")
                        } else if (status == DownloadManager.STATUS_SUCCESSFUL) {
                            progressBar.progress = totalSize
                        }
                    }
                }
            })
        }
    }
}
