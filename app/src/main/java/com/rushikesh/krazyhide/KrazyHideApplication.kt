package com.rushikesh.krazyhide

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import com.rushikesh.krazyhide.service.ModelFiles
import com.rushikesh.krazyhide.service.CHANNEL_ID
import com.rushikesh.krazyhide.service.INIT_CHANNEL_ID
import java.io.File
import org.koin.android.ext.koin.androidContext
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class KrazyHideApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        createNotificationChannels()
        cleanOldGpuDelegateCaches()

        startKoin {
            androidContext(this@KrazyHideApplication)
            modules(KrazyHideApplicationModule().module)
        }
    }

    private fun createNotificationChannels() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        manager.createNotificationChannel(
            NotificationChannel(
                CHANNEL_ID,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_LOW
            )
        )

        val initChannel = NotificationChannel(
            INIT_CHANNEL_ID,
            getString(R.string.notification_channel_name_initializing),
            NotificationManager.IMPORTANCE_HIGH
        )
        initChannel.enableVibration(false)
        initChannel.vibrationPattern = longArrayOf(0L)
        initChannel.setSound(null, null)
        manager.createNotificationChannel(initChannel)
    }

    private fun cleanOldGpuDelegateCaches() = runCatching {
        val cacheRoot = File(filesDir, GPU_DELEGATE_CACHE_DIR_NAME)
        if (cacheRoot.exists()) cacheRoot.deleteRecursively()
    }

    companion object {
        private const val GPU_DELEGATE_CACHE_DIR_NAME = "gpu_delegate_cache"
    }
}

@Module
@ComponentScan("com.rushikesh.krazyhide")
class KrazyHideApplicationModule
