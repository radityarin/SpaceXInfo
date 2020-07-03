package com.radityarin.spacexinfo.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.AppWidgetTarget
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.repository.Repository
import com.radityarin.spacexinfo.util.Constant.UPDATE
import com.radityarin.spacexinfo.util.toast
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject


/**
 * Implementation of App Widget functionality.
 */
class NextLaunchWidget : AppWidgetProvider(), KoinComponent {
    private val appRepository by inject<Repository>()

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        appRepository.getCacheNextLaunch()?.let {
            updateAppWidget(context, appWidgetManager, appWidgetIds, it)
        }
    }

    private fun updateAppWidget(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?,
        launch: Launch?
    ) {
        appWidgetIds?.forEachIndexed { index, i ->
            val appWidgetId = appWidgetIds[index]
            val intent = Intent(context, javaClass).apply {
                action = UPDATE
            }
            val pendingIntentRefresh = PendingIntent.getBroadcast(context, 0, intent, 0)
            val intentWatchVideo = Intent(Intent.ACTION_VIEW, Uri.parse(launch?.links?.videoLink.toString()))
            val pendingIntentWatchVideo = PendingIntent.getActivity(context, 0, intentWatchVideo, 0)

            val views = RemoteViews(context?.packageName, R.layout.next_launch_widget)
            val target =
                AppWidgetTarget(context, R.id.iv_widget_mission_patches, views, appWidgetId)
            Glide.with(context?.applicationContext!!)
                .asBitmap()
                .load(launch?.links?.missionPatch)
                .placeholder(R.drawable.mission_patch_placeholder)
                .into(target)
            views.setTextViewText(R.id.tv_widget_launch_title, launch?.missionName)
            views.setTextViewText(R.id.tv_widget_launch_rocket, launch?.rocket?.rocketName)
            views.setTextViewText(R.id.tv_widget_launch_date, launch?.launchDateLocal)
            views.setOnClickPendingIntent(R.id.btn_widget_refresh_next_launch, pendingIntentRefresh)
            views.setOnClickPendingIntent(R.id.btn_widget_watch_video, pendingIntentWatchVideo)
            appWidgetManager?.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if (intent?.action == UPDATE) {
            appRepository.getNextLaunch().observeOn(Schedulers.io())
                .doOnSubscribe {
                    showToast(context, context?.getString(R.string.update_widget_label))
                }
                .subscribe({
                    showToast(context, context?.getString(R.string.update_widget_succeful_label))
                    updateData(context)
                }, {
                    showToast(context, context?.getString(R.string.update_widget_failed_label))
                    it.printStackTrace()
                })

        }

    }

    private fun showToast(context: Context?, message: String?) {
        message?.let { context?.toast(it) }
    }


    private fun updateData(context: Context?) {
        val appWidgetManager = AppWidgetManager.getInstance(context);
        val thisAppWidgetComponentName =
            ComponentName(context?.packageName.orEmpty(), javaClass.name)
        val appWidgetIds = appWidgetManager.getAppWidgetIds(
            thisAppWidgetComponentName
        )
        onUpdate(context, appWidgetManager, appWidgetIds);
    }

}